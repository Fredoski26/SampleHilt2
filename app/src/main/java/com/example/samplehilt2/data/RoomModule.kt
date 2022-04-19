package com.example.samplehilt2.data

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object RoomModule {


    @Provides
    fun getAppDataBase(@ApplicationContext context: Context): SampleDataBase {
        return Room.databaseBuilder(context, SampleDataBase::class.java, "EniolaDB").build()
    }

    @Provides
    fun getDao(sampleDataBase: SampleDataBase): SampleDAo {
        return sampleDataBase.sampleDao()
    }
}