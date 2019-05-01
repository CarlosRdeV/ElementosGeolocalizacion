package com.example.elementosgeolocalizacion

import android.content.Context
import android.os.AsyncTask
import android.widget.TextView
import android.widget.Toast
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestTemplate

class TareaGuardar(private var ctx: Context?, private var empleado: Empleado?,
                   private var activity: MainActivity?)
    : AsyncTask<Void,Void,Void>() {

    var estatus=Estatus()

    override fun onPostExecute(result: Void?) {

        Toast.makeText(ctx,estatus.mensaje,Toast.LENGTH_LONG).show()
    }

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg p0: Void?): Void? {
        try {
            var url ="https://carlosrdev1902.herokuapp.com/empleado/guardar"

            val restTemplate = RestTemplate()

            restTemplate.messageConverters.add(MappingJackson2HttpMessageConverter())

            val maper = ObjectMapper()

            val respuesta = restTemplate.postForObject(url, empleado , String::class.java)

            estatus = maper.readValue(respuesta, Estatus::class.java)


            println("DESPUES DE REST");



        } catch (t: Throwable) {

        }
        return null
    }

}