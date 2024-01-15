package com.example.icb0007_uf1_pr01_miguelnunezramon1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.example.icb0007_uf1_pr01_miguelnunezramon1.databinding.ActivityContactDetailBinding

class ContactDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_contact_detail)

        val contacts: Contactos = intent.getSerializableExtra("CONTACTO") as Contactos

        binding.tvContactName.text = contacts.name
        binding.tvContactEmail.text = contacts.email
        binding.tvContactPhone.text = contacts.phone.toString()
        binding.tvContactWebsite.text = contacts.website
        binding.tvContactStreet.text = contacts.address.street
        binding.tvContactCity.text = contacts.address.city
        binding.tvContactZipcode.text = contacts.address.zipcode.toString()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.contact_detail_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.crearContacto -> {
                // Toad TEST
                //Toast.makeText(this, "Crear Contacto clickado", Toast.LENGTH_LONG).show()
                val intent = Intent(this, CrearContactoActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.cerrarSesion -> {
                // Toast TEST
                //Toast.makeText(this, "Cerrar Sesión clickado", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}