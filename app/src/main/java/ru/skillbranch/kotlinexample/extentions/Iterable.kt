package ru.skillbranch.kotlinexample.extentions


fun <T> List<T>.dropLastUntil(predicate: (T) -> Boolean): List<T> {
    val predicateIndex = indexOf(filter(predicate).first())
    return dropLast(size - predicateIndex)
}