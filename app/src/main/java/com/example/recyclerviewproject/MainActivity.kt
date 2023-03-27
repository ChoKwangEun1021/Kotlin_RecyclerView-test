package com.example.recyclerviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclerviewproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var dataList: MutableList<DataList>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //1. mutalble 데이터 리스트를 만들어서 adapter에 제공
        dataList = mutableListOf<DataList>()
        for (i in 1..30){
            if(i % 2 == 0){
                dataList.add(DataList("홍길동${i}", "${20+i}세", "rkskek${i}@gamil.com", R.drawable.man))
            }else{
                dataList.add(DataList("홍길녀${i}", "${20+i}세", "rkskek${i}@gamil.com", R.drawable.woman))
            }
        }// end of for

        //2. customAdapter(dataList)
        val customAdapter = CustomAdapter(dataList)
        //3. RecycleView에 Adapter 적용시킴
        binding.recyclerView.adapter = customAdapter
        //4. LayoutManger 통해서 리사이클러뷰에 방향을 설정
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerView.layoutManager = layoutManager
    }
}