package com.santoni7.cleanarchgame.util

import android.util.Base64
import android.util.Base64.URL_SAFE
import android.util.Log
import java.io.UnsupportedEncodingException
import java.nio.charset.Charset


object JWTUtils {

    @Throws(Exception::class)
    fun decoded(JWTEncoded: String) {
        try {
            val split = JWTEncoded.split("\\.")
            Log.d("JWT_DECODED", "Header: " + getJson(split[0]))
            Log.d("JWT_DECODED", "Body: " + getJson(split[1]))
        } catch (e: UnsupportedEncodingException) {
        }

    }

    @Throws(UnsupportedEncodingException::class)
    private fun getJson(strEncoded: String): String {
        val decodedBytes = Base64.decode(strEncoded, URL_SAFE)
        return String(decodedBytes)
    }
}