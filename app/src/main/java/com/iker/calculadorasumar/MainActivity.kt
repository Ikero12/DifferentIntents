package com.iker.calculadorasumar

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var btn1:Button
    lateinit var btncamara:Button
    val RESULTADO_UNO = 1
    val RESULTADO_DOS = 2
    val RESULTADO_TRES = 3
    var clicked =0
    lateinit var resultado1:TextView
    lateinit var resultado2:TextView
    lateinit var resultado3:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.button)
        btncamara = findViewById(R.id.button2)
        val intent = Intent(this,Activity2::class.java)

        resultado1 = findViewById(R.id.resultado1)
        resultado2 = findViewById(R.id.resultado2)
        resultado3 = findViewById(R.id.resultado3)

        btn1.setOnClickListener{
            clicked++
            when(clicked){
                1->{
                    intent.putExtra("n1",1)
                    intent.putExtra("n2",2)
                    startActivityForResult(intent,RESULTADO_UNO)
                }
                2->{
                    intent.putExtra("n1",5)
                    intent.putExtra("n2",5)
                    startActivityForResult(intent,RESULTADO_DOS)
                }
                3->{
                    intent.putExtra("n1",3)
                    intent.putExtra("n2",4)
                    startActivityForResult(intent,RESULTADO_TRES)

                }
            }
            if(clicked==4){
                val navegador = Intent(Intent.ACTION_VIEW)
                val url = "http://www.trollface.dk"
                navegador.data = Uri.parse(url)
                startActivity(navegador)


                clicked=0
                resultado1.text = "Resultado 1"
                resultado2.text = "Resultado 2"
                resultado3.text = "Resultado 3"
            }

        }
        val intent2 = Intent(this,CamaraActivity::class.java)
        intent2.putExtra("camara","hola")
        btncamara.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                startActivity(intent2)
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode != Activity.RESULT_OK) return
        when(requestCode) {
            RESULTADO_UNO -> {
                if (data != null) {
                    resultado1.text = data.getIntExtra("suma",0).toString()
                }; }
            RESULTADO_DOS ->{
                if (data != null) {
                    resultado2.text = data.getIntExtra("suma",0).toString()
                };

            }
            RESULTADO_TRES -> {
                if (data != null) {
                    resultado3.text = data.getIntExtra("suma",0).toString()
                };
            }
            // Other result codes
            else -> {
            }
        }
    }
}