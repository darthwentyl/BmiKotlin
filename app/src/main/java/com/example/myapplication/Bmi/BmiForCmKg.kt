package com.example.myapplication.Bmi

import kotlin.Exception

class BmiForCmKg(
    private val mass: Double,
    private val height: Double
) : Bmi {

    override fun count(): Double {
        if (mass < MIN_MASS) {
            throw Exception("The mass is less than ${BmiForCmKg.MIN_MASS}")
        }
        if (mass > MAX_MASS) {
            throw Exception("The mass is more than ${BmiForCmKg.MAX_MASS}")
        }
        if (height < MIN_HEIGHT) {
            throw Exception("The height is less than ${BmiForCmKg.MIN_HEIGHT}")
        }
        if (height > MAX_HEIGHT) {
            throw Exception("The height is more than ${BmiForCmKg.MAX_HEIGHT}")
        }
        return mass / (height * height / 10000)
    }

    companion object {
        const val MIN_MASS = 45.0;
        const val MAX_MASS = 98.0;
        const val MIN_HEIGHT = 152.0;
        const val MAX_HEIGHT = 193.0
    }

}