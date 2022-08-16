package com.example.coupons.common.utils

import org.junit.Assert.*
import org.junit.Test
import com.example.coupons.R
import com.example.coupons.common.entities.CouponEntity

class CouponsUtilsKtTest{
    @Test

    fun validateTextCodeSuccessTest(){
        val code="Welcome"
        assertTrue(validateTextCode(code))
    }
    @Test

    fun validateTextCodeEmptyFailedTest(){
        val code="hola soy luisa velasquez"
        assertFalse(validateTextCode(code))
    }

    @Test

    fun getMsgErrorByCodeNullTest(){
        val errorCode=null
        val expectedValue= R.string.error_unknow

        val result= getMsgErrorByCode(errorCode)

        assertEquals("Error al evaluar un null", expectedValue,result)
    }
    @Test

    fun getMsgErrorByCodeExistTest(){
        val errorCode=Constants.ERROR_EXIST
        val expectedValue= R.string.Error_unique_code

        val result= getMsgErrorByCode(errorCode)

        assertEquals("Error al evaluar un cupon existente",expectedValue,result)
    }
    @Test

    fun getMsgErrorByCodeLengthTest(){
        val errorCode=Constants.ERROR_LENGTH
        val expectedValue= R.string.Error_invalid_length

        val result= getMsgErrorByCode(errorCode)

        assertEquals("Error al evaluar la longitud valida",expectedValue,result)
        assertNotEquals("El resurso no existe",-1,result)
    }
    @Test

    fun checkNotNullCouponTest(){
        val coupon= CouponEntity(code="ANDROID", description = "Cursos a $9.99 USD")
        assertNotNull(coupon)
    }
    @Test

    fun checkGroupSuccessTest(){
        val aNames= arrayOf("Luisa", "Nicole", "Maria")//valor actual
        val bNames= arrayOf("Luisa","Nicole","Maria")//valor esperado
        assertArrayEquals(bNames,aNames)
    }
    @Test

    fun checkGroupFailTest(){
        val aNames= arrayOf("Luisa", "Nicolas", "Maria")//valor actual
        val bNames= arrayOf("Luisa","Nicole","Maria")//valor esperado
        assertNotEquals(bNames,aNames)
    }
}