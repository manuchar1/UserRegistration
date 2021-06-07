package com.example.userregistration.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.userregistration.adapter.UserAdapter
import com.example.userregistration.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private var binding: MainFragmentBinding? = null
    private val viewModel by viewModels<MainViewModel>()

    var adapter = UserAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel._usersLiveData.observe(viewLifecycleOwner, {
            adapter.setData(it.toMutableList())
        })

        viewModel._childLiveData.observe(viewLifecycleOwner, {
            adapter.UserChildAdapter().setDataTochild(it.toMutableList())
        })


        viewModel.init()
        initRecycler()
    }
    private fun initRecycler() {
        adapter = UserAdapter()
        binding?.recyclerView?.layoutManager = LinearLayoutManager(requireActivity())
        binding?.recyclerView?.adapter = adapter
    }
}