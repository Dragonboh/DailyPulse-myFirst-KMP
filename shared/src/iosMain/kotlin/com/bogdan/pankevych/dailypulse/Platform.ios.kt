package com.bogdan.pankevych.dailypulse

import platform.Foundation.NSLog
import platform.UIKit.UIDevice
import platform.UIKit.UIScreen
import kotlin.math.round

//class IOSPlatform: Platform {
//    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
//}
//
//actual fun getPlatform(): Platform = IOSPlatform()


actual class Platform actual constructor() {
    actual val osName = UIDevice.currentDevice.systemName
    actual val osVersion = UIDevice.currentDevice.systemVersion
    actual val deviceModel = UIDevice.currentDevice.model
    actual val density = UIScreen.mainScreen.scale.toInt()
    actual fun logSystemInfo() {
        NSLog("$osName $osVersion $deviceModel $density")
    }

}
