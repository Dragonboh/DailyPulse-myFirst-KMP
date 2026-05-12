package com.bogdan.pankevych.dailypulse

import android.util.Log

class LoggerKT {
    companion object {
        fun d(tag: String, msg: String) {
            Log.d(tag, msg)
        }
    }
}
