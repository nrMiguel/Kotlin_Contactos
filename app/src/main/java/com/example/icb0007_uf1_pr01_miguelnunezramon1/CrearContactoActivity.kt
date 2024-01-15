package com.example.icb0007_uf1_pr01_miguelnunezramon1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.icb0007_uf1_pr01_miguelnunezramon1.databinding.ActivityCrearContactoBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CrearContactoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCrearContactoBinding
    lateinit var db: AppDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearContactoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        crearContacto()
    }

    private fun crearContacto(){
        db = AppDataBase.getInstance(this)!!

        val buttonCreateContact = binding.btnCreateContact
        buttonCreateContact.setOnClickListener{
            GlobalScope.launch {
                db.ContactDAO().insert(ContactEntity(binding.etNewContactEmail.text.toString(), binding.etNewContactName.text.toString(), binding.etNewContactPhone.text.toString(), binding.etNewContactWebsite.text.toString(), Address(binding.etNewContactStreet.text.toString(), binding.etNewContactCity.text.toString(), binding.etNewContactZipcode.text.toString())))
            }

            val intent = Intent(this, ContactActivity::class.java)
            startActivity(intent)
        }
    }
}