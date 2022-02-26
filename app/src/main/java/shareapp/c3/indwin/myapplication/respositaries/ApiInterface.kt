package shareapp.c3.indwin.myapplication.respositaries

import retrofit2.http.GET
import shareapp.c3.indwin.myapplication.models.MovieData

interface ApiInterface {
    @GET("movie/now_playing?api_key=38a73d59546aa378980a88b645f487fc&language=en-US&page=1")
    fun getMovies(): retrofit2.Call<MovieData>
}
