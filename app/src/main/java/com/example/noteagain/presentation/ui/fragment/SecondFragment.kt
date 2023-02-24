package com.example.noteagain.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.noteagain.R
import com.example.noteagain.data.model.NoteEntity
import com.example.noteagain.databinding.FragmentFirstBinding
import com.example.noteagain.databinding.FragmentSecondBinding
import com.example.noteagain.domain.model.Note
import com.example.noteagain.domain.utils.toast
import com.example.noteagain.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : BaseFragment() {
    private val viewModel :SecondViewModel by viewModels()
    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
create()
    }

    private fun edit() {
        viewModel.editNoteState.collectState(
            onLoading = {
                binding.progress.visibility = View.VISIBLE
            },
            Error = {
                activity?.toast(requireContext(),"error${it}")

            },
            onSuccess = {

            }
        )

    }

    private fun create() {
        binding.btnDesc.setOnClickListener {
            val title = binding.tvTitle.text.toString()
            val description = binding.tvDesc.text.toString()
            if (title.isEmpty() || description.isEmpty()) {
                activity?.toast(requireContext(), "заполните все поля")
            } else {

                viewModel.createNoteState.collectState(
                    onLoading = {
                        binding.progress.visibility = View.VISIBLE
                    },
                    Error = {
                        activity?.toast(requireContext(), "error${it}")

                    },
                    onSuccess = {
                        Note(0,title,description,System.currentTimeMillis())
                        Log.e("ololo", "create:${it} " )
findNavController().navigateUp()
                    })
            }
        }
    }
}