package shareapp.c3.indwin.myapplication.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import shareapp.c3.indwin.myapplication.models.MovieData
import shareapp.c3.indwin.myapplication.respositaries.ApiClient
import shareapp.c3.indwin.myapplication.respositaries.ApiInterface

class MovieVM : ViewModel() {

    val movieLiveData = MutableLiveData<MovieData>()
    var apiClient: ApiInterface = ApiClient.getClient()

    fun fetchMovies() {
        apiClient.getMovies().enqueue(object : Callback<MovieData> {
            override fun onResponse(call: Call<MovieData>, response: Response<MovieData>) {
                movieLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<MovieData>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }
}