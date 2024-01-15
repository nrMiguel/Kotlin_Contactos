package com.example.icb0007_uf1_pr01_miguelnunezramon1

import androidx.annotation.WorkerThread
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDAO {

    @Insert(onConflict = REPLACE)
    fun insert(contactEntity: ContactEntity)

    @Update
    fun update(contactEntity: ContactEntity)

    // TODO: Como usar esto?
    @Delete()
    fun delete(contactEntity: ContactEntity)

    @Query("Select * From contactos")
    fun loadAllContacts(): Array<ContactEntity>

    // TODO: Las dos siguientes son realmente necesarias?
    @Query("Delete From contactos")
    fun deleteAllContacts()

}