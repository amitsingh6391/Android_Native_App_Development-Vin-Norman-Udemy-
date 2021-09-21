package com.amitapps.theshamelessselfpromoapp

import java.io.Serializable

data class Message(
    val contactName: String,
    val contactNumber: String,
    val myDisplayName: String,
    val jobTitle: String?,
    val includeJunior: Boolean,
    val immediateStart: Boolean,
    val startDate: String?
) : Serializable {
    fun getFullJobDescription() = if (includeJunior) "a Junior $jobTitle" else "an $jobTitle"


    fun getAvailabilty() = if (immediateStart) "Immediately" else "from $startDate"
}