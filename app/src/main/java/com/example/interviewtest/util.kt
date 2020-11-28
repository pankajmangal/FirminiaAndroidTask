package com.example.interviewtest

import android.content.Context
import android.text.TextUtils
import android.util.Patterns


fun isValidEmail(target: CharSequence?): Boolean {
    return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target!!).matches()
}

fun isTablet(context: Context): Boolean {
    return context.resources.getBoolean(R.bool.isTablet)
}