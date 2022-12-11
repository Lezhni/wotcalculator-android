package by.wotcalculator.application.retrofit;

import by.wotcalculator.application.domain.models.api.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface TankopediaAPI {
    @GET("encyclopedia/vehicles/?page_no=1&limit=10&fields=name,description")
    Call<ResponseBody> getAllTanks();
}