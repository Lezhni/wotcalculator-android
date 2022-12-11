package by.wotcalculator.application.data.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.HashMap;

import by.wotcalculator.application.domain.models.api.ResponseBody;
import by.wotcalculator.application.domain.models.api.Tank;
import by.wotcalculator.application.retrofit.RetrofitService;
import by.wotcalculator.application.retrofit.TankopediaAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TankopediaRepository {

    // TODO : Inject with Dagger
    private final TankopediaAPI tankopediaAPI;

    private final MutableLiveData<ArrayList<Tank>> tanksList = new MutableLiveData<>();

    public TankopediaRepository() {
        tankopediaAPI = RetrofitService.getTankopediaApi();
    }

    public MutableLiveData<ArrayList<Tank>> getTanksList() {
        Call<ResponseBody> request = tankopediaAPI.getAllTanks();
        request.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(
                    @NonNull Call<ResponseBody> call,
                    @NonNull Response<ResponseBody> response
            ) {
                if (response.isSuccessful()) {
                    ResponseBody responseBody = response.body();
                    if (responseBody != null) {
                        HashMap<Integer, Tank> tanksHashMap = responseBody.getData();
                        ArrayList<Tank> tanks = new ArrayList<>(tanksHashMap.values());
                        tanksList.postValue(tanks);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                tanksList.postValue(null);
            }
        });

        return this.tanksList;
    }
}
