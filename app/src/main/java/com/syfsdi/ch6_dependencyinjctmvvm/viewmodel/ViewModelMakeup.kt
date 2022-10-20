package com.syfsdi.ch6_dependencyinjctmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.syfsdi.ch6_dependencyinjctmvvm.model.ResponseDataMakeupItem
import com.syfsdi.ch6_dependencyinjctmvvm.network.RestfulAPI
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ViewModelMakeup
@Inject constructor(var api: RestfulAPI) : ViewModel(){
    var liveDataMakeup: MutableLiveData<List<ResponseDataMakeupItem>>

    init {
        liveDataMakeup = MutableLiveData()
    }

    fun getliveDataMakeup() : MutableLiveData<List<ResponseDataMakeupItem>> {
        return  liveDataMakeup
    }

    fun callApi(){
        api.getAllMakeup().enqueue(object : Callback<List<ResponseDataMakeupItem>> {
            override fun onResponse(
                call: Call<List<ResponseDataMakeupItem>>,
                response: Response<List<ResponseDataMakeupItem>>
            ) {
                if (response.isSuccessful){
                    liveDataMakeup.postValue(response.body())
                }else{
                    liveDataMakeup.postValue(null)
                }
            }

            override fun onFailure(call: Call<List<ResponseDataMakeupItem>>, t: Throwable) {
                liveDataMakeup.postValue(null)
            }
        })
    }
}