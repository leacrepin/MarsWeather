package com.infres.meteomars.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.infres.meteomars.R;
import com.infres.meteomars.model.Sol;

public class DetailActivity extends AppCompatActivity {

    private TextView tvName;
    private TextView tvTempAll;
    private TextView tvPressionAll;

    private Sol sol;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        this.tvName = findViewById(R.id.tvName);
        this.tvTempAll = findViewById(R.id.tvTempAll);
        this.tvPressionAll = findViewById(R.id.tvPressionAll);

        this.sol = (Sol) getIntent().getSerializableExtra("sol");

        String name = getResources().getString(R.string.sol_name) + sol.toString();
        this.tvName.setText(name);
        String temp_all = getResources().getString(R.string.sol_temperature) + " " +getResources().getString(R.string.avg)  + " " +  sol.getTemp_avg() + " " + getResources().getString(R.string.min)  + " " +  sol.getTemp_min() + " " + getResources().getString(R.string.max)  + " " +  sol.getTemp_max();
        this.tvTempAll.setText(temp_all);
        String pressure_all = getResources().getString(R.string.sol_pression) + " " +getResources().getString(R.string.avg)  + " " +  sol.getPression_avg() + " " + getResources().getString(R.string.min)  + " " +  sol.getPression_min() + " " + getResources().getString(R.string.max)  + " " +  sol.getPression_max();
        this.tvPressionAll.setText(pressure_all);
    }

}