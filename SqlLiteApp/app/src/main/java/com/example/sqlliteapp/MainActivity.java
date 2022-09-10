package com.example.sqlliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Country> countries;
    SQLiteDatabaseHandler db;
    Button btnSubmit;
    PopupWindow pwindo;
    Activity activity;
    ListView listView;
    CustomCountryAdapter customCountryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        activity=this;
        db= new SQLiteDatabaseHandler(this);
        listView = (ListView) findViewById(R.id.listViewCountry);
        btnSubmit = (Button) findViewById(R.id.btnAddCountry);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPopUp();
            }
        });
        Log.d("MainActivity: ", "Before reading mainactivity");
        countries = (ArrayList) db.getAllCountries();

        for (Country country : countries) {
            String log = "Id: " + country.getId() + " ,Name: " + country.getCountryName() + " ,Population: " + country.getPopulation();
            // Writing Countries to log
            Log.d("Name: ", log);
        }

        CustomCountryAdapter customCountryList = new CustomCountryAdapter(this, countries, db);
        listView.setAdapter(customCountryList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(), "You Selected " + countries.get(position).getCountryName() + " as Country", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addPopUp() {
        LayoutInflater inflater = activity.getLayoutInflater();
        View layout = inflater.inflate(R.layout.add_new_country,
                (ViewGroup) activity.findViewById(R.id.addNewPopup));
        pwindo = new PopupWindow(layout, 600, 670, true);
        pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
        final EditText countryEdit = (EditText) layout.findViewById(R.id.edCountry);
        final EditText populationEdit = (EditText) layout.findViewById(R.id.edPopulation);

        Button save = (Button) layout.findViewById(R.id.btnSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String countryStr = countryEdit.getText().toString();
                String population = populationEdit.getText().toString();
                Country country = new Country(countryStr, Long.parseLong(population));
                db.addCountry(country);
                if(customCountryList==null)
                {
                    customCountryList = new CustomCountryAdapter(activity, countries, db);
                    listView.setAdapter(customCountryList);
                }
                customCountryList.countries = (ArrayList) db.getAllCountries();
                ((BaseAdapter)listView.getAdapter()).notifyDataSetChanged();
                for (Country country1 : countries) {
                    String log = "Id: " + country1.getId() + " ,Name: " + country1.getCountryName() + " ,Population: " + country1.getPopulation();
                    // Writing Countries to log
                    Log.d("Name: ", log);
                }
                pwindo.dismiss();
            }
        });
    }
}