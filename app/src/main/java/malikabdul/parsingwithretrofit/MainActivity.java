package malikabdul.parsingwithretrofit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import malikabdul.parsingwithretrofit.adapter.MarkerAdapter;
import malikabdul.parsingwithretrofit.api.ApiService;
import malikabdul.parsingwithretrofit.api.RetroClient;
import malikabdul.parsingwithretrofit.beans.Marker;
import malikabdul.parsingwithretrofit.beans.MarkerList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Marker> markers;
    private ProgressDialog dialog;
    private RecyclerView recyclerView;
    private MarkerAdapter eAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(MainActivity.this);
        dialog.setMessage("Loading Data.. Please wait...");
        dialog.setIndeterminate(false);
        dialog.setCancelable(false);
        dialog.show();

        //Creating an object of our api interface
        ApiService api = RetroClient.getApiService();

        /**
         * Calling JSON
         */
        Call<MarkerList> call = api.getMyJSONMarker();

        /**
         * Enqueue Callback will be call when get response...
         */
        call.enqueue(new Callback<MarkerList>() {
            @Override
            public void onResponse(Call<MarkerList> call, Response<MarkerList> response) {
                //Dismiss Dialog
                dialog.dismiss();

                if (response.isSuccessful()) {
                    /**
                     * Got Successfully
                     */
                    markers = response.body().getWisata();
                    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
                    eAdapter = new MarkerAdapter(markers);
                    RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(eLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(eAdapter);
                    Toast.makeText(MainActivity.this, "kk"+markers, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MarkerList> call, Throwable t) {
                dialog.dismiss();
            }
        });
    }
}
