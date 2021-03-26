package com.example.tp1.présentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp1.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MangaListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = MangaAdapter(listOf<String>())
    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_manga_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.manga_recyclerview)

        recyclerView.apply {
            layoutManager = this@MangaListFragment.layoutManager
            adapter = this@MangaListFragment.adapter
        }

        /* ça c'est la manière classique sinon "apply" plus pratique
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter*/

        val mangaList = arrayListOf<Manga>().apply {
            add(Manga( "Naruto"))
            add(Manga( "One piece"))
            add(Manga( "Soul Eater"))
        }

        adapter.updateList(mangaList)

    }
}