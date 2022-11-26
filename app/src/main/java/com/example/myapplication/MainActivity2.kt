package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val text1=findViewById<TextView>(R.id.textView3)
        val catid=intent.getStringExtra("nombreX")
        text1.setText(catid)
    }
    fun PasarMain(view:View){
        val intentM= Intent(this,MainActivity::class.java);
        startActivity(intentM)
    }
}