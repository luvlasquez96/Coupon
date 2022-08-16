package com.example.coupons

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.coupons.mainModule.view.MainActivity
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityCreateTest {
    @get:Rule
    val activityRule= ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun createCouponTest(){
        val etCoupon= onView(withId(R.id.etcoupon))
        etCoupon.check(matches(withText("")))// verifica que (una vista) coincida con el texto ""
        etCoupon.perform(click())
        etCoupon.perform(replaceText("WELCOME_01"))

        val btn_consult= onView(withId(R.id.btn_consult))
        btn_consult.perform(click())

        val btn_create= onView(withId(R.id.btn_create))
        btn_create.check(matches(isDisplayed()))

        val etDescription= onView(withId(R.id.etdescription))
        etDescription.perform(replaceText("DESCUENTO 10%"))
        btn_create.perform(click())

        /*val snackbar= onView(withText(com.google.android.material.R.id.snackbar_text))
        snackbar.check(matches(withText("Cupon creado")))*/




    }

    /*@Test

    fun consultcouponExistTest(){
            val etCoupon= onView(withId(R.id.etcoupon))
            etCoupon.check(matches(withText("")))// verifica que (una vista) coincida con el texto ""
            etCoupon.perform(click())
            etCoupon.perform(replaceText("WELCOME_01"))

            val btn_consult= onView(withId(R.id.btn_consult))
            btn_consult.perform(click())

            val btn_create= onView(withId(R.id.btn_create))
            btn_create.check(matches(not(isDisplayed())))//!=not

    }*/

    /*@Test
    fun createCouponWithOldCodeTest(){
        val etCoupon= onView(withId(R.id.etcoupon))

        etCoupon.perform(replaceText("WELCOME_012"))

        val btn_Consult= onView(withId(R.id.btn_consult))
        btn_Consult.perform(click())

        val btn_Create= onView(withId(R.id.btn_create))
        btn_Create.check(matches(isDisplayed()))//!=not

        val etDescription= onView(withId(R.id.etdescription))
        etDescription.perform(replaceText("DESCUENTO 10%"))
        etCoupon.perform(replaceText("WELCOME_01"))

        btn_Create.perform(click())

        val snackbar= onView(withText(com.google.android.material.R.id.snackbar_text))
        snackbar.check(matches(withText("Cupon ya existe")))
    }*/

}