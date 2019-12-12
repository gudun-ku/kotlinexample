package ru.skillbranch.kotlinexample.extentions

import ru.skillbranch.kotlinexample.Constants

fun String.getAsPhoneNumber():String {
    return replace("[^+\\d]".toRegex(), "")
}

fun String.isPhoneNumber():Boolean {
    val test = getAsPhoneNumber()
    return test?.contains('+') && test.length -1 == Constants.PHONE_LENGTH
}