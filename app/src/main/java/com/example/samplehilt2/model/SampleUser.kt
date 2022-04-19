package com.example.samplehilt2.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
data class SampleUser(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val first_name: String,
    val last_name: String,
    val email: String
)
