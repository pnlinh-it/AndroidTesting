package com.example.myapplication

import timber.log.Timber

class ArgumentService {
    fun fetchData(callback: Callback) {
        Timber.e("fetchData")
        println("fetchData")

        callback.onResponse("HiGuy")
    }
}

interface Callback {
    fun onResponse(content: String)
}

fun multilineMethod(
    foo: String,
    bar: String
) {
    foo
        .length
}
