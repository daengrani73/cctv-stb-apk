
package net.alijaya.cctvmonitor

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    // GANTI IP INI DENGAN IP SERVER CCTV-MONITORING MU
    private val DEFAULT_URL = "http://192.168.1.100:3003"

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        webView = WebView(this)
        setContentView(webView)

        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            allowFileAccess = true
            allowContentAccess = true
            mediaPlaybackRequiresUserGesture = false
            cacheMode = WebSettings.LOAD_NO_CACHE
            mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            useWideViewPort = true
            loadWithOverviewMode = true
            javaScriptCanOpenWindowsAutomatically = true
        }
        // Penting buat STB Android 6 WebView jadul
        webView.settings.userAgentString = webView.settings.userAgentString + " STB-CCTV-Monitor/1.0"

        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()

        // Fokus buat remote STB
        webView.isFocusable = true
        webView.isFocusableInTouchMode = true
        webView.requestFocus()

        webView.loadUrl(DEFAULT_URL)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    // Handle DPAD remote STB
    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        // Biar WebView tetap dapet event DPAD
        return super.dispatchKeyEvent(event)
    }
}
