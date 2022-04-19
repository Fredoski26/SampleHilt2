package com.example.samplehilt2.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.samplehilt2.model.SampleUser

@Database(entities = [SampleUser::class], version = 1, exportSchema = false)
abstract class SampleDataBase : RoomDatabase() {

    abstract fun sampleDao(): SampleDAo
}