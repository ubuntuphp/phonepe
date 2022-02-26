package shareapp.c3.indwin.myapplication.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import shareapp.c3.indwin.myapplication.R
import shareapp.c3.indwin.myapplication.adapters.MoviesAdapter
import shareapp.c3.indwin.myapplication.adapters.MoviesStarListener
import shareapp.c3.indwin.myapplication.models.MovieData
import shareapp.c3.indwin.myapplication.models.MovieResult
import shareapp.c3.indwin.myapplication.viewmodels.MovieVM


class MoviesFragment : Fragment() {

    val movieVM: MovieVM by viewModels<MovieVM>()
    private lateinit var moviesRv: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieVM.fetchMovies()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviesRv = view.findViewById(R.id.holdingsRv)
        movieVM.movieLiveData.observe(viewLifecycleOwner, Observer {
            setData(it)
        })
    }

    private fun showBottomSheet(movieData: MovieResult) {
        val holdingsBottomSheetDialogFragment = MoviesSheet()
        holdingsBottomSheetDialogFragment.show(parentFragmentManager, "movies_sheet")

    }

    private fun setData(data: MovieData) {
        val holdingsAdapter = MoviesAdapter(data, object : MoviesStarListener {
            override fun onClick(data: MovieResult) {
                showBottomSheet(data)
            }
        })
        moviesRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        moviesRv.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        moviesRv.adapter = holdingsAdapter
    }
}