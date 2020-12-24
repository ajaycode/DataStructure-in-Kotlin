package linkedlist

import java.lang.IllegalStateException


// ---------- Linked List ---------------
val LinkedList<Int>.isSortedAscending: Boolean
    get() {
        var current = firstOrNull
        var next = firstOrNull
        while (current != null && next != null) {
            val isAscending = (current.value ?: Int.MIN_VALUE) <= (next.value ?: Int.MIN_VALUE)
            if (!isAscending) {
                return false
            }
            current = next
            next = current.next
        }
        return true
    }

val LinkedList<Int>.isSortedDescending: Boolean
    get() {
        var current = firstOrNull
        var next = firstOrNull
        while (current != null && next != null) {
            val isDescending = (current.value ?: Int.MIN_VALUE) >= (next.value ?: Int.MIN_VALUE)
            if (!isDescending) {
                return false
            }
            current = next
            next = current.next
        }
        return true
    }

val <T> LinkedList<T>.isCyclic:Boolean
    get() {
        TODO()
    }

fun <T> LinkedList<T>.forEach(iteration: (element: T?) -> Unit) {
    var current = firstOrNull
    while (current != null) {
        iteration.invoke(current.value)
        current = current.next
    }
}

fun <T> LinkedList<T>.toMutableLinkedList(): MutableLinkedList<T> {
    return LinkedCollection.mutableFrom(this)
}

