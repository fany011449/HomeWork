package com.example.hw

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    var pageStatus : Int? = 0
    var userid : String? =""
    var passwd : String? =""
    var age : String? = ""
    var gender : String? = ""
    var nickname : String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (pageStatus == 0) selectPage(pageStatus)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            0 -> {
                if (resultCode == Activity.RESULT_OK) { //Q1
                    userid = data?.getStringExtra("EXTRA_UID")
                    passwd = data?.getStringExtra("EXTRA_PASS")
                    pageStatus = data?.getIntExtra("EXTRA_PAGE1",1)
                    selectPage(pageStatus)
                } else {
                    finish()
                }
            }
            1 -> {
                if (resultCode == Activity.RESULT_OK) {
                    nickname = data?.getStringExtra("EXTRA_NICK")
                    gender = data?.getStringExtra("EXTRA_GENDER")
                    age = data?.getStringExtra("EXTRA_AGE")
                    pageStatus = data?.getIntExtra("EXTRA_PAGE2",2)
                    selectPage(pageStatus)
                } else {
                    finish()
                }
            }
        }
    }
    private fun selectPage (pageStatus : Int?) {
        when(pageStatus) {
            0 -> {
                intent = Intent(this,LogActivity::class.java)
                startActivityForResult(intent,pageStatus)
            }
            1 -> {
               intent = Intent(this,ResgiterActivity::class.java)
                startActivityForResult(intent,pageStatus)
            }
            2 -> {
                Toast.makeText(this,"Hi $nickname your gender is $gender and $age old , BTW UID -> $userid , PASSWD -> $passwd !!",Toast.LENGTH_LONG).show()
            }
        }
    }

}
