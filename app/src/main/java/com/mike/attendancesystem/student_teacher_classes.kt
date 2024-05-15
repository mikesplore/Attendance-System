package com.mike.attendancesystem

open class Person(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val email: String,
    val id: String
)

class Teacher(
    firstName: String,
    lastName: String,
    age: Int,
    email: String,
    id: String,
    val subjectTaught: String
) : Person(firstName, lastName, age, email, id)

class Student(
    firstName: String,
    lastName: String,
    age: Int,
    email: String,
    id: String,
    val grade: Int
) : Person(firstName, lastName, age, email, id)

