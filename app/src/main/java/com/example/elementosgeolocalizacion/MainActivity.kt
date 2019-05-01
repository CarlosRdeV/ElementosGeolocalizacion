package com.example.elementosgeolocalizacion

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_localizar.setOnClickListener{

            var empleado=Empleado()

            empleado.id=txtInputID.text.toString().toInt()
            empleado.nombre=txtInputNombre.text.toString()
            empleado.puesto=txtInputPuesto.text.toString()


            TareaGuardar(applicationContext,empleado,this).execute(null,null,null)

        }
    }
}
