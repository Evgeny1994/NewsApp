package instagram.downloader.com.newsapp;

import instagram.downloader.com.newsapp.Model.Headlines;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Евгений on 17.04.2023.
 */

public interface ApiInterface {
    @GET("top-headlines")
    Call<Headlines> getHeadlines(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );

    @GET("everything")
    Call<Headlines> getSpecificData(
            @Query("q") String country,
            @Query("apiKey") String apiKey
    );




}
