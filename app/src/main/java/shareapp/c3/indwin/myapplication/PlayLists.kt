package shareapp.c3.indwin.myapplication

object PlayLists {
    val movies = HashMap<Int, String>()
    val playLists = ArrayList<String>()
    fun addMovieToPlayList(id: Int, playList: String) {
        movies[id] = playList
    }

    fun getPlayLists(): Array<String> {
        return playLists.toArray() as Array<String>
    }

    fun getPlaylistForMove(id: Int) = movies[id]

    fun createNewPlayList(playList: String) {
        if (!playLists.contains(playList)) {
            playLists.add(playList)
        }
    }
}