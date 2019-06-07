package com.example.randomnamegenerator

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var names = mutableListOf( "default")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

/*
        val getEnteredText = findViewById<TextInputEditText>(R.id.name_input_field)
        val submit = findViewById<Button>(R.id.submit_button)
        if (submit != null && getEnteredText != null ){
            submit.setOnClickListener{
                val name = getEnteredText.text.toString()
                Toast.makeText( this, "Name: $name", Toast.LENGTH_SHORT).show()
            }
        }
        */


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    fun submitMe( view: View ){
        val getEnteredText = findViewById<TextInputEditText>(R.id.text_input_field)
        val enteredString = getEnteredText.text.toString()

        val getHelloString = findViewById<TextView>(R.id.hello_world_text)
        getHelloString.text = enteredString

        names.add( enteredString )  //add it to list of names

    }

    fun generateRand( view:View ){
        // Create an Intent to start the second activity
        val randomIntent = Intent( this, SecondActivity::class.java)

        val random = java.util.Random()
        var randomInt = 0 //default value

        //get a random number less than count+1 (the upper bound)
        if (names.size > 0 ){
            randomInt = random.nextInt( names.size - 1 ) //add one because the bound is exclusive
        }

        val randomName = names[randomInt]

        //push the string
        randomIntent.putExtra( SecondActivity.all_names, randomName)

        startActivity( randomIntent )
    }
}
