
package net.alijaya.cctvmonitor

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    private val DEFAULT_URL = "http://192.168.1.100:3003"

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Layout gabungan: top bar + webview
        val root = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }
        val topBar = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            setPadding(10,10,10,10)
        }
        val btnDashboard = Button(this).apply { text = "DASHBOARD" }
        val btnRtsp = Button(this).apply { text = "RTSP DIRECT" }
        val btnReload = Button(this).apply { text = "RELOAD" }

        topBar.addView(btnDashboard)
        topBar.addView(btnRtsp)
        topBar.addView(btnReload)

        webView = WebView(this)
        root.addView(topBar)
        root.addView(webView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        setContentView(root)

        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            allowFileAccess = true
            mediaPlaybackRequiresUserGesture = false
            mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            useWideViewPort = true
            loadWithOverviewMode = true
            cacheMode = WebSettings.LOAD_NO_CACHE
        }
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()
        webView.isFocusable = true
        webView.requestFocus()

        btnDashboard.setOnClickListener { webView.loadUrl(DEFAULT_URL) }
        btnRtsp.setOnClickListener { startActivity(Intent(this, RtspPlayerActivity::class.java)) }
        btnReload.setOnClickListener { webView.reload() }

        webView.loadUrl(DEFAULT_URL)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}
