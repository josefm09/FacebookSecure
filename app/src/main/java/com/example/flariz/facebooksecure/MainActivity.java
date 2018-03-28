package com.example.flariz.facebooksecure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

  private WebView myWebView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getWindow().requestFeature(Window.FEATURE_NO_TITLE);

    //myWebView = findViewById(R.id.webview);
    myWebView = new WebView(this);
    myWebView.loadUrl("https://www.facebook.com");
    myWebView.setWebViewClient(new WebViewClient() {
      @Override
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
      }
    });

    this.setContentView(myWebView);
  }

  @Override
  public boolean onKeyDown(final int keyCode, final KeyEvent event) {
    if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
      myWebView.goBack();
      return true;
    }
    return super.onKeyDown(keyCode, event);
  }
}
