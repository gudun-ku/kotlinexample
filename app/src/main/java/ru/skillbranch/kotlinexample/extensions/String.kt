package ru.skillbranch.kotlinexample.extensions

import ru.skillbranch.kotlinexample.Constants

fun String.getAsPhoneNumber():String? {
    return if (trim().isNullOrEmpty())
      null
    else
      replace("[^+\\d]".toRegex(), "")
}

fun String.isPhoneNumber():Boolean {
    val test = getAsPhoneNumber()
    return  if (test == null)
                false
            else
                test?.contains('+') && test.length -1 == Constants.PHONE_LENGTH
}