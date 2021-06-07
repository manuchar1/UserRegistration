package com.example.userregistration.model


import androidx.annotation.Keep

@Keep
data class UserDataSubListItem(
    val field_id: Int,
    val field_type: String,
    val hint: String,
    val icon: String,
    val is_active: Boolean,
    val keyboard: String,
    val required: String
)