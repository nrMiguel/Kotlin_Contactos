package com.example.icb0007_uf1_pr01_miguelnunezramon1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var db: AppDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Se supone que esto es para hacer el SlashScreen, no funciona, podríamos probar a hacer aquí directamente a poner el splashscreen y el sleep.
        val intent = Intent(this, SplashScreen::class.java)
        startActivity(intent)
        */

        logIn()
    }

    private fun logIn(){
        val buttonLog = findViewById<Button>(R.id.btn_login)
        buttonLog.setOnClickListener{
            val user = findViewById<EditText>(R.id.et_username).text.toString()
            val pass = findViewById<EditText>(R.id.et_password).text.toString()

            if (user.equals("admin") && pass.equals("admin")){
                //Toast.makeText(applicationContext, "Log Correct, quitar este toast y seguir practica según indicaciones?", Toast.LENGTH_SHORT).show()

                //Creamos la BD.
                db = AppDataBase.getInstance(this)!!

                GlobalScope.launch {
                    // Test condicional de si isEmpty la tabla contactos:
                    //db.ContactDAO().deleteAllContacts()

                    if (db.ContactDAO().loadAllContacts().isEmpty()) {
                        Log.i("----->", "La BD está vacía, se procederá a descargar la API y posteriormente insertar los datos en la BD...")
                        val call = getRetrofit().create(PostAPIService::class.java).getAllPosts().execute()
                        val posts = call.body() as List<Post>

                        posts.forEach {
                            Log.i("---->", it.toString())
                            db.ContactDAO().insert(ContactEntity(it.email, it.name, it.phone, it.web, Address(it.address.street, it.address.city, it.address.zipcode)))
                        }
                    }

                    val contactsDb = db.ContactDAO().loadAllContacts()

                    contactsDb.forEach { Log.i("-->", it.toString()) }
                }

                //Comprobación BD
                val intent = Intent(this, ContactActivity::class.java)//.apply { putExtra("DB", db) }
                startActivity(intent)
            } else {
                //Toast.makeText(applicationContext, "Log incorrecto!" + user + pass, Toast.LENGTH_LONG).show() Sirve para hacer comprobaciones
                Toast.makeText(applicationContext, "Log incorrecto!", Toast.LENGTH_LONG).show()
            }

        }
    }

    // Obtiene retrofit del API
    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}