package com.example.lab_7

import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.junit4.v2.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // navigate to race screen
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // verify race screen
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // enter race location
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // add race location
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // verify race appears
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

    @Test
    fun goto_homescreen_addDriver_clearDrivers_backto_homescreen(){

        // verifying homescreen -> drivers screen
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()
        // verifying properly add at least one driver
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Guy")
        // verify driver exists
        composeTestRule
            .onNodeWithText("Guy")
            .assertExists()
        // verify that we can clear driver from list
        composeTestRule
            .onNodeWithTag("removeDriversButton")
            .performClick()
        // verify that text was removed
        composeTestRule
            .onNodeWithText("Guy")
            .assertDoesNotExist()
        // go back to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()
        // verify that we are at the home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }


}