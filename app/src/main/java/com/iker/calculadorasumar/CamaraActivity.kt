package com.iker.calculadorasumar

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView

class CamaraActivity : Activity() {


    val REQUEST_IMAGE_CAPTURE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camara)
        var camarabtn = findViewById<Button>(R.id.button3)
        var backbtn = findViewById<Button>(R.id.button4)

        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        camarabtn.setOnClickListener{
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
        }
        backbtn.setOnClickListener{
            val intenthome = Intent(this, MainActivity::class.java)
            startActivity(intenthome)
            finish()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val imageView = findViewById<ImageView>(R.id.imageView)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK && data != null) {
            val imageBitmap = data.extras!!.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)
        }
    }

}