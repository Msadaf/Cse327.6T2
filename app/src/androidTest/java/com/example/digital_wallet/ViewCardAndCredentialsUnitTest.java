package com.example.digital_wallet;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import androidx.test.filters.SmallTest;

import static org.junit.Assert.*;
@RunWith(JUnit4.class)
@SmallTest
public class ViewCardAndCredentialsUnitTest {
    private ViewCardAndCredentials Stringcheck;
@Rule

    @Before
    public void setUp() throws Exception {
    Stringcheck=new ViewCardAndCredentials();
    Stringcheck.Catagory("Cards");
    }

    @Test
    public void testLaunch(){
assertEquals("Cards","Cards");
    }
    @After
    public void tearDown() throws Exception {
    }
}