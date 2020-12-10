package com.example.myapplication

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.string.shouldHaveLength
import com.example.myapplication.Bmi.BmiForCmKg
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith

class BmiForCmKgTest: StringSpec({

    "test BMI correct values" {
        val bmi = BmiForCmKg(60.0, 176.0)
        bmi.count() shouldBe  (19.37 plusOrMinus 0.001)
    }

    "test BMI less than min mass" {
        val bmi = BmiForCmKg(BmiForCmKg.MIN_MASS - 1, 176.0)
        val exception = shouldThrow<Exception> {
            bmi.count()
        }
        exception.message should startWith("The mass is less than ${BmiForCmKg.MIN_MASS}")
    }

    "test BMI more than max mass" {
        val bmi = BmiForCmKg(BmiForCmKg.MAX_MASS + 1, 176.0)
        val exception = shouldThrow<Exception> {
            bmi.count()
        }
        exception.message should startWith("The mass is more than ${BmiForCmKg.MAX_MASS}")
    }

    "test BMI less than min height" {
        val bmi = BmiForCmKg(60.0,BmiForCmKg.MIN_HEIGHT - 1)
        val exception = shouldThrow<Exception> {
            bmi.count()
        }
        exception.message should startWith("The height is less than ${BmiForCmKg.MIN_HEIGHT}")
    }

    "test BMI more than max height" {
        val bmi = BmiForCmKg(60.0,BmiForCmKg.MAX_HEIGHT + 2)
        val exception = shouldThrow<Exception> {
            bmi.count()
        }
        exception.message should startWith("The height is more than ${BmiForCmKg.MAX_HEIGHT}")
    }
}) {
}