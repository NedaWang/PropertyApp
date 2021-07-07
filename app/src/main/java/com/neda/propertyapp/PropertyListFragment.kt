package com.neda.propertyapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.neda.propertyapp.adapter.RecyclerAdaper
import com.neda.propertyapp.databinding.FragmentPropertyListBinding
import com.neda.propertyapp.model.PropertiesData
import com.neda.propertyapp.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PropertyListFragment : Fragment(R.layout.fragment_property_list) {

    private val viewModel: MainViewModel by activityViewModels()
    private var _binding: FragmentPropertyListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerAdapter : RecyclerAdaper

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View{

        _binding = FragmentPropertyListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        recyclerAdapter = RecyclerAdaper(context, PropertiesData(listOf()))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.recyclerView.apply {
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(context)

            viewModel.propertiesLiveData.observe(getViewLifecycleOwner()){
                recyclerAdapter.setProperties(it)
            }
        }
    }
}