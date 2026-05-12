package com.bogdan.pankevych.dailypulse

import android.content.res.Resources
import android.os.Build
import kotlin.math.round

//class AndroidPlatform : Platform {
//    override val name: String = "Android ${Build.VERSION.SDK_INT}"
//}
//
//actual fun getPlatform(): Platform = AndroidPlatform()

actual class Platform actual constructor() {
    actual val osName = "Android"
    actual val osVersion = "${Build.VERSION.SDK_INT}"
    actual val deviceModel = "${Build.MANUFACTURER} ${Build.MODEL}"
    actual val density = round(Resources.getSystem().displayMetrics.density).toInt()
    actual fun logSystemInfo() {
        LoggerKT.d(tag = "Daily Pulse", msg = "$osName $osVersion $deviceModel $density")
    }

}
