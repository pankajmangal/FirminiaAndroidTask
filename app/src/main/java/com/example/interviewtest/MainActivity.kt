package com.example.interviewtest

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.interviewtest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), EventHandler {

    private lateinit var binding:ActivityMainBinding
    private lateinit var authViewModal: AuthViewModal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (isTablet(this)) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR
        }else{
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        authViewModal = ViewModelProvider(this).get(AuthViewModal::class.java)
        binding.authViewModel = authViewModal
        authViewModal.eventHandler = this
    }

    override fun onError(msg: String, type: Int) {
        if(type == 1){
            binding.tilEmail.error = msg
        }else if(type == 2){
            binding.tilEmail.error = ""
            binding.tilPass.error = msg
        }else if(type == 3){
            binding.tilEmail.error = ""
            binding.tilPass.error = ""
            binding.tilConfPass.error = msg
        }else{
            binding.tilEmail.error = ""
            binding.tilPass.error = ""
            binding.tilConfPass.error = ""
        }
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess(email: String) {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.apply {
            setMessage(email)
            setCancelable(false)
            setPositiveButton("OK") { dialog, id ->
                dialog.dismiss()
            }
            setNegativeButton("Cancel") { dialog, id ->
                dialog.dismiss()
            }
        }

        val alert = dialogBuilder.create()
        alert.setTitle("Welcome Alert")
        alert.show()
    }

    //important link for screen orientation of phone as well as tablet...
//    https://stackoverflow.com/questions/9627774/android-allow-portrait-and-landscape-for-tablets-but-force-portrait-on-phone
}