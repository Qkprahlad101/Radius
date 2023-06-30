package com.example.radius.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.radius.view.FirstFragment
import com.example.radius.view.FourthFragment
import com.example.radius.view.SecondFragment
import com.example.radius.view.ThirdFragment

class MainPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            2 -> ThirdFragment()
            3 -> FourthFragment()
            else -> throw IllegalArgumentException("Invalid position")
        }
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Apartment"
            1 -> "Condo"
            2 -> "Boat House"
            3 -> "Land"
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}