package models

data class Email(
    val sender: String,
    val subject: String,
    val message: String
)