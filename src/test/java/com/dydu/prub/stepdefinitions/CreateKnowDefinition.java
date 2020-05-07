package com.dydu.prub.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import Tasks.InTheChatBot;
import Tasks.IntoAnswer;
import Tasks.IntoQuestion;
import Tasks.IntoToCreateKnow;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import questions.WhichIsTheAnswer;

public class CreateKnowDefinition {

	@When("the user select a bot created with (.*)")
	public void theUserSelectABotCreatedWithBot_test_qa(String nameBot) {
		theActorInTheSpotlight().attemptsTo(IntoToCreateKnow.newInTheBot(nameBot));
	}

	@When("the user write a question (.*) in the bot select")
	public void theUserWriteAInTheBotSelect(String question) {
		theActorInTheSpotlight().attemptsTo(IntoQuestion.inField(question));
	}

	@When("the user configure a answer (.*) for the question created")
	public void theUserConfigureAForTheQuestionCreated(String answer) {
		theActorInTheSpotlight().attemptsTo(IntoAnswer.inField(answer));
	}

	@When("test the know to created with the question (.*)")
	public void testTheKnowToCreated(String question) {
		theActorInTheSpotlight().attemptsTo(InTheChatBot.enterTheQuestion(question));
	}

	@Then("user can to see the (.*) is correct")
	public void userCanToSeeTheToTheEspagnol(String answer) {
		theActorInTheSpotlight().should(seeThat(WhichIsTheAnswer.ofChatBot(), equalTo(answer)));
	}

}
