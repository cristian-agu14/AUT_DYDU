package Tasks;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static uis.LoginPage.BUTTON_CONNECT;
import static uis.LoginPage.TEXT_FIELD_PASSWORD;
import static uis.LoginPage.TEXT_FIELD_USER;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class EnterUserAndPass implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {

		theActorInTheSpotlight().attemptsTo(Enter.theValue(System.getProperty("user")).into(TEXT_FIELD_USER));
		theActorInTheSpotlight().attemptsTo(Enter.theValue(System.getProperty("password")).into(TEXT_FIELD_PASSWORD));
		theActorInTheSpotlight().attemptsTo(Click.on(BUTTON_CONNECT));
	}

	public static EnterUserAndPass inPageOfLogin() {
		return Tasks.instrumented(EnterUserAndPass.class);
	}

}
