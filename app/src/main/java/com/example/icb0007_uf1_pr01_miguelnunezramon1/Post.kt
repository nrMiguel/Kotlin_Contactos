package com.example.icb0007_uf1_pr01_miguelnunezramon1

import com.google.gson.annotations.SerializedName

data class Post (
    @SerializedName("name") var name: String,
    @SerializedName("email") var email: String,
    @SerializedName("phone") var phone: String,
    @SerializedName("website") var web: String,
    @SerializedName("address") var address: AddressAPI
)

data class AddressAPI ( // TODO: Debería llamarse Address pero colisiona con la clase Address del fichero Contactos.kt, solucionar
    @SerializedName("street") var street: String,
    @SerializedName("suite") var suite: String,
    @SerializedName("city") var city: String,
    @SerializedName("zipcode") var zipcode: String,
    @SerializedName("geo") var geo: Geo
)

data class Geo (
    @SerializedName("lat") var lat: String,
    @SerializedName("lng") var lng: String
)