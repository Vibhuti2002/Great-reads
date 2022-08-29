package com.appoitment.greatreads.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appoitment.greatreads.R
import com.appoitment.greatreads.adapters.CategoriesAdapter
import com.appoitment.greatreads.adapters.TrendingAdapter
import com.appoitment.greatreads.data.CategoriesData
import com.appoitment.greatreads.data.TrendingData
import com.appoitment.greatreads.databinding.FragmentCategoriesBinding
import com.appoitment.greatreads.databinding.FragmentHomeBinding
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class CategoriesFragment : Fragment() {

    private lateinit var binding : FragmentCategoriesBinding
    private lateinit var recyclerView : RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var database: DatabaseReference
    private lateinit var categoriesDataList : ArrayList<CategoriesData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoriesBinding.inflate(layoutInflater)
        val view = inflater.inflate(R.layout.fragment_categories, container, false)
        recyclerView = view.findViewById(R.id.rvCategories)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)
        categoriesDataList = arrayListOf<CategoriesData>()
        getCategoriesData()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        database = Firebase.database.reference
        categoriesDataList = arrayListOf<CategoriesData>()
        getCategoriesData()
    }

    private fun getCategoriesData(){
        database = FirebaseDatabase.getInstance().getReference("categories_books")

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for (dataSnapshot in snapshot.children){
                        val categoriesData = dataSnapshot.getValue(CategoriesData::class.java)
                        categoriesDataList.add(categoriesData!!)
                    }
                    setUpRecyclerView(categoriesDataList)
                }

            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }

    private fun setUpRecyclerView(categoriesData: List<CategoriesData>) {
        categoriesAdapter = CategoriesAdapter(this, categoriesData)
        recyclerView.adapter = categoriesAdapter
//        binding.rvCategories.apply {
//            adapter = categoriesAdapter
//            layoutManager = LinearLayoutManager(activity,  LinearLayoutManager.VERTICAL, false)
//        }
    }

}