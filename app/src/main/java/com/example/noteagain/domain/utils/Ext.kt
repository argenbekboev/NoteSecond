package com.example.noteagain.domain.utils

import android.content.Context
import android.widget.Toast

fun Context.toast(context: Context,msg:String){
    Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
}