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

public class CheckoutTest {
    @Rule
    public ActivityTestRule<Checkout> activityTestRuleCart = new ActivityTestRule<Checkout>(Checkout.class);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void selectPay(){
        Espresso.onView(withId(R.id.btnPay)).perform(click());
    }

    @After
    public void tearDown() throws Exception {
    }
}