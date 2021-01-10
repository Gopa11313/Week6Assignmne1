package com.example.week6assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private lateinit var unamme:EditText;
    private lateinit var paword:EditText;
    private lateinit var login:Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        unamme=findViewById(R.id.username)
        paword=findViewById(R.id.password)
        login=findViewById(R.id.login)
        login.setOnClickListener {
            valid(unamme.text.toString(),paword.text.toString())
        }

    }
    fun valid(username:String,password:String){

        if(username!==null&& password!==null){
            if (username=="softwarica" && password=="coventry"){
                startActivity(Intent(this,HomeActivity::class.java))
            }
            else{
                Toast.makeText(this,"Please enter valid credentials", Toast.LENGTH_SHORT).show()
            }

        }
        else{
            Toast.makeText(this, "Please enter your credentials before pressing login", Toast.LENGTH_SHORT).show()
        }
    }


}