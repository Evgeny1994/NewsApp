package instagram.downloader.com.newsapp;

import instagram.downloader.com.newsapp.Model.Headlines;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Евгений on 17.04.2023.
 */

public interface ApiInterface {
    @GET("holidays")
    Call<Headlines> getHeadlines(
            @Query("api_key") String api_key,
            @Query("country") String country,
            @Query("year") Integer year
    );




}
