package shareapp.c3.indwin.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import shareapp.c3.indwin.myapplication.R
import shareapp.c3.indwin.myapplication.models.MovieData
import shareapp.c3.indwin.myapplication.models.MovieResult

class MoviesAdapter(private val data: MovieData, val clickListener: MoviesStarListener) :
    RecyclerView.Adapter<MoviesVh>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesVh {
        val holdingsView =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_vh, parent, false)
        return MoviesVh(holdingsView, clickListener)
    }

    override fun onBindViewHolder(holder: MoviesVh, position: Int) {
        holder.setData(data.results[position])
    }

    override fun getItemCount(): Int {
        return data.results.size
    }


}

class MoviesVh(itemView: View, val clickListener: MoviesStarListener) :
    RecyclerView.ViewHolder(itemView) {

    private lateinit var movieIcon: ImageView
    private lateinit var movieName: TextView
    private lateinit var movieRating: TextView
    private lateinit var moviePlaylists: TextView

    init {
        movieIcon = itemView.findViewById(R.id.movieIcon)
        movieName = itemView.findViewById(R.id.movieName)
        movieRating = itemView.findViewById(R.id.movieRating)
        moviePlaylists = itemView.findViewById(R.id.moviePlaylists)
    }

    fun setData(data: MovieResult) {
        movieName.text = data.title
        movieRating.text = """Ratings: ${data.voteAverage.toString()}"""


    }
}
