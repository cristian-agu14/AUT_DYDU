package uis;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class KnowledgesPage extends PageObject {

	public static final Target BUTTON_MAX_SCREEN = Target
			.the("Button for max the screen of creation of questions and answer")
			.located(By.id("knowledgesfullscreen_on"));

	public static final Target TEXT_FIELD_QUESTION = Target.the("Text firld for enter the question")
			.locatedBy("//div[@class='formulation-editor-field']");

	public static final Target BUTTON_CREATE = Target.the("Button for create a question")
			.locatedBy("//a[@class='button button_primary space_top_small js__submit']");

	public static final Target IFRAME = Target.the("Iframe of the questions and answers").locatedBy("(//iframe)[6]");

	public static final Target TEXT_FIELD_ANSWER = Target.the("Text field for enter the answer")
			.locatedBy("//body[contains(@data-id,'answerFld')]");

	public static final Target BUTTON_UPDATE = Target.the("This button save the know created")
			.locatedBy("//button[@type='submit' and @class='submitlink button button_primary']");

	public static final Target BUTTON_MIN_SCREEN = Target
			.the("Button for max the screen of creation of questions and answer")
			.located(By.id("knowledgesfullscreen_off"));

}
