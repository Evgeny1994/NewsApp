package instagram.downloader.com.newsapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import instagram.downloader.com.newsapp.Model.Articles;
import instagram.downloader.com.newsapp.Model.Headlines;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    final String API_KEY = "3dc047ec562a48819963a6d8a6a6f29c";
    Adapter adapter;
    List<Articles> articles = new ArrayList<>();
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final String country = getCountry();
        retrieveJson(country, API_KEY);
        swipeRefreshLayout = findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                retrieveJson(country, API_KEY);
            }
        });
    }


    private void retrieveJson(String country, String apiKey) {
        swipeRefreshLayout.setRefreshing(true);
        Call<Headlines> call = ApiClient.getApiClient().getApi().getHeadlines(country, apiKey);
        call.enqueue(new Callback<Headlines>() {
            @Override
            public void onResponse(Call<Headlines> call, Response<Headlines> response) {
                swipeRefreshLayout.setRefreshing(false);
                if (response.isSuccessful() && response.body().getArticles() != null) {
                    articles.clear();
                    articles = response.body().getArticles();
                    adapter = new Adapter(MainActivity.this, articles);
                    recyclerView.setAdapter(adapter);
                } else {

                    Log.i("error", String.valueOf(response.code()));
                }

            }

            @Override
            public void onFailure(retrofit2.Call<Headlines> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);


                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }


        });

    }

    private String getCountry() {
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        return country.toLowerCase();
    }
}
