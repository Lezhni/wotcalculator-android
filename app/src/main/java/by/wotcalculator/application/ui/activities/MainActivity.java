package by.wotcalculator.application.ui.activities;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import by.wotcalculator.application.R;
import by.wotcalculator.application.data.viewmodels.TanksViewModel;
import by.wotcalculator.application.ui.adapters.TanksListAdapter;

public class MainActivity extends AppCompatActivity {

    protected ListView tanksListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanksListView = findViewById(R.id.tanks_list);

        TanksViewModel tanksViewModel = new ViewModelProvider(this).get(TanksViewModel.class);
        tanksViewModel.getLiveData().observe(this, tanks -> {
            if (tanks != null) {
                TanksListAdapter adapter = new TanksListAdapter(this, R.layout.tanks_list_item, tanks);
                tanksListView.setAdapter(adapter);
            }
        });
    }
}