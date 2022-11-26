package com.example.myapplication

class User {
    var id:Int=0
    var login:String=""
    var constraseña:String=""

    constructor(login:String,contraseña:String){
        this.login=login
        this.constraseña=contraseña
    }
    constructor(){

    }
}