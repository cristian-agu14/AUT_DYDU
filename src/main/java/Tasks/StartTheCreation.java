package Tasks;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static uis.HomePage.BUTTON_CREER_UN_BOT;
import static uis.HomePage.BUTTON_SOCIAL;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class StartTheCreation implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		//theActorInTheSpotlight().attemptsTo(BUTTON_SOCIAL.resolveFor(theActorInTheSpotlight()).waitUntilVisible());
		theActorInTheSpotlight().attemptsTo(Click.on(BUTTON_SOCIAL));
		theActorInTheSpotlight().attemptsTo(Click.on(BUTTON_CREER_UN_BOT));
	}

	public static StartTheCreation ofABot() {
		return Tasks.instrumented(StartTheCreation.class);
	}

}
