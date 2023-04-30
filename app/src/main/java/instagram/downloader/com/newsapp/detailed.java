package instagram.downloader.com.newsapp;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;




import androidx.appcompat.app.AppCompatActivity;

public class detailed extends AppCompatActivity {
    TextView tvTitle;
    TextView tvSource;
    TextView tvTime;
    TextView tvDesc;
    WebView webView;
    ImageView imageView;
    ProgressBar loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        tvTitle = findViewById(R.id.tvTitle);
        tvSource = findViewById(R.id.tvSource);
        tvTime = findViewById(R.id.tvTime);
        tvDesc = findViewById(R.id.tvDesc);
        webView = findViewById(R.id.webView);
        imageView = findViewById(R.id.imageView);
        loader = findViewById(R.id.loader);

        loader.setVisibility(View.VISIBLE);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String source = intent.getStringExtra("source");
        String time = intent.getStringExtra("time");
        String desc = intent.getStringExtra("desc");
        String imageUrl = intent.getStringExtra("imageUrl");
        String url = intent.getStringExtra("url");

        tvTitle.setText(title);
        tvSource.setText(source);
        tvTime.setText(time);
      //  tvDate.setText(desc);

       // Picasso.get().load(imageUrl).into(imageView);
      //  Glide.with(this)
        //        .load(imageUrl)

          //      .error(Log.i("Ошибка","ошибка загрузки изображения"))  //optional
         //       .into(imageView);
    }
}
