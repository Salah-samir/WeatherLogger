package com.samir.weatherlogger.data.network

import android.content.Context
import android.net.ConnectivityManager
import com.samir.weatherlogger.WeatherLoggerApplication.Companion.appContext
import com.samir.weatherlogger.internal.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class ConnectivityInterceptorImpl @Inject constructor(context : Context) : ConnectivityInterceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        if(!isOnline())
                throw NoConnectivityException()
        return chain.proceed(chain.request())
    }

    private fun isOnline() : Boolean{
        val connectivityManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE)
        as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
    

}