package com.example.crud_34b

import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock

class CalculationUnitTest {

    @Test
    fun check_sum(){
        var calculations = Calculations()
        var result = calculations.add(5,5)

        assertEquals(10,result)
    }

    @Test
    fun check_sum_using_mockito(){
        var calculations = mock(Calculations::class.java)

    }
}