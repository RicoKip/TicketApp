package com.example.t0073651.ticketapp;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class CartTest {

    @Rule
    public ActivityTestRule<Cart> activityTestRuleCart = new ActivityTestRule<Cart>(Cart.class);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testCheckout(){
        Espresso.onView(withId(R.id.checkout)).perform(click());
        //Espresso.onView(withId(R.id.continue_shopping)).perform(click());

    }


    @After
    public void tearDown() throws Exception {
    }
}