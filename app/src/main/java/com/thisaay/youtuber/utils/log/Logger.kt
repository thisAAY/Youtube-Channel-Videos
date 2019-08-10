package com.thisaay.youtuber.utils.log

import android.os.Debug
import android.util.Log
import com.thisaay.youtuber.BuildConfig

object Logger {

    private var shouldLog  = false
    init {
        if(BuildConfig.DEBUG)
            shouldLog = true
    }

    fun d (tag : String ,message : String)  = if (shouldLog) Log.d(tag,message) else -1
    fun d (tag : String ,message : String,e :  Throwable) = if (shouldLog) Log.d(tag,message,e) else -1

    fun e (tag : String ,message : String)  = if (shouldLog) Log.e(tag,message) else -1
    fun e (tag : String ,message : String,e :  Throwable) = if (shouldLog) Log.e(tag,message,e) else -1

    fun v (tag : String ,message : String)  = if (shouldLog) Log.v(tag,message) else -1
    fun v (tag : String ,message : String,e :  Throwable) = if (shouldLog) Log.v(tag,message,e) else -1

    fun w (tag : String ,message : String)  = if (shouldLog) Log.w(tag,message) else -1
    fun w (tag : String ,message : String,e :  Throwable) = if (shouldLog) Log.w(tag,message,e) else -1

    fun i (tag : String ,message : String)  = if (shouldLog) Log.i(tag,message) else -1
    fun i (tag : String ,message : String,e :  Throwable) = if (shouldLog) Log.i(tag,message,e) else -1


}