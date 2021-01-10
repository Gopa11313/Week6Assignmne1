package com.example.week6assignment1.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week6assignment1.R
import com.example.week6assignment1.adapter.HomeAdapter
import com.example.week6assignment1.model.user
import com.example.week6assignment1.object2.users


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {
    private var listUSer=ArrayList<user>();
    private lateinit var recycleview: RecyclerView
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,

            ): View? {
        val rootview=inflater.inflate(R.layout.fragment_home, container, false)

        return rootview
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            recycleview = view.findViewById(R.id.recycle)
            recycleview.adapter?.notifyDataSetChanged()

//            users.listUSer.clear()
            val apapter = context?.let { HomeAdapter(users.listUSer) }
            recycleview.setHasFixedSize(true)
            recycleview.layoutManager = LinearLayoutManager(activity)
            recycleview.adapter = apapter;



    }


}

