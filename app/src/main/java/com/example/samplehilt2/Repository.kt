package com.example.samplehilt2

import com.example.samplehilt2.model.SampleUser

interface Repository {


    suspend fun insertRecords(sampleUser: SampleUser)

    suspend fun getRecords(): List<SampleUser>

    suspend fun updateDatas(sampleUser: SampleUser): Int
    //suspend fun updateData(): List<SampleUser>

}