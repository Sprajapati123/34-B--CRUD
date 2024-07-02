package com.example.crud_34b.repository

interface AuthRepo {
    fun login(username: String,password:String,callback:(Boolean,String)->Unit)
    fun register(username: String,password:String,callback:(Boolean,String)->Unit)
}