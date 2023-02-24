package com.example.noteagain.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.noteagain.R
import com.example.noteagain.presentation.base.BaseFragment
import com.example.noteagain.databinding.FragmentFirstBinding
import com.example.noteagain.domain.model.Note
import com.example.noteagain.domain.utils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : BaseFragment() {
private val viewModel :FirstViewModel by viewModels()
    private lateinit var binding: FragmentFirstBinding
    private lateinit var adapter :Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = Adapter()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
utils()
        adapter()
        getAll()
    }

    private fun utils() {

        binding.btn.setOnClickListener {
            findNavController().navigate(R.id.secondFragment)
        }
    }

    private fun adapter() {




    }
    private fun delete() {

        viewModel.deleteNoteState.collectState(
            onLoading = {
                        binding.progress.visibility = View.VISIBLE
            },
            Error = {
activity?.toast(requireContext(),"error${it}")
            },
            onSuccess = {

            })


    }

    private fun getAll() {
viewModel.getAllNoteState.collectState(
    onLoading = {
        binding.progress.visibility = View.VISIBLE


    },
    Error = {
        activity?.toast(requireContext(),"error${it}")

},
    onSuccess = {
        binding.recycler.adapter = adapter

        adapter.setList(it)
})
    }
}