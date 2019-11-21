package com.ayokunlepaul.bitcoingrafik

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ayokunlepaul.bitcoingrafik.presentation.fragments.MainFragment
import com.ayokunlepaul.bitcoingrafik.presentation.fragments.MainFragmentDirections
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainFragmentTest {

    @MockK
    lateinit var controller: NavController

    private lateinit var scenario: FragmentScenario<MainFragment>

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        scenario = launchFragmentInContainer<MainFragment>(themeResId = R.style.BitCoinGrafikAppTheme)
    }

    @Test
    fun testTextOnButton() {
        onView(withId(R.id.get_bitcoin_graph)).check(matches(withText(R.string.get_my_stat)))
    }

    @Test
    fun testNavigationToChartFragment() {
        scenario.onFragment { Navigation.setViewNavController(it.requireView(), controller) }
        onView(withId(R.id.get_bitcoin_graph)).perform(click())
        verify(atLeast = 1) {
            val direction = MainFragmentDirections.actionFragmentMainToFragmentBitcoinChart()
            controller.navigate(direction)
        }
    }
}