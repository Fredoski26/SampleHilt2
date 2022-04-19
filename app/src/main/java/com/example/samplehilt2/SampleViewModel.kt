package com.example.samplehilt2

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.samplehilt2.model.SampleUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class SampleViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {


    fun insertRecords(firstName: String, lastName: String, email: String) = liveData {
        try {
            repository.insertRecords(
                SampleUser(
                    0,
                    first_name = firstName,
                    last_name = lastName,
                    email = email
                )
            )
            emit(true)
        } catch (e: Exception) {
            emit(false)
        }

    }


    fun getAllData() = liveData {
        emit(repository.getRecords())
    }

    fun updateDatas(id: Int, first_name: String, last_name: String, email: String) = liveData {
        try {
            val res = repository.updateDatas(SampleUser(id, first_name, last_name, email))
            emit(res > 0)

        } catch (e: Exception) {
            emit(false)
            e.printStackTrace()
        }

    }

    /*fun updateData(id: Int, first_name: String, last_name: String, email: String): MutableLiveData<Boolean> {
        val data = MutableLiveData<Boolean>()
        viewModelScope.launch(Dispatchers.IO) {
            val res = repository.updateDatas(SampleUser(id, first_name, last_name, email))
           // Log.d("TAG", "updateData: $res")
            data.postValue(res > 0)
        }
        return data
    }*/


}