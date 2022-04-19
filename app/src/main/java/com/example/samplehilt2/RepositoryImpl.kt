package com.example.samplehilt2

import com.example.samplehilt2.data.SampleDAo
import com.example.samplehilt2.model.SampleUser
import javax.inject.Inject

class RepositoryImpl(private val sampleDAo: SampleDAo) : Repository {

    override suspend fun insertRecords(sampleUser: SampleUser) {
        sampleDAo.insertRecord(sampleUser)
    }

    override suspend fun getRecords(): List<SampleUser> {
        return sampleDAo.getAllRecord()
    }

    override suspend fun updateDatas(sampleUser: SampleUser): Int {
        return sampleDAo.updateData(
            sampleUser.first_name,
            sampleUser.last_name,
            sampleUser.email,
            sampleUser.id
        )
    }


}