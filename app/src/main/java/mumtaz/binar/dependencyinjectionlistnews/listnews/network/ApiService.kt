package mumtaz.binar.dependencyinjectionlistnews.listnews.network

import mumtaz.binar.dependencyinjectionlistnews.listnews.model.GetAllNewsResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("news")
    fun getAllNews() : Call<List<GetAllNewsResponseItem>>
}