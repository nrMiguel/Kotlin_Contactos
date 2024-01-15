package com.example.icb0007_uf1_pr01_miguelnunezramon1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.icb0007_uf1_pr01_miguelnunezramon1.databinding.ActivityContactBinding
import com.example.icb0007_uf1_pr01_miguelnunezramon1.databinding.ItemContactBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ContactActivity : AppCompatActivity() {
    private var contacts: ArrayList<Contactos> = ArrayList()
    lateinit var db: AppDataBase

    private lateinit var binding: ActivityContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_contact)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Creamos la BD.
        db = AppDataBase.getInstance(this)!!

        addContacts()
        viewConfig()
    }

    private fun addContacts(){
        // Testing
        // Cargamos los contactos que haya en la BD.
        GlobalScope.launch {
            val contactsDb = db.ContactDAO().loadAllContacts()
            contactsDb.forEach { Log.i("-->", it.toString()) }

            contactsDb.forEach {
                contacts.add(Contactos(it.name.toString(), it.email, it.phone!!, it.website.toString(), Contactos.Address(it.address!!.street.toString(), it.address!!.city.toString(), it.address.zipcode!!)))
            }
        }
    }

    private fun viewConfig() {
        binding.rvListContacts

        binding.rvListContacts.adapter = ContactAdapter(contacts, this) { contacto ->
            onItemSelected(
                contacto
            )
        }
        binding.rvListContacts.layoutManager = LinearLayoutManager(this)
    }

    fun onItemSelected(contacto: Contactos) {
        // Esto es Test
        // Toast.makeText(this, contacto.email, Toast.LENGTH_SHORT).show()

        val intent = Intent(this, ContactDetailActivity::class.java).apply { putExtra("CONTACTO", contacto) }
        startActivity(intent)
    }
}

