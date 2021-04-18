package com.demo.webview

import android.util.Log
import android.webkit.JavascriptInterface
import android.widget.Toast


/**
 * 在Android4.2以下有安全漏洞
 */
class MyJavascriptInterface {
    @JavascriptInterface
    fun hello(msg: String?): String {
        val msgFormat = "hello...$msg"
        Log.d("gxd", msgFormat)
        Toast.makeText(MyApplication.instance, msgFormat, Toast.LENGTH_SHORT).show()
        return "Android return data"
    }
}