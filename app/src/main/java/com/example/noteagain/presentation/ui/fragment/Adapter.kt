package com.example.noteagain.presentation.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteagain.data.model.NoteEntity
import com.example.noteagain.databinding.ItemAdapterBinding
import com.example.noteagain.domain.model.Note

class Adapter():RecyclerView.Adapter<Adapter.ViewHolder>() {
    var list = emptyList<Note>()

    inner class ViewHolder(private val binding: ItemAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(noteEntity: Note) {
            with(binding) {
                textTitle.text = noteEntity.title
                todayDateTv.text = noteEntity.description
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAdapterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


    @JvmName("setList1")
    fun setList(liste: List<Note>) {
        list = liste
    }


}