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
                breed = R.string.garybreed,
                petImage = R.drawable.ic_pet1,
                category = 0,
                weight = R.string.garyweight,
                updateTime = R.string.garyDate,
                description = R.string.descriptionDetail,
                typical = R.string.garytypical
            ),
            Pet(
                id =2,
                name = R.string.peach,
                yearOld = R.string.peachyearold,
                breed = R.string.peachbreed,
                petImage = R.drawable.ic_pet3,
                category = 1,
                weight = R.string.peachweight,
                updateTime = R.string.peachDate,
                description = R.string.descriptionDetail,
                typical = R.string.peachtypical
            ),
            Pet(
                id =3,
                name = R.string.whitney,
                yearOld = R.string.whitneyyearold,
                breed = R.string.whitneybreed,
                petImage = R.drawable.ic_pet7,
                category = 1,
                weight = R.string.whitneyweight,
                updateTime = R.string.whitneyDate,
                description = R.string.descriptionDetail,
                typical = R.string.whitneytypical
            ),
            Pet(
                id =4,
                name = R.string.bugy,
                yearOld = R.string.bugyyearold,
                breed =R.string.bugybreed,
                petImage = R.drawable.ic_pet8,
                category = 0,
                weight = R.string.bugyweight,
                updateTime = R.string.bugyDate,
                description = R.string.descriptionDetail,
                typical = R.string.bugytypical
            ),
            Pet(
                id =5,
                name = R.string.willie,
                yearOld =R.string.willieyearold,
                breed = R.string.willieybreed,
                petImage = R.drawable.ic_pet5,
                category = 0,
                weight = R.string.willieweight,
                updateTime = R.string.willieDate,
                description = R.string.descriptionDetail,
                typical = R.string.willietypical
            ),
            Pet(
                id =6,
                name = R.string.kiwi,
                yearOld = R.string.kiwiyearold,
                breed = R.string.kiwibreed,
                petImage = R.drawable.ic_pet10,
                category = 0,
                weight = R.string.kiwiweight,
                updateTime = R.string.kiwiDate,
                description = R.string.descriptionDetail,
                typical = R.string.kiwitypical
            ),
            Pet(
                id =7,
                name = R.string.stitch,
                yearOld = R.string.stitchyearold,
                breed =R.string.stitchbreed,
                petImage = R.drawable.ic_pet4,
                0,
                weight = R.string.stitchweight,
                updateTime = R.string.stitchDate,
                description = R.string.descriptionDetail,
                typical = R.string.stitchtypical
            ),
            Pet(
                id =8,
                name =R.string.cake,
                yearOld = R.string.cakeyearold,
                breed = R.string.cakebreed,
                petImage = R.drawable.ic_pet2,
                0,
                weight = R.string.cakeweight,
                updateTime = R.string.kiwiDate,
                description = R.string.descriptionDetail,
                typical = R.string.kiwitypical
            ),
            Pet(
                id =9,
                name = R.string.moon,
                yearOld = R.string.moonyearold,
                breed = R.string.moonbreed,
                petImage = R.drawable.ic_pet9,
                1,
                weight = R.string.moonweight,
                updateTime = R.string.kiwiDate,
                description = R.string.descriptionDetail,
                typical = R.string.kiwitypical
            ),
            Pet(
                id =10,
                name = R.string.spike,
                yearOld =R.string.spikeyearold,
                breed = R.string.spikebreed,
                petImage = R.drawable.ic_pet6,
                0,
                weight = R.string.spikeweight,
                updateTime = R.string.kiwiDate,
                description = R.string.descriptionDetail,
                typical = R.string.kiwitypical
            )
        )
    }
}