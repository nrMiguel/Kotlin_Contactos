package com.example.icb0007_uf1_pr01_miguelnunezramon1

import androidx.room.*

@Entity(tableName = "contactos")
data class ContactEntity (
    @PrimaryKey val email: String,
    val name: String?,
    val phone: String?,
    val website: String?,
    @Embedded val address: Address?
)

data class Address(
    val street: String?,
    val city: String?,
    val zipcode: String?
)

