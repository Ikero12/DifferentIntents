package com.iker.calculadorasumar

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val intent = getIntent()

        val valor1 = intent.getIntExtra("n1",0)
        val valor2 = intent.getIntExtra("n2",0)

        val suma = valor1 + valor2

        intent.putExtra("suma",suma)
        Log.d("SUMA:", suma.toString())
        setResult(Activity.RESULT_OK,intent)
        finish()
    }
}