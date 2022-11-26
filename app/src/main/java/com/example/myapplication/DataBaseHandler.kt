package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast


val DATABASE_NAME="MyDB"
val TABLE_NAME="Users"
val COL_LOGIN= "login"
val COL_CONTRA="contraseña"
val COL_ID="id"

class DataBaseHandler (var context: Context):SQLiteOpenHelper(context, DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable= "CREATE TABLE $TABLE_NAME($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,$COL_LOGIN VARCHAR(256),$COL_CONTRA VARCHAR(256))";
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(user:User){
        val db= this.writableDatabase
        var cv=ContentValues()
        cv.put(COL_LOGIN,user.login)
        cv.put(COL_CONTRA,user.constraseña)
        var result=db.insert(TABLE_NAME,null,cv)
        if (result==-1.toLong())
            Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Registro Exitoso", Toast.LENGTH_SHORT).show()
    }
}
