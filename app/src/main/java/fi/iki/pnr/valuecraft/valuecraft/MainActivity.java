package fi.iki.pnr.valuecraft.valuecraft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    void changeSettings() {
        final Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String poc = sharedPref.getString(SettingsActivity.KEY_PREF_POC, "");

        /* This while loop is braindead, should be replaced with proper listening... */
        while (poc.isEmpty()) {
            changeSettings();
            poc = sharedPref.getString(SettingsActivity.KEY_PREF_POC, "");
        }

        WebView.setWebContentsDebuggingEnabled(true);

        WebView webView = (WebView) findViewById(R.id.webView);
        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setAllowFileAccess(true);
        ws.setDomStorageEnabled(true);
        ws.setDatabaseEnabled(true);
        ws.setAppCachePath("/data/data/" + getPackageName() + "/cache/");
        ws.setAppCacheEnabled(true);
        ws.setJavaScriptCanOpenWindowsAutomatically(true);

        webView.setHorizontalScrollBarEnabled(false);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });
        webView.loadUrl("https://" + poc + ".trustlines.network");
    }
}
