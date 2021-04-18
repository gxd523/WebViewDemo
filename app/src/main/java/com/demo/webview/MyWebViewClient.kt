package com.demo.webview

import android.net.http.SslError
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient

/**
 * Created by guoxiaodong on 4/16/21 10:53
 */
class MyWebViewClient : WebViewClient() {
    override fun onPageFinished(view: WebView?, url: String?) {
//        val cookieManager = CookieManager.getInstance()
//        val cookie = cookieManager.getCookie(url)
//        Log.d("gxd", "cookie = $cookie")
    }

    override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler, error: SslError?) {
        // 注意一定要去除这行代码，否则设置无效：super.onReceivedSslError(view, handler, error)
        // Android默认的处理方式：handler.cancel()
        handler.proceed()// 接受所有网站的证书
    }
}