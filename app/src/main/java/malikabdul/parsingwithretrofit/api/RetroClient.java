package malikabdul.parsingwithretrofit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by malikabdul on 14/03/18.
 */

public class RetroClient {
    /********
     * URLS
     *******/
    private static final String ROOT_URL = "http://api.androiddeft.com/";
    private static final String ROOT_URL1 = "http://trackingeye.tk/";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL1)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }
}
