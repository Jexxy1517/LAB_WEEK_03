package com.example.lab_week_03

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class ListFragment : Fragment(), View.OnClickListener {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var coffeeListener: CoffeeListener;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is CoffeeListener){
            coffeeListener = context
        } else {
            throw RuntimeException("Must implement CoffeeListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: android.view.LayoutInflater, container: android.view.ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(com.example.lab_week_03.R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val coffeeList = listOf<View>(
            view.findViewById(com.example.lab_week_03.R.id.affogato),
            view.findViewById(com.example.lab_week_03.R.id.americano),
            view.findViewById(com.example.lab_week_03.R.id.latte)
        )

        coffeeList.forEach{
            it.setOnClickListener(this)
        }
    }

    override fun onClick(v: View?) {
        v ?. let{ coffee ->
            coffeeListener.onSelected(coffee.id)
        }
    }

    companion object {

    }
}