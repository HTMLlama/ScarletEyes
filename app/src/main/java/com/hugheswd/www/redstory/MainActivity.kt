package com.hugheswd.www.redstory

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        leentrance.setOnClickListener {
            val intent = Intent(context, StoryActivity::class.java)
            var nobody = lename.text.toString()

            if (nobody.equals("")){
                nobody = "Riley"
            }


            intent.putExtra("nobodyExtra", nobody)
            startActivity(intent)
        }

    }
}


