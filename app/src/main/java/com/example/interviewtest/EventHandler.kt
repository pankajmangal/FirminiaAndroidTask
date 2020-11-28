package com.example.interviewtest

interface EventHandler {
    fun onError(msg:String, type:Int)
    fun onSuccess(email:String)
}