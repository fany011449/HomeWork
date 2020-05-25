package com.example.hw

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_resgiter.*

class ResgiterActivity : AppCompatActivity() {
    var nickname : String? = ""
    var gender : String? = ""
    var age : String? = ""
    var pageCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resgiter)
        tvInputTitle.text = "Enter your Nickname : "
//        nickname = etUserSetting.text.toString()
//        Toast.makeText(this, "$nickname",Toast.LENGTH_SHORT).show()

    }

    fun nextInput(v : View){
        Toast.makeText(this,"$pageCounter",Toast.LENGTH_SHORT).show()
        if (etUserSetting.text.toString() == "") {
            AlertDialog.Builder(this)
                .setTitle("通知!")
                .setMessage("請輸入資料")
                .setPositiveButton("OK",null)
                .show()
        } else {
            when (pageCounter) {
                0 -> {
                    nickname = etUserSetting.text.toString()
                    if(nickname != null ) {
                        intent.putExtra("EXTRA_NICK",nickname)
                        pageCounter += 1
                    }
                    etUserSetting.setText("")
                    tvInputTitle.text = "Enter your Gender : "
                }
                1 -> {
                    gender = etUserSetting.text.toString()
                    if(gender != null ) {
                        intent.putExtra("EXTRA_GENDER",gender)
                        pageCounter += 1
                    }
                    etUserSetting.setText("")
                    tvInputTitle.text = "Enter your Age : "
                }
                2 -> {
                    age = etUserSetting.text.toString()
                    if(age != null ) {
                        intent.putExtra("EXTRA_AGE",age)
                        pageCounter += 1
                    }
                    intent.putExtra("EXTRA_PAGE2",2)
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
            }
        }
    }
    fun nickNameSetting() {
        tvInputTitle.text = "Enter your Nickname : "
        nickname = etUserSetting.text.toString()
        if(nickname != null ) pageCounter += 1
    }
    fun genderSetting() {
        tvInputTitle.text = "Enter your Gender : "
        gender = etUserSetting.text.toString()
        if(gender != null ) {
            intent.putExtra("EXTRA_GENDER",gender)
            pageCounter += 1
        }
        etUserSetting.setText("")
    }
    fun ageSetting() {
        tvInputTitle.text = "Enter your Age : "
        age = etUserSetting.text.toString()
        if(age != null ) {
            intent.putExtra("EXTRA_AGE",age)
            pageCounter += 1
        }
        etUserSetting.setText("")
    }
}
