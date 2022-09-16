package com.example.videoplayer.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.videoplayer.Adapter.ItemAdapter
import com.example.videoplayer.Adapter.ItemAdapter2
import com.example.videoplayer.Adapter.MovieData
import com.example.videoplayer.Adapter.MovieData2
import com.example.videoplayer.R
import com.example.videoplayer.WatchVideo
import com.example.videoplayer.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ItemAdapter
    lateinit var adapter2: ItemAdapter2
    lateinit var recyclerView2: RecyclerView
    var data = ArrayList<MovieData>()
    var data2 = ArrayList<MovieData2>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        val imageView : ImageView = binding.imageView
        //Recycler View Init
        recyclerView = binding.reyclerView
        recyclerView2 = binding.reyclerView2

        init()
        init2()

        //RecycleView Set Up
        recyclerView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        recyclerView2.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
        recyclerView2.adapter = adapter2
        recyclerView.adapter = adapter
        adapter.onItemClick = {
            val intent = Intent(activity,WatchVideo::class.java)
            intent.putExtra("MovieData",it)
            startActivity(intent)
        }
        adapter2.onItemClick= {
            val intent = Intent(activity,WatchVideo::class.java)
            intent.putExtra("MovieData2",it)
            startActivity(intent)
        }


        val v = binding.root
        return v
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun init2() {
        data2.add(MovieData2(R.drawable.freeguy,"FREE GUY","8/10",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin fermentum nisi at euismod imperdiet. Nullam molestie mi vel ante dictum sollicitudin. Quisque commodo arcu id diam interdum porta. Vivamus vel posuere nisi. Donec id lectus ac ipsum pharetra bibendum. Fusce viverra turpis et commodo dignissim. Maecenas consequat placerat luctus. Curabitur cursus turpis enim, in cursus odio lacinia vitae. ","https://cdn.videvo.net/videvo_files/video/free/video0467/large_watermarked/_import_61516586ee8571.11252072_preview.mp4"))
        data2.add(MovieData2(R.drawable.violet,"VIOLET EVERGARDEN","9/10",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin fermentum nisi at euismod imperdiet. Nullam molestie mi vel ante dictum sollicitudin. Quisque commodo arcu id diam interdum porta. Vivamus vel posuere nisi. Donec id lectus ac ipsum pharetra bibendum. Fusce viverra turpis et commodo dignissim. Maecenas consequat placerat luctus. Curabitur cursus turpis enim, in cursus odio lacinia vitae. ","https://cdn.videvo.net/videvo_files/video/premium/2021-04/large_watermarked/210329_09_Bali_4k_005_preview.mp4"))
        data2.add(MovieData2(R.drawable.wood,"WOOD","9/10","CCCCCCCCCCCCCCC","https://cdn.videvo.net/videvo_files/video/free/2021-04/large_watermarked/210329_06B_Bali_1080p_013_preview.mp4"))
        data2.add(MovieData2(R.drawable.fgo,"FATE GRAND ORDER","7/10",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin fermentum nisi at euismod imperdiet. Nullam molestie mi vel ante dictum sollicitudin. Quisque commodo arcu id diam interdum porta. Vivamus vel posuere nisi. Donec id lectus ac ipsum pharetra bibendum. Fusce viverra turpis et commodo dignissim. Maecenas consequat placerat luctus. Curabitur cursus turpis enim, in cursus odio lacinia vitae. ","https://cdn.videvo.net/videvo_files/video/premium/getty_105/large_watermarked/istock-1083459308_preview.mp4"))
        data2.add(MovieData2(R.drawable.fallen,"OLYMPUS HAS FALLEN","7/10",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin fermentum nisi at euismod imperdiet. Nullam molestie mi vel ante dictum sollicitudin. Quisque commodo arcu id diam interdum porta. Vivamus vel posuere nisi. Donec id lectus ac ipsum pharetra bibendum. Fusce viverra turpis et commodo dignissim. Maecenas consequat placerat luctus. Curabitur cursus turpis enim, in cursus odio lacinia vitae. ","https://cdn.videvo.net/videvo_files/video/free/video0467/large_watermarked/_import_61516692993d77.04238324_preview.mp4"))
        data2.add(MovieData2(R.drawable.brother,"BROTHERS","8/10",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin fermentum nisi at euismod imperdiet. Nullam molestie mi vel ante dictum sollicitudin. Quisque commodo arcu id diam interdum porta. Vivamus vel posuere nisi. Donec id lectus ac ipsum pharetra bibendum. Fusce viverra turpis et commodo dignissim. Maecenas consequat placerat luctus. Curabitur cursus turpis enim, in cursus odio lacinia vitae. ","https://cdn.videvo.net/videvo_files/video/premium/video0235/large_watermarked/03_pig_and_brevno_morning_113_slider_river_rays_preview.mp4"))
        adapter2 = ItemAdapter2(data2)
    }

    private fun init(){
        data.add(MovieData(R.drawable.witcher,"THE WITCHER","7/10",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin fermentum nisi at euismod imperdiet. Nullam molestie mi vel ante dictum sollicitudin. Quisque commodo arcu id diam interdum porta. Vivamus vel posuere nisi. Donec id lectus ac ipsum pharetra bibendum. Fusce viverra turpis et commodo dignissim. Maecenas consequat placerat luctus. Curabitur cursus turpis enim, in cursus odio lacinia vitae. ","https://cdn.videvo.net/videvo_files/video/free/video0467/large_watermarked/_import_61516586ee8571.11252072_preview.mp4"))
        data.add(MovieData(R.drawable.spiderman,"SPIDERMAN NO WAY HOME","8/10",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin fermentum nisi at euismod imperdiet. Nullam molestie mi vel ante dictum sollicitudin. Quisque commodo arcu id diam interdum porta. Vivamus vel posuere nisi. Donec id lectus ac ipsum pharetra bibendum. Fusce viverra turpis et commodo dignissim. Maecenas consequat placerat luctus. Curabitur cursus turpis enim, in cursus odio lacinia vitae. ","https://cdn.videvo.net/videvo_files/video/premium/2021-04/large_watermarked/210329_09_Bali_4k_005_preview.mp4"))
        data.add(MovieData(R.drawable.monster,"A MONSTER CALL","8/10",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin fermentum nisi at euismod imperdiet. Nullam molestie mi vel ante dictum sollicitudin. Quisque commodo arcu id diam interdum porta. Vivamus vel posuere nisi. Donec id lectus ac ipsum pharetra bibendum. Fusce viverra turpis et commodo dignissim. Maecenas consequat placerat luctus. Curabitur cursus turpis enim, in cursus odio lacinia vitae. ","https://cdn.videvo.net/videvo_files/video/free/2021-04/large_watermarked/210329_06B_Bali_1080p_013_preview.mp4"))
        data.add(MovieData(R.drawable.endgame,"AVENGER ENDGAME","9/10",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin fermentum nisi at euismod imperdiet. Nullam molestie mi vel ante dictum sollicitudin. Quisque commodo arcu id diam interdum porta. Vivamus vel posuere nisi. Donec id lectus ac ipsum pharetra bibendum. Fusce viverra turpis et commodo dignissim. Maecenas consequat placerat luctus. Curabitur cursus turpis enim, in cursus odio lacinia vitae. ","https://cdn.videvo.net/videvo_files/video/premium/getty_105/large_watermarked/istock-1083459308_preview.mp4"))
        data.add(MovieData(R.drawable.toe,"TOWER OF GOD","8/10",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin fermentum nisi at euismod imperdiet. Nullam molestie mi vel ante dictum sollicitudin. Quisque commodo arcu id diam interdum porta. Vivamus vel posuere nisi. Donec id lectus ac ipsum pharetra bibendum. Fusce viverra turpis et commodo dignissim. Maecenas consequat placerat luctus. Curabitur cursus turpis enim, in cursus odio lacinia vitae. ","https://cdn.videvo.net/videvo_files/video/free/video0467/large_watermarked/_import_61516692993d77.04238324_preview.mp4"))
        data.add(MovieData(R.drawable.re,"RESIDENT EVIL","7/10",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin fermentum nisi at euismod imperdiet. Nullam molestie mi vel ante dictum sollicitudin. Quisque commodo arcu id diam interdum porta. Vivamus vel posuere nisi. Donec id lectus ac ipsum pharetra bibendum. Fusce viverra turpis et commodo dignissim. Maecenas consequat placerat luctus. Curabitur cursus turpis enim, in cursus odio lacinia vitae. ","https://cdn.videvo.net/videvo_files/video/premium/video0235/large_watermarked/03_pig_and_brevno_morning_113_slider_river_rays_preview.mp4"))
        adapter = ItemAdapter(data)
    }

}