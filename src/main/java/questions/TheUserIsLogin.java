package questions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static uis.HomePage.BUTTON_USER_HOMEPAGE;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheUserIsLogin implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {

		return BUTTON_USER_HOMEPAGE.resolveFor(theActorInTheSpotlight()).isVisible();

	}

	public static TheUserIsLogin successful() {
		return new TheUserIsLogin();
	}

}
