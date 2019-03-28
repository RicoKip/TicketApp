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

public class TicketsTest {
    @Rule
    public ActivityTestRule<Tickets> activityTestRuleCart = new ActivityTestRule<Tickets>(Tickets.class);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void pressBackBtn(){
        Espresso.onView(withId(R.id.exitBtn)).perform(click());
    }

    @After
    public void tearDown() throws Exception {
    }
}