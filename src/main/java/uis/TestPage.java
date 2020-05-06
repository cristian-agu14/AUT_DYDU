package uis;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class TestPage extends PageObject {

	public static final Target BUTTON_FOR_TEST = Target.the("This button is for start the test of the know created")
			.locatedBy("//button[@class='button button_secondary button_only-icon']");

	public static final Target TEXT_FIELD_QUESTION = Target.the("In this text field write the questions for the bot")
			.locatedBy("//input[@name='userInput']");

	public static final Target BUTTON_SEND_QUESTION = Target
			.the("Button for sed the question for the bot return an answer").located(By.id("userInputBtn"));

	public static Target TEXT_BOX_OF_ANSWER = Target
			.the("This text box is in the chat box when the user enter a question")
			.locatedBy("//div[@id='stepaction_{0}']//div//div//div[@class='frame']");

}
