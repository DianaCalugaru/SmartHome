package com.example.smarthome.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smarthome.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class VremeParsare extends AppCompatActivity {


    private EditText oras;
    private Button buton;

    private Button butonback;

    private static final String BASE_URL = "http://dataservice.accuweather.com/";
    private static final String API_KEY = "gkwFGGCtwS5EAR2pBVUegG13oWd4G4h9";

    private TextView mesaj_json;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vreme_parsare);

        oras = findViewById(R.id.idoras);
        buton = findViewById(R.id.button);
        mesaj_json=findViewById(R.id.text_message1);
        butonback=findViewById(R.id.button7);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Oras = oras.getText().toString();
                new GetCityCodeTask().execute(Oras);

            }
        });

        butonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(VremeParsare.this, MainActivity4.class);
                startActivity(intent);
            }
        });
    }

    private class GetCityCodeTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String cityName = params[0];
            String cityCode = null;

            try {
                String url = BASE_URL + "locations/v1/cities/search?apikey=" + API_KEY + "&q=" + URLEncoder.encode(cityName, "UTF-8");
                HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }

                JSONArray jsonArray = new JSONArray(sb.toString());

                if (jsonArray.length() > 0) {
                    JSONObject cityObject = jsonArray.getJSONObject(0);
                    cityCode = cityObject.getString("Key");

                    System.out.println("cheia ");
                    System.out.println(cityCode);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return cityCode;
        }

        @Override
        protected void onPostExecute(String cityCode) {
            if (cityCode != null) {
                new GetWeatherTask().execute(cityCode);
            }
        }
    }

    private class GetWeatherTask extends AsyncTask<String, Void, JSONObject> {

        @Override
        protected JSONObject doInBackground(String... params) {
            String cityCode = params[0];
            JSONObject weatherObject = null;

            try {
                String url = BASE_URL + "forecasts/v1/daily/1day/" + cityCode + "?apikey=" + API_KEY;
                HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }

                JSONObject jsonObject = new JSONObject(sb.toString());
                JSONObject forecastObject = jsonObject.getJSONArray("DailyForecasts").getJSONObject(0);

                String date = forecastObject.getString("Date");
                JSONObject temperatureObject = forecastObject.getJSONObject("Temperature");
                JSONObject maximumObject = temperatureObject.getJSONObject("Maximum");
                double maximumValue = maximumObject.getDouble("Value");
                JSONObject minimumObject = temperatureObject.getJSONObject("Minimum");
                double minimumValue = minimumObject.getDouble("Value");

                weatherObject = new JSONObject();
                weatherObject.put("date", date);
                weatherObject.put("maximum_temperature", maximumValue);
                weatherObject.put("minimum_temperature", minimumValue);

            } catch (Exception e) {
                e.printStackTrace();
            }

            return weatherObject;
        }

        @Override
        protected void onPostExecute(JSONObject weatherObject) {
            if (weatherObject != null) {
                try {
                    String date = weatherObject.getString("date");
                    double maximumTemperature = weatherObject.getDouble("maximum_temperature");
                    double minimumTemperature = weatherObject.getDouble("minimum_temperature");
                    System.out.println("Temp maxima");
                    System.out.println(maximumTemperature);
                    String formattedWeather = "For the date " + date + ", the maximum temperature will be " + maximumTemperature + " and the minimum temperature will be " + minimumTemperature + ".";
                    System.out.println( formattedWeather);
//                    Toast.makeText(VremeParsare.this, formattedWeather, Toast.LENGTH_SHORT).show();
                    mesaj_json.setText(formattedWeather);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
//                Toast.makeText(VremeParsare.this, "Failed to get weather", Toast.LENGTH_SHORT).show();
                mesaj_json.setText("Failed to get weather");
            }
        }
    }
}