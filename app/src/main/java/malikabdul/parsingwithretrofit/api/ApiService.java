package malikabdul.parsingwithretrofit.api;

import malikabdul.parsingwithretrofit.beans.MarkerList;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by malikabdul on 14/03/18.
 */

public interface ApiService {

    @GET("trackingeye/getusers.php")
    Call<Users> getMyJSON1();

    @GET("retrofit/json_object.json")
    Call<EmployeeList> getMyJSON();

    @GET("trackingeye/GetMarkers.php")
    Call<MarkerList> getMyJSONMarker();
}
