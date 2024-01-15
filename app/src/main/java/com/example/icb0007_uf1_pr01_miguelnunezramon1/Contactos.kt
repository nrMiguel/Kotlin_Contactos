package com.example.icb0007_uf1_pr01_miguelnunezramon1

class Contactos(val name: String, val email: String, val phone: String, val website: String /*website: Website TODO: Investigar tipo Website*/, val address: Address) : java.io.Serializable{

    class Address(val street: String, val city: String, val zipcode: String) : java.io.Serializable
}


