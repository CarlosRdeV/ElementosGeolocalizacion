package com.example.elementosgeolocalizacion


import android.content.Context
import android.os.AsyncTask
import android.widget.TextView
import android.widget.Toast
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestTemplate

class TareaLocalizacion(private var ctx: Context?, private var usuario: Usuario?,
                          private var activity: MainActivity?)
    : AsyncTask<Void,Void,Void>() {

    override fun onPostExecute(result: Void?) {

        //Invocamos nuestra vistaa del MainActivity
      //  activity?.findViewById<TextView>(R.id.txtActual)?.text=estacion?.temp_c




    }

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg p0: Void?): Void? {
        try {
            var url ="https://carlosrdev1902.herokuapp.com/api/usuario";


            val restTemplate = RestTemplate()
            restTemplate.messageConverters.add(MappingJackson2HttpMessageConverter())


            val maper = ObjectMapper()
            //  usuarios = maper.readValue(estring, object : TypeReference<ArrayList<Usuario>>() {})

            var usuario=Usuario()
            val respuesta = restTemplate.postForObject(url, usuario , String::class.java)

            var estacion = maper.readValue(respuesta, Estacion::class.java)


            println("DESPUES DE REST");
        } catch (t: Throwable) {

        }
        return null

    }


}