package com.example.mynewsapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mynewsapp.Adapter.InterAdapter
import com.example.mynewsapp.model.News


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerInter : RecyclerView
    lateinit var layoutManager : RecyclerView.LayoutManager
    lateinit var recyclerAdapter : InterAdapter

    var newsInfoList = arrayListOf<News>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerInter = findViewById(R.id.recyclerView)
        layoutManager = LinearLayoutManager(this)

        newsInfoList.add(News("Reduer","SpaceX CEO Elon Musk Says Starship Orbital Stack to Be Ready for Flight in Few Weeks","SpaceX founder Elon Musk said the first orbital stack of the Starship rocket should be ready for flight in the coming weeks, taking the unorthodox billionaire a step closer to his dream of orbital and then interplanetary travel.","2021 20 43",""))
        newsInfoList.add(News("Reduer","SpaceX CEO Elon Musk Says Starship Orbital Stack to Be Ready for Flight in Few Weeks","SpaceX founder Elon Musk said the first orbital stack of the Starship rocket should be ready for flight in the coming weeks, taking the unorthodox billionaire a step closer to his dream of orbital and then interplanetary travel.","2021 20 43",""))
        newsInfoList.add(News("Reduer","SpaceX CEO Elon Musk Says Starship Orbital Stack to Be Ready for Flight in Few Weeks","SpaceX founder Elon Musk said the first orbital stack of the Starship rocket should be ready for flight in the coming weeks, taking the unorthodox billionaire a step closer to his dream of orbital and then interplanetary travel.","2021 20 43",""))
        newsInfoList.add(News("Reduer","SpaceX CEO Elon Musk Says Starship Orbital Stack to Be Ready for Flight in Few Weeks","SpaceX founder Elon Musk said the first orbital stack of the Starship rocket should be ready for flight in the coming weeks, taking the unorthodox billionaire a step closer to his dream of orbital and then interplanetary travel.","2021 20 43",""))
        newsInfoList.add(News("Reduer","SpaceX CEO Elon Musk Says Starship Orbital Stack to Be Ready for Flight in Few Weeks","SpaceX founder Elon Musk said the first orbital stack of the Starship rocket should be ready for flight in the coming weeks, taking the unorthodox billionaire a step closer to his dream of orbital and then interplanetary travel.","2021 20 43",""))
        newsInfoList.add(News("Reduer","SpaceX CEO Elon Musk Says Starship Orbital Stack to Be Ready for Flight in Few Weeks","SpaceX founder Elon Musk said the first orbital stack of the Starship rocket should be ready for flight in the coming weeks, taking the unorthodox billionaire a step closer to his dream of orbital and then interplanetary travel.","2021 20 43",""))
        newsInfoList.add(News("Reduer","SpaceX CEO Elon Musk Says Starship Orbital Stack to Be Ready for Flight in Few Weeks","SpaceX founder Elon Musk said the first orbital stack of the Starship rocket should be ready for flight in the coming weeks, taking the unorthodox billionaire a step closer to his dream of orbital and then interplanetary travel.","2021 20 43",""))
        newsInfoList.add(News("Reduer","SpaceX CEO Elon Musk Says Starship Orbital Stack to Be Ready for Flight in Few Weeks","SpaceX founder Elon Musk said the first orbital stack of the Starship rocket should be ready for flight in the coming weeks, taking the unorthodox billionaire a step closer to his dream of orbital and then interplanetary travel.","2021 20 43",""))
        newsInfoList.add(News("Reduer","SpaceX CEO Elon Musk Says Starship Orbital Stack to Be Ready for Flight in Few Weeks","SpaceX founder Elon Musk said the first orbital stack of the Starship rocket should be ready for flight in the coming weeks, taking the unorthodox billionaire a step closer to his dream of orbital and then interplanetary travel.","2021 20 43",""))
        newsInfoList.add(News("Reduer","SpaceX CEO Elon Musk Says Starship Orbital Stack to Be Ready for Flight in Few Weeks","SpaceX founder Elon Musk said the first orbital stack of the Starship rocket should be ready for flight in the coming weeks, taking the unorthodox billionaire a step closer to his dream of orbital and then interplanetary travel.","2021 20 43",""))
        recyclerAdapter =
            InterAdapter(this, newsInfoList)
        recyclerInter.adapter = recyclerAdapter
        recyclerInter.layoutManager = layoutManager
    }
}