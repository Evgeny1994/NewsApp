package instagram.downloader.com.newsapp;


import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class detailed extends AppCompatActivity {
    TextView tvTitle;
    TextView tvSource;
    TextView tvTime;
    TextView tvDesc;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        tvTitle = findViewById(R.id.tvTitle);
        tvSource = findViewById(R.id.tvSource);
        tvTime = findViewById(R.id.tvTime);
        tvDesc = findViewById(R.id.tvDesc);
        webView = findViewById(R.id.webView);
    }
}
