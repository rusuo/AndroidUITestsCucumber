package com.example.testapp.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith (Cucumber.class)
@CucumberOptions(format = {"pretty", "html:/data/data/com.example.testapp/report"}, features = "features")
public class RunTest {

}