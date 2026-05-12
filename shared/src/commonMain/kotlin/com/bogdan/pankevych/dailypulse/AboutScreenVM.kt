package com.bogdan.pankevych.dailypulse

class AboutScreenVM {
    fun getItems(): List<Pair<String, String>> {
        val platform = Platform()
        platform.logSystemInfo()

        return listOf(
            Pair("Operating System", "${platform.osName} ${platform.osVersion}"),
            Pair("Device", platform.deviceModel),
            Pair("Density", platform.density.toString())
        )
    }
}
