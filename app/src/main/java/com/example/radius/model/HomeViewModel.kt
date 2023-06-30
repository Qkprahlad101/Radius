package com.example.radius.model

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    var apartments: List<FacilitiesItem> = emptyList()
    var condos: List<FacilitiesItem> = emptyList()
    var boatHouses: List<FacilitiesItem> = emptyList()
    var lands: List<FacilitiesItem> = emptyList()

    fun setData(items: List<FacilitiesItem>) {
        apartments = items.filter { it.name == "Apartment" }
        condos = items.filter { it.name == "Condo" }
        boatHouses = items.filter { it.name == "Boat House" }
        lands = items.filter { it.name == "Land" }
    }
}
