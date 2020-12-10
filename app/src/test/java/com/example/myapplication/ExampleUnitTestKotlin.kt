package com.example.myapplication

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.string.shouldHaveLength

class ExampleUnitTestKotlin : StringSpec({

    "length should return size of string" {
        "hello" shouldHaveLength 5
    }
})