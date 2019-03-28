package com.example.t0073651.ticketapp;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import Database.DatabaseHelper;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class LoginTest {
    @Rule
    public ActivityTestRule<Login> activityTestRuleLogin = new ActivityTestRule<Login>(Login.class);
    //input test data
    private String uName = "";
    private String pWord = "";

    //private String result = "Login Successful";
    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void testUserInput(){
        //input text
        Espresso.onView(withId(R.id.usernameTXT)).perform(typeText(uName));
        Espresso.onView(withId(R.id.passwordTXT)).perform(typeText(pWord));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.loginBTN)).perform(click());
    }

    @After
    public void tearDown() throws Exception {
    }
}