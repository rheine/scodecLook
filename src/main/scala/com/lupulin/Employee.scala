package com.lupulin

import java.util.Date

/**
 * Sample Employee CC given.
 * @param firstName
 * @param middleInitial
 * @param lastName
 * @param dateOfBirth
 * @param startDate
 * @param terminationDate
 * @param rank
 */
case class Employee(firstName: String,
                    middleInitial: Option[Char],
                    lastName: String,
                    dateOfBirth: Date,
                    startDate: Date,
                    terminationDate: Option[Date],
                    rank: Int
                     )

/**
 * This is probably not necessary...
 */
object Employee {
  val defaultEmplyee =  Employee("Johan",Some('C'),"Do",new Date(),new Date(), None, 5)
}