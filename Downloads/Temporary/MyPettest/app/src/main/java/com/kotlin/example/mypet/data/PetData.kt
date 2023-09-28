package com.kotlin.example.mypet.data

import com.kotlin.example.mypet.R
import com.kotlin.example.mypet.model.Pet

object PetData {
    fun getPetData() : ArrayList<Pet> {
        return arrayListOf(
            Pet(
                id =1,
                name = R.string.gary,
                yearOld = R.string.garyyearold,
                bread = R.string.garybreed,
                petImage = R.drawable.ic_pet1,
                category = 0
            ),
            Pet(
                id =2,
                name = R.string.peach,
                yearOld = R.string.peachyearold,
                bread = R.string.peachbreed,
                petImage = R.drawable.ic_pet3,
                category = 1
            ),
            Pet(
                id =3,
                name = R.string.whitney,
                yearOld = R.string.whitneyyearold,
                bread = R.string.whitneybreed,
                petImage = R.drawable.ic_pet7,
                category = 1
            ),
            Pet(
                id =4,
                name = R.string.bugy,
                yearOld = R.string.bugyyearold,
                bread =R.string.bugybreed,
                petImage = R.drawable.ic_pet8,
                category = 0
            ),
            Pet(
                id =5,
                name = R.string.willie,
                yearOld =R.string.willieyearold,
                bread = R.string.willieybreed,
                petImage = R.drawable.ic_pet5,
                category = 0
            ),
            Pet(
                id =6,
                name = R.string.kiwi,
                yearOld = R.string.kiwiyearold,
                bread = R.string.kiwibreed,
                petImage = R.drawable.ic_pet10,
                category = 0
            ),
            Pet(
                id =7,
                name = R.string.stitch,
                yearOld = R.string.stitchyearold,
                bread =R.string.stitchbreed,
                petImage = R.drawable.ic_pet4,
                0
            ),
            Pet(
                id =8,
                name =R.string.cake,
                yearOld = R.string.cakeyearold,
                bread = R.string.cakebreed,
                petImage = R.drawable.ic_pet2,
                0
            ),
            Pet(
                id =9,
                name = R.string.moon,
                yearOld = R.string.moonyearold,
                bread = R.string.moonbreed,
                petImage = R.drawable.ic_pet9,
                1
            ),
            Pet(
                id =10,
                name = R.string.spike,
                yearOld =R.string.spikeyearold,
                bread = R.string.spikebreed,
                petImage = R.drawable.ic_pet6,
                0
            )
        )
    }
}