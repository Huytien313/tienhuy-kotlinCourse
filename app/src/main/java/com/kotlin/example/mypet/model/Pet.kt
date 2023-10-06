package com.kotlin.example.mypet.model

import androidx.room.Entity
import java.io.Serializable

@Entity(tableName = "pets")
data class Pet (
    val id: Int,
    val name: Int,
    val yearOld : Int,
    val breed: Int,
    val petImage: Int,
    val category: Int,
    val weight : Int,
    val typical: Int,
    val description: Int,
    val updateTime : Int
) : Serializable