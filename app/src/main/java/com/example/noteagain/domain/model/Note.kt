package com.example.noteagain.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.noteagain.domain.model.Model.Companion.DEFOULT_Id
import java.io.Serializable

data class Note (
    val id:Int = DEFOULT_Id,
    val title:String,
    val description:String,
    val create:Long
):Serializable
 class Model{
     companion object{
         const val DEFOULT_Id =0
     }
 }
