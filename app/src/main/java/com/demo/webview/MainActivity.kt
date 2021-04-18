package com.demo.webview

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.webkit.WebView


class MainActivity : Activity() {
    private val mWebView by lazy {
        WebView(this.applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val urls = arrayOf(
            "https://zc.reg.163.com/regInitialized?pd=urs&pkid=PSANoGn&pkht=reg.163.com&onlyNetease=1#/",
            "file:///android_asset/index1.html",
            "file:///android_asset/index2.html"
        )

        mWebView.apply {
            webViewClient = MyWebViewClient()
            webChromeClient = MyWebChromeClient()
            settings.apply {
                javaScriptEnabled = true
                javaScriptCanOpenWindowsAutomatically = true
                addJavascriptInterface(MyJavascriptInterface(), "aaa")
            }
            loadUrl(urls[1])
        }.let(::setContentView)

        mWebView.postDelayed({
            mWebView.evaluateJavascript("javascript:callJS('我来自Android')") {
                Log.d("gxd", "callJS方法的返回数据...$it")
            }
        }, 1000)
    }

    override fun onResume() {
        mWebView.onResume()
        mWebView.resumeTimers()
        super.onResume()
    }

    override fun onPause() {
        mWebView.onPause()
        mWebView.pauseTimers()
        super.onPause()
    }

    override fun onDestroy() {
        mWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null)
        mWebView.clearHistory()
        (mWebView.parent as ViewGroup).removeView(mWebView)
        mWebView.destroy()
        super.onDestroy()
    }
}