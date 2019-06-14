package com.example.immoblier

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.*
import java.util.*
import java.util.concurrent.TimeUnit

class newAnnounce : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.newannounce)


        val submit = findViewById<Button>(R.id.submit)
        submit.setOnClickListener {

            val wilaya = findViewById<EditText>(R.id.wilaya).text.toString()
            val name = findViewById<EditText>(R.id.name).text.toString()
            val email = findViewById<EditText>(R.id.email).text.toString()
            val phone = findViewById<EditText>(R.id.phone).text.toString()
            val adrs = findViewById<EditText>(R.id.adresse).text.toString()
            val desc = findViewById<EditText>(R.id.description).text.toString()
            val nbBedRooms = findViewById<EditText>(R.id.nbBedRooms).text.toString()
            val area = findViewById<EditText>(R.id.area).text.toString()
            val price = findViewById<EditText>(R.id.price).text.toString()
            val type = findViewById<RadioButton>(findViewById<RadioGroup>(R.id.type).checkedRadioButtonId).text.toString()

            val thirdHomePictures = ArrayList<Int>()
            thirdHomePictures.add(R.drawable.picture2)

             if (!TextUtils.isEmpty(wilaya)
                 &&  !TextUtils.isEmpty(adrs)
                 &&  !TextUtils.isEmpty(desc)
                 &&  !TextUtils.isEmpty(nbBedRooms)
                 &&  !TextUtils.isEmpty(area)
                 &&  !TextUtils.isEmpty(name)
                 &&  !TextUtils.isEmpty(phone)
                 &&  !TextUtils.isEmpty(email)  ) {

                 announcements.add(
                     Announcement(
                         wilaya,
                         adrs,
                         desc,
                         type,
                         nbBedRooms.toInt(),
                         3,
                         1,
                         1,
                         0,
                         1,
                         area.toFloat(),
                         thirdHomePictures,
                         Agent(name, email, phone.toInt()),
                         price.toFloat(),
                         Date()
                     )
                 )

                 Toast.makeText(this, "Announce ajouter !", Toast.LENGTH_SHORT).show()
                 TimeUnit.SECONDS.sleep(1L)
                 val intent = Intent(this, MainActivity::class.java)
                 startActivity(intent)

            }



        }
    }
}