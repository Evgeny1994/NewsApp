package instagram.downloader.com.newsapp;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Евгений on 17.04.2023.
 */

public class ApiClient {
    private static final String BASE_URL="https://calendarific.com/api/v2/";
    private static ApiClient apiClient;
    private static Retrofit retrofit;

    private ApiClient()
    {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized ApiClient getApiClient()
    {
        if (apiClient == null)
        {
           apiClient = new ApiClient();
        }
        return apiClient;
    }

    public ApiInterface getApi()
    {
        return retrofit.create(ApiInterface.class);
    }

}
