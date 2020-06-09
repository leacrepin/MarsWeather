package com.infres.meteomars.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import com.infres.meteomars.R;
import com.infres.meteomars.model.Sol;

public class SolAdapter extends ArrayAdapter<Sol> {

    private List<Sol> sols;
    private Context context;
    private LayoutInflater inflater;


    public SolAdapter(Context context, List<Sol> sols) {
        super(context, -1, sols);
        this.inflater = LayoutInflater.from(context);
        this.sols = sols;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = this.inflater.inflate(R.layout.sol_line, parent, false);

            TextView tvName = convertView.findViewById(R.id.tvName);
            TextView tvMagnitude = convertView.findViewById(R.id.tvTemp);
            TextView tvDistance = convertView.findViewById(R.id.tvPression);

            MyHolder holder = new MyHolder();
            holder.tvName = tvName;
            holder.tvTemp = tvDistance;
            holder.tvPression = tvMagnitude;

            convertView.setTag(holder);
        }

        MyHolder holder = (MyHolder) convertView.getTag();

        Sol sol= this.sols.get(position);
        String name = context.getResources().getString(R.string.sol_name)  + sol.toString();
        holder.tvName.setText(name);
        String temp = context.getResources().getString(R.string.sol_temperature)  + " " +  sol.getTemp_avg();
        holder.tvTemp.setText(temp);
        String pressure = context.getResources().getString(R.string.sol_pression)  + " " +  sol.getPression_avg();
        holder.tvPression.setText(pressure);

        return convertView;
    }


    private class MyHolder {
        TextView tvName;
        TextView tvTemp;
        TextView tvPression;
    }
}
