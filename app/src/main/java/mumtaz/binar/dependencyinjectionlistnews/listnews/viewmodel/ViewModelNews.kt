package mumtaz.binar.dependencyinjectionlistnews.listnews.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mumtaz.binar.dependencyinjectionlistnews.listnews.model.GetAllNewsResponseItem
import mumtaz.binar.dependencyinjectionlistnews.listnews.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ViewModelNews @Inject constructor(api : ApiService): ViewModel(){

    private var liveDataNews = MutableLiveData<List<GetAllNewsResponseItem>>()

    val news : LiveData<List<GetAllNewsResponseItem>> = liveDataNews

    init {
         viewModelScope.launch {
             val datanews = api.getAllNews()
             delay(2000)
             liveDataNews.value = datanews
         }
    }




}