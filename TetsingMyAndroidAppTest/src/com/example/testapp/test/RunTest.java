package com.example.testapp.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith (Cucumber.class)
@CucumberOptions(format = {"pretty", "html:/sdcard/android.test/cucumber-html", "json:/sdcard/android.test/report.json"}, features = "features")
public class RunTest {

}