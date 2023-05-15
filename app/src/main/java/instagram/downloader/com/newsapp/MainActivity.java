package instagram.downloader.com.newsapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

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
    final String api_key = "4030c487dc1c57df4d4df48097cd7471a7801d16";
    final String country = "US";
    final Integer year = 2019;
    Adapter adapter;
    List<Articles> articles = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        retrieveJson(api_key, country, year);
    }


    private void retrieveJson(String api_key, String country, Integer year) {
        Call<Headlines> call = ApiClient.getApiClient().getApi().getHeadlines(api_key, country, year);
        call.enqueue(new Callback<Headlines>() {
            @Override
            public void onResponse(Call<Headlines> call, Response<Headlines> response) {
                if (response.isSuccessful() && response.body().getArticles() != null) {
                    articles.clear();
                    articles = response.body().getArticles();
                    adapter = new Adapter(MainActivity.this, articles);
                    recyclerView.setAdapter(adapter);
                } else {
                    System.out.println(call.request());
                    Log.i("error", String.valueOf(response.message()));
                }
            }

            @Override
            public void onFailure(retrofit2.Call<Headlines> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
