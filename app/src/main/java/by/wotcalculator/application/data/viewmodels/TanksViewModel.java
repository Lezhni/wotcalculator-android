package by.wotcalculator.application.data.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import by.wotcalculator.application.data.repositories.TankopediaRepository;
import by.wotcalculator.application.domain.models.api.Tank;

public class TanksViewModel extends ViewModel {

    // TODO : Inject with Dagger
    private TankopediaRepository tankopediaRepository;

    private MutableLiveData<ArrayList<Tank>> tanksList;

    public TanksViewModel() {
        tankopediaRepository = new TankopediaRepository();
        tanksList = tankopediaRepository.getTanksList();
    }

    public LiveData<ArrayList<Tank>> getLiveData() {
        return tanksList;
    }
}
