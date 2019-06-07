package com.example.randomnamegenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    companion object {
        val all_names = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        showRandName()
    }

    fun showRandName(){

        val randName = intent.getStringExtra( all_names )

        findViewById<TextView>(R.id.random_name_text).text = randName
    }
}
