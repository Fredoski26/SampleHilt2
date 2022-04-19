package com.example.samplehilt2.di

import com.example.samplehilt2.Repository
import com.example.samplehilt2.RepositoryImpl
import com.example.samplehilt2.data.SampleDAo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object WordsModel {

    @Provides
    fun provideRepository(sampleDAo: SampleDAo): Repository {
        return RepositoryImpl(sampleDAo)
    }
}