package com.example.radius.model

import org.json.JSONArray

data class Item(
    val exclusions: List<JSONArray>?,
    val facilities: List<FacilitiesItem>?
)


data class OptionsItem(
    val name: String = "",
    val icon: String = "",
    val id: String = ""
)


data class FacilitiesItem(
    val name: String = "",
    val options: List<OptionsItem>?,
    val facilityId: String = ""
)


