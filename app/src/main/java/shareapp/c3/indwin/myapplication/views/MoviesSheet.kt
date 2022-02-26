package shareapp.c3.indwin.myapplication.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import shareapp.c3.indwin.myapplication.PlayLists
import shareapp.c3.indwin.myapplication.R
import shareapp.c3.indwin.myapplication.adapters.PlaylistAdapter

class MoviesSheet : BottomSheetDialogFragment() {
    private lateinit var playlistsRv: RecyclerView
    private lateinit var addNewPlayLists: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context).inflate(R.layout.movies_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        playlistsRv = view.findViewById(R.id.playLists)
        addNewPlayLists = view.findViewById(R.id.createNewTv)

        playlistsRv.adapter = PlaylistAdapter(PlayLists.getPlayLists())
        playlistsRv.layoutManager = LinearLayoutManager(context)

        playlistsRv.adapter?.notifyDataSetChanged()

        addNewPlayLists.setOnClickListener {

        }
    }
}