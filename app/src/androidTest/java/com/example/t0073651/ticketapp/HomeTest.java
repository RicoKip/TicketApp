package com.example.t0073651.ticketapp;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class HomeTest {
    @Rule
    public ActivityTestRule<Home> activityTestRuleLogin = new ActivityTestRule<Home>(Home.class);
    //input test data

    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void selecTicket(){
        //Open the view
        // select item from recylcler view
        Espresso.onView(withId(R.id.main_recycler_view)).perform(click());
    }

    @After
    public void tearDown() throws Exception {
    }
}