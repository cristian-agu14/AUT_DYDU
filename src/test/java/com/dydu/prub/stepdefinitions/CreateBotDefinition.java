package com.dydu.prub.stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import questions.TheTarget;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import Tasks.CreateBot;
import Tasks.StartTheCreation;
import static uis.HomePage.ELEMENT_LIST_BOTS;
import static uis.HomePage.BUTTON_SOCIAL;

public class CreateBotDefinition {

	@When("the user start to create the bot")
	public void theUserStartToCreateTheBot() {
		theActorInTheSpotlight().attemptsTo(StartTheCreation.ofABot());
	}

	@When("enter (.*) and (.*) for the user")
	public void theUserEnterBot_test_qaAndEspagnol(String nameBot, String language) {
		theActorInTheSpotlight().attemptsTo(CreateBot.whitNameAndLanguaje(nameBot, language));
	}

	@Then("the user can to see the bot created with the name (.*)")
	public void theUserCanToSeeTheBotCreatedWithThe(String nameBot) {
		theActorInTheSpotlight().attemptsTo(Click.on(BUTTON_SOCIAL));
		theActorInTheSpotlight().should(seeThat(TheTarget.isPresent(ELEMENT_LIST_BOTS.of(nameBot))));
	}

}
