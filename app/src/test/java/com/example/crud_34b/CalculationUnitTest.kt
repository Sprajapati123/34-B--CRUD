package com.example.crud_34b

import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class CalculationUnitTest {

    @Test
    fun check_sum(){
        var calculations = Calculations()
        var result = calculations.add(5,5)

        assertEquals(10,result)
    }

    //Given Calculation class
    //When 1+1 passed in add function
    //Then return 2
    @Test
    fun check_sum_using_mockito(){
        var calculations = mock(Calculations::class.java)

        `when`(calculations.add(5,5)).thenReturn(10)

        assertEquals(calculations.add(5,5),10)
    }
}