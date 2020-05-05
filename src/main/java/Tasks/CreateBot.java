package Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static uis.HomePage.TEXT_FIELD_NAME_BOT;
import static uis.HomePage.SELECT_LANGUAGE_BOT;
import static uis.HomePage.BUTTON_CREATE;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateBot implements Task {

	private String nameBot;
	private String language;

	public CreateBot() {
		// It's Empty intentionally
	}

	public CreateBot(String nameBot, String language) {
		this.nameBot = nameBot;
		this.language = language;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		theActorInTheSpotlight().attemptsTo(Enter.theValue(nameBot).into(TEXT_FIELD_NAME_BOT));
		theActorInTheSpotlight().attemptsTo(SelectFromOptions.byVisibleText(language).from(SELECT_LANGUAGE_BOT));
		theActorInTheSpotlight().attemptsTo(Click.on(BUTTON_CREATE));
	}

	public static CreateBot whitNameAndLanguaje(String nameBot, String language) {
		return Tasks.instrumented(CreateBot.class, nameBot, language);
	}

}
