package com.neda.propertyapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.neda.propertyapp.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.neda.propertyapp.databinding.FragmentPropertyDetailBinding

@AndroidEntryPoint
class PropertyDetailFragment : Fragment(R.layout.fragment_property_detail) {

    private val viewModel: MainViewModel by activityViewModels()
    val args: PropertyDetailFragmentArgs by navArgs()
    private var _binding: FragmentPropertyDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View{

        _binding = FragmentPropertyDetailBinding.inflate(inflater,container,false)

        val propertyID = args.propertyID
        binding.textView.text = propertyID
        return binding.root
    }

}