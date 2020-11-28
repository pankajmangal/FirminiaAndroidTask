package com.example.interviewtest

import android.text.TextUtils
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModal() : ViewModel() {

    var email:String ?= null
    var pass:String ?= null
    var confPass:String ?= null

    lateinit var eventHandler:EventHandler

    fun checkFields(view : View){
        Log.e("onpress", "click")
        if(TextUtils.isEmpty(email)){
            eventHandler.onError("Please enter email address", 1)
        }else  if(!isValidEmail(email)){
            eventHandler.onError("Please enter valid email", 1)
        }else  if(TextUtils.isEmpty(pass)){
            eventHandler.onError("Please enter password", 2)
        }else  if(pass!!.length < 8){
            eventHandler.onError("Please enter valid password", 2)
        }else  if(TextUtils.isEmpty(confPass)){
            eventHandler.onError("Please enter confirm password",3)
        }else if(!pass.equals(confPass)){
            eventHandler.onError("Password does not match !!", 3)
        }else{
            eventHandler.onSuccess(email!!)
        }
    }

}