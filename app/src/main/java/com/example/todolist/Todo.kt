package com.example.todolist

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Todo (
    val title: String = "",
    var isChecked: Boolean = false
): Parcelable