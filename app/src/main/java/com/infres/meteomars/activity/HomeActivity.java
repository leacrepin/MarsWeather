package com.infres.meteomars.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import com.infres.meteomars.R;
import com.infres.meteomars.adapter.SolAdapter;
import com.infres.meteomars.model.Sol;
import com.infres.meteomars.service.NasaAPIService;
import com.infres.meteomars.service.OnError;
import com.infres.meteomars.service.OnResponse;

public class HomeActivity extends AppCompatActivity {

    private NasaAPIService nasaAPIService;

    private ListView lvSols;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.lvSols = findViewById(R.id.lvSols);

        Toast.makeText(this, "HOME LOADED", Toast.LENGTH_SHORT).show();

        nasaAPIService = NasaAPIService.getInstance(getApplicationContext());

        nasaAPIService.getSolsPromise()
                .then(new OnResponse<List<Sol>>() {
                    @Override
                    public void execute(final List<Sol> sols) {
                        String text = getResources().getString(R.string.sol_nb) + " " + sols.size();
                        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                        ArrayAdapter<Sol> adapter = new SolAdapter(
                                getApplicationContext(),
                                sols
                        );

                        lvSols.setAdapter(adapter);

                        lvSols.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                                intent.putExtra("sol", sols.get(position));
                                startActivity(intent);
                            }
                        });

                    }
                }).catchError(new OnError() {
            @Override
            public void execute(String errorMessage) {
                Toast.makeText(getApplicationContext(), "ERROR: " + errorMessage, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
