package com.example.icb0007_uf1_pr01_miguelnunezramon1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.icb0007_uf1_pr01_miguelnunezramon1.databinding.ItemContactBinding

class ContactAdapter (val contacts: ArrayList<Contactos>, val context: Context, private val onClickListener:(Contactos) -> Unit): RecyclerView.Adapter<ContactAdapter.ViewHolder>(){
    //val binding: ItemContactBinding.bind

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       //binding = ItemContactBinding.inflate(layout)
        val view = LayoutInflater
            .from(context)
            .inflate(R.layout.item_contact, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = Contactos(contacts[position].name.toString(), contacts[position].email, contacts[position].phone, contacts[position].website.toString(), Contactos.Address(contacts[position].address!!.street.toString(), contacts[position].address!!.city.toString(), contacts[position].address.zipcode))

        holder.render(contact, onClickListener)
    }

    override fun getItemCount(): Int = contacts.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemContactBinding.bind(view)

        fun render(contacto: Contactos, onClickListener: (Contactos) -> Unit) {
            binding.tvItemContactName.text = contacto.name

            binding.tvItemContactName.setOnClickListener { onClickListener(contacto) }
                // TODO: Borrar en caso de conseguir que funcione desde la Activity ContactActivity
                // Esto es test
                //Toast.makeText(binding.tvItemContactName.context, contacto.email, Toast.LENGTH_SHORT).show()
                /*
                val intent = Intent(binding.tvItemContactName.context, ContactDetailActivity::class.java).apply {
                    putExtra("PARAM_1", contacto)
                }
                //startActivity(intent)

                val intentTest = Intent(binding.tvItemContactName.context, ContactDetailActivity::class.java)
                //startActivity(intentTest)

            }
            */
        }
    }
}