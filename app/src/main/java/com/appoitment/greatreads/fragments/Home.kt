package com.appoitment.greatreads.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appoitment.greatreads.R
import com.appoitment.greatreads.adapters.TrendingAdapter
import com.appoitment.greatreads.databinding.FragmentHomeBinding
import com.appoitment.greatreads.data.TrendingData
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class Home : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var recyclerView : RecyclerView
    private lateinit var trendingAdapter: TrendingAdapter
    private lateinit var database: DatabaseReference
    private lateinit var trendingDataList : ArrayList<TrendingData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.bFiction.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_categoriesFragment)
        }
        binding.bNonFiction.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_categoriesFragment)
        }
        binding.bAction.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_categoriesFragment)
        }
        binding.bBiography.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_categoriesFragment)
        }
        binding.bHorror.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_categoriesFragment)
        }
        binding.bHistory.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_categoriesFragment)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        database = Firebase.database.reference
        trendingDataList = arrayListOf<TrendingData>()
        getTrendingData()
    }

    fun setUpRecyclerView(trendingData: List<TrendingData>){
        trendingAdapter = TrendingAdapter(this,trendingData)
        binding.rvTrending.apply {
            adapter = trendingAdapter
            layoutManager = LinearLayoutManager(activity,  LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun getTrendingData(){
        database = FirebaseDatabase.getInstance().getReference("trending_books")

        database.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for (dataSnapshot in snapshot.children){
                        val trendingData = dataSnapshot.getValue(TrendingData::class.java)
                        trendingDataList.add(trendingData!!)
                    }
                    setUpRecyclerView(trendingDataList)
                }

            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }


}