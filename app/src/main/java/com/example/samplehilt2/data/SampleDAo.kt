package com.example.samplehilt2.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.samplehilt2.model.SampleUser

@Dao
interface SampleDAo {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecord(sampleUser: SampleUser)

    @Query("SELECT *FROM user_table ORDER BY id DESC")
    suspend fun getAllRecord(): List<SampleUser>

    @Query("UPDATE user_table SET first_name = :firstname, last_name = :last, email = :email WHERE id = :id")
    suspend fun updateData(firstname: String, last: String, email: String, id: Int): Int
}