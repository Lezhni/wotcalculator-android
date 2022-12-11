package by.wotcalculator.application.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import by.wotcalculator.application.R;
import by.wotcalculator.application.domain.models.api.Tank;

public class TanksListAdapter extends ArrayAdapter<Tank> {

    private Context context;
    private int resource;

    public TanksListAdapter(Context context, int resource, ArrayList<Tank> items) {
        super(context, resource, items);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = (convertView != null)
                ? convertView
                : LayoutInflater.from(context).inflate(resource, null);

        TextView tankNameView = view.findViewById(R.id.list_tank_name);
        TextView tankDescView = view.findViewById(R.id.list_tank_desc);

        Tank tank = getItem(position);
        if (tank != null) {
            tankNameView.setText(tank.getName());
            tankDescView.setText(tank.getDescription());
        }

        return view;
    }
}
