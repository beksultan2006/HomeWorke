package com.example.homeworke1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.homeworke1.databinding.FragmentFirstBinding


class FirstFragment : Fragment(), MainAdapter.SelectedListener {

    private lateinit var binding : FragmentFirstBinding
    private lateinit var adapter : MainAdapter
    private val listSelected = arrayListOf<ImageModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = arrayListOf<ImageModel>()
        list.add(ImageModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcToRooEkgUSA8K9EFYl5j7SbTmV_78crkCpZA&usqp=CAU"))
        list.add(ImageModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfgZxAXxuxM-R4cHYMuOzvpXhmKZtdOoS6og&usqp=CAU"))
        list.add(ImageModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcToRooEkgUSA8K9EFYl5j7SbTmV_78crkCpZA&usqp=CAU"))
        list.add(ImageModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcToRooEkgUSA8K9EFYl5j7SbTmV_78crkCpZA&usqp=CAU"))
        adapter = MainAdapter(list, requireContext(), this)
        binding.rvImg.adapter = adapter

        binding.imageNext.setOnClickListener{
            findNavController().navigate(R.id.secondFragment)
        }


        binding.imageNext.setOnClickListener{
            val bundle = Bundle()
            bundle.putSerializable("key", listSelected)
            findNavController().navigate(R.id.secondFragment, bundle)
        }
    }

    override fun select(selectImg: ImageModel) {
        listSelected.add(selectImg)
    }
}