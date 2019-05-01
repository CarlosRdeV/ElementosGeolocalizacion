package com.example.elementosgeolocalizacion

import android.content.Context
import android.os.AsyncTask
import android.widget.Toast
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestTemplate
import java.util.ArrayList

class TareaMostrarCliente(private var ctx: Context?,
                          private var activity: MainActivity?)
    : AsyncTask<Void, Void, Void>() {

    var estatus=Estatus()
    var clientes= ArrayList<Cliente>()

    override fun onPostExecute(result: Void?) {

        Toast.makeText(ctx,estatus.mensaje,Toast.LENGTH_LONG).show()
    }

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg p0: Void?): Void? {
        try {
            var url ="https://carlosrdev1902.herokuapp.com/cliente/mostrar"

            val restTemplate = RestTemplate()

            restTemplate.messageConverters.add(MappingJackson2HttpMessageConverter())

            val maper = ObjectMapper()

            val respuesta = restTemplate.getForObject(url, String::class.java)
            clientes = maper.readValue(respuesta, object : TypeReference<ArrayList<Cliente>>(){})

            estatus.mensaje=clientes.toString()

        } catch (t: Throwable) {

        }
        return null
    }

}


