package com.kabms.hilttutorial

import android.util.Log

fun String.log() = println(this)

fun Any.log(msg: String) = Log.d(this.toString(), msg)

fun Any.log(function: () -> Unit) = Log.d(this.toString(), function.toString())