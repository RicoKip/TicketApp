package com.example.t0073651.ticketapp;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class RegisterTest {
    @Rule
    public ActivityTestRule<Register> activityTestRuleRegister = new ActivityTestRule<Register>(Register.class);

    //set test data
    private String fName = "";
    private String lName = "";
    private String uName = "";
    private String pWord = "";
    private String eMail = "";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testUserRegistration(){
        Espresso.onView(withId(R.id.fnameTXT)).perform(typeText(fName));
        Espresso.onView(withId(R.id.lnameTXT)).perform(typeText(lName));
        Espresso.onView(withId(R.id.usernameTXT2)).perform(typeText(uName));
        Espresso.onView(withId(R.id.passwordTXT2)).perform(typeText(pWord));
        Espresso.onView(withId(R.id.emailTXT)).perform(typeText(eMail));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.submitBTN)).perform(click());
    }

    @After
    public void tearDown() throws Exception {
    }
}