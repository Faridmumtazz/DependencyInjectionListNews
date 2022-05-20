package mumtaz.binar.dependencyinjectionlistnews.listnews.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mumtaz.binar.dependencyinjectionlistnews.listnews.model.GetAllNewsResponseItem
import mumtaz.binar.dependencyinjectionlistnews.listnews.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelNews : ViewModel(){

    lateinit var liveDataNews : MutableLiveData<List<GetAllNewsResponseItem>>

    init {
        liveDataNews = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<GetAllNewsResponseItem>> {
        return liveDataNews
    }

    fun getApiNews(){
       ApiClient.instance.getAllNews()
            .enqueue(object : Callback<List<GetAllNewsResponseItem>> {
                override fun onResponse(
                    call: Call<List<GetAllNewsResponseItem>>,
                    response: Response<List<GetAllNewsResponseItem>>
                ) {
                    if (response.isSuccessful) {
                        liveDataNews.postValue(response.body())
                    }else{
                        liveDataNews.postValue(null)
                    }

                }

                override fun onFailure(call: Call<List<GetAllNewsResponseItem>>, t: Throwable) {
                    liveDataNews.postValue(null)
                }

            })
    }
}