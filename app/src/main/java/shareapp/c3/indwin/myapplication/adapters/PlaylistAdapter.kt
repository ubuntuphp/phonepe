package shareapp.c3.indwin.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import shareapp.c3.indwin.myapplication.R

class PlaylistAdapter(private val playlists: Array<String>) : RecyclerView.Adapter<PlaylistVH>() {
    override fun getItemCount(): Int {
        return playlists.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistVH {
        return PlaylistVH(LayoutInflater.from(parent.context).inflate(R.layout.plalist_vh, parent))
    }

    override fun onBindViewHolder(holder: PlaylistVH, position: Int) {
        holder.setData(playlists[position])
    }
}

class PlaylistVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private lateinit var playlistName: TextView
    fun setData(name: String) {
        playlistName.text = name
    }

    init {
        playlistName = itemView.findViewById(R.id.playlistName)

    }
}
