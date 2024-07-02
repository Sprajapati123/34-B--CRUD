package com.example.crud_34b.repository

import com.google.firebase.auth.FirebaseAuth

class AuthRepoImpl(var auth: FirebaseAuth) : AuthRepo{
//    var auth: FirebaseAuth = FirebaseAuth.getInstance()
    override fun login(username: String, password: String, callback: (Boolean, String) -> Unit) {
        auth.signInWithEmailAndPassword(username, password).addOnCompleteListener {
            if (it.isSuccessful) {
                callback(true, "Login success")
            } else {
                callback(false, "Unable to success",)

            }
        }
    }

    override fun register(
        username: String,
        password: String,
        callback: (Boolean, String) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(username, password).addOnCompleteListener {
            if (it.isSuccessful) {
                callback(true, "User registration success")
            } else {
                callback(false, "Unable to register",)

            }
        }

    }
    }

