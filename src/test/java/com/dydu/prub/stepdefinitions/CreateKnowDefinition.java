package com.dydu.prub.stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateKnowDefinition {

	@When("the user select a bot created with (.*)")
	public void theUserSelectABotCreatedWithBot_test_qa(String nameBot) {

	}

	@When("the user write a (.*) in the bot select")
	public void theUserWriteAInTheBotSelect(String question) {

	}

	@When("the user configure a (.*) for the question created")
	public void theUserConfigureAForTheQuestionCreated(String answer) {

	}

	@When("test the know to created")
	public void testTheKnowToCreated() {

	}

	@Then("user can to see the (.*) to the (.*)")
	public void userCanToSeeTheToTheEspagnol(String answer, String question) {

	}

}
