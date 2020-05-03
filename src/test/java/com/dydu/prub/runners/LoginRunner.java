package com.dydu.prub.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/login.feature", glue = "com.dydu.prub.stepdefinitions", tags = {
		"" }, snippets = SnippetType.CAMELCASE)
public class LoginRunner {

}
