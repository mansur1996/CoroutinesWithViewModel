package com.example.coroutines.model

data class User(
	val id: Int,
	val name: String,
	val username: String,
	val company: Company,
	val website: String,
	val address: Address,
	val phone: String,
	val email: String,
)
