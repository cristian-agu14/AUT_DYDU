package Tasks;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static uis.KnowledgesPage.BUTTON_MAX_SCREEN;
import static uis.KnowledgesPage.IFRAME;
import static uis.KnowledgesPage.TEXT_FIELD_ANSWER;

import org.openqa.selenium.WebDriver;

import static uis.KnowledgesPage.BUTTON_UPDATE;
import static uis.KnowledgesPage.BUTTON_MIN_SCREEN;

import interactions.Switch;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.IFrame;
import net.serenitybdd.screenplay.targets.Target;

public class IntoAnswer implements Task {

	private String answer;

	public IntoAnswer() {
		// It's empty intentionally
	}

	public IntoAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		WebDriver driver = Serenity.getWebdriverManager().getCurrentDriver();

		//theActorInTheSpotlight().attemptsTo(Click.on(BUTTON_MAX_SCREEN));

		theActorInTheSpotlight().attemptsTo(Switch.toFrame(driver, IFRAME));
		theActorInTheSpotlight().attemptsTo(Enter.theValue(answer).into(TEXT_FIELD_ANSWER));

		theActorInTheSpotlight().attemptsTo(Switch.toFrame(driver).backFrame());

		theActorInTheSpotlight().attemptsTo(Click.on(BUTTON_UPDATE));
		//theActorInTheSpotlight().attemptsTo(Click.on(BUTTON_MAX_SCREEN));

	}

	public static IntoAnswer inField(String answer) {
		return Tasks.instrumented(IntoAnswer.class, answer);
	}

}
