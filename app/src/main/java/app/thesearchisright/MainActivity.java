package app.thesearchisright;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {


    Context context(){
        return this;
    }
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAnimals = (Button) findViewById(R.id.btnAnimals);
        Button btnResearch = (Button) findViewById(R.id.btnResearch);
        Button btnCompanies = (Button) findViewById(R.id.btnCompanies);
        Button btnCountries = (Button) findViewById(R.id.btnCountries);

        AdRequest request = new AdRequest.Builder().addTestDevice("DFDE70D214FA7B0514E76A9E1D06558E").build();
        MobileAds.initialize(getApplicationContext(),"ca-app-pub-4932297938957654/4354412526");
        mAdView = (AdView) findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();

        mAdView.loadAd(request);

        request.isTestDevice(this);
        btnAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<String> Animals = Arrays.asList(getResources().getStringArray(R.array.Animals));
                pass(Animals);

            }
        });

        btnResearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<String> Research = Arrays.asList(getResources().getStringArray(R.array.Research));
                pass(Research);
            }
        });

        btnCompanies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<String> Companies = Arrays.asList(getResources().getStringArray(R.array.Companies));
                pass(Companies);
            }

        });

        btnCountries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<String> Countries = Arrays.asList(getResources().getStringArray(R.array.Countries));
                pass(Countries);
            }

        });
    }

    void pass(List<String> s)
    {
        Random r = new Random();
        int a = r.nextInt(s.size());
        String[] an = (String[]) s.toArray();
        String result = an[a];
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("Q",result);
        try{
        startActivity(intent);}
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
