package com.santoni7.cleanarchgame.util

import java.net.InetAddress
import java.net.UnknownHostException
import java.util.concurrent.*

fun isOnline(timeOut: Long): Boolean {
    var inetAddress: InetAddress? = null
    try {
        val future = Executors.newSingleThreadExecutor().submit(Callable<InetAddress> {
            try {
                InetAddress.getByName("google.com")
            } catch (e: UnknownHostException) {
                null
            }
        })
        inetAddress = future.get(timeOut, TimeUnit.MILLISECONDS)
        future.cancel(true)
    } catch (e: InterruptedException) {
    } catch (e: ExecutionException) {
    } catch (e: TimeoutException) {
    }

    return inetAddress != null && !inetAddress.equals("")
}