package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ed_login=findViewById<EditText>(R.id.edName)
        val ed_pass=findViewById<EditText>(R.id.edPassword)
        val btn_iniciar=findViewById<Button>(R.id.btnIniciar)
        val btn_reg=findViewById<Button>(R.id.btnreg)
        val context=this
        var db=DataBaseHandler(context)
        btn_reg.setOnClickListener{
            if (ed_login.text.toString().length>0 &&
                    ed_pass.text.toString().length>0
            ){
                var user=User(ed_login.text.toString(),ed_pass.text.toString())
                var db=DataBaseHandler(context)
                db.insertData(user)
            }else{
                Toast.makeText(context,"Ingresa Datos",Toast.LENGTH_SHORT)
                    .show()
            }
        }
        btn_iniciar.setOnClickListener{
            val intentIS=Intent(this,MainActivity2::class.java);
            val nombre=ed_login.text.toString()
            val datoN=Bundle()
            datoN.putString("nombreX",nombre)
            intentIS.putExtras(datoN)
            startActivity(intentIS)
        }

    }
}