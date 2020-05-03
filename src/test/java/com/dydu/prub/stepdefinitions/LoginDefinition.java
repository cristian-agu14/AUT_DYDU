package com.dydu.prub.stepdefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;

import Tasks.EnterUserAndPass;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import utils.WebDriverFactory;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginDefinition {

	@Before
	public void antesDelTest() {
		OnStage.setTheStage(new OnlineCast());
	}

	@Given("the user open the portal")
	public void theUserOpenThePortal() throws FileNotFoundException, IOException {
		OnStage.theActorCalled("The user").whoCan(BrowseTheWeb.with(WebDriverFactory.web().onPage("dydupage")));
	}

	@When("the user enter the user and password")
	public void theUserEnterTheUserAndPassword() {
		theActorInTheSpotlight().attemptsTo(EnterUserAndPass.inPageOfLogin());
	}

	@Then("the user see the homepage")
	public void theUserSeeTheHomepage() {
	}

}
