package malikabdul.parsingwithretrofit.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by malikabdul on 17/03/18.
 */

public class MarkerList {
    @SerializedName("wisata")
    @Expose
    private ArrayList<Marker> wisata = null;

    public ArrayList<Marker> getWisata() {
        return wisata;
    }

    public void setWisata(ArrayList<Marker> wisata) {
        this.wisata = wisata;
    }
}
