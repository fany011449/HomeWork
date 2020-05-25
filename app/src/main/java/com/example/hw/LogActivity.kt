package com.example.hw

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_logactivity.*

class LogActivity : AppCompatActivity() {
    var counterForClick = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logactivity)
        val userid =
            getSharedPreferences("login",Context.MODE_PRIVATE)
                .getString("ACCOUNT","")
        val pass =
            getSharedPreferences("login",Context.MODE_PRIVATE)
                .getString("PASSWORD","")
        etAccount.setText(userid)
        etPassWord.setText(pass)
    }
    fun userLogin(v: View) {
        val accountInput = etAccount.text.toString()
        val passwordInput  = etPassWord.text.toString()
        if(counterForClick == 3) {
            AlertDialog.Builder(this)
                .setTitle("通知")
                .setMessage("登入失敗3次!! 掰掰")
                .setPositiveButton("OK",null)
                .show()
            finish()
        } else {
            if(accountInput == "aa" && passwordInput == "123") {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show()
                intent.putExtra("EXTRA_PAGE1", 1)
                intent.putExtra("EXTRA_UID", accountInput)
                intent.putExtra("EXTRA_PASS", passwordInput)
                getSharedPreferences("login", Context.MODE_PRIVATE)
                    .edit()
                    .putString("ACCOUNT",accountInput)
                    .putString("PASSWORD",passwordInput)
                    .apply()
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else {
                counterForClick += 1
            }
        }
    }
    fun exit(v: View){
        finish()
    }
}

