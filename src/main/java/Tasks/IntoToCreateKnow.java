package Tasks;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static uis.HomePage.BUTTON_SOCIAL;
import static uis.HomePage.CARD_BUTTON_CREATE;
import static uis.HomePage.CARD_BUTTON_CREATE_QUESTION;
import static uis.HomePage.CARD_BUTTON_KNOW;
import static uis.HomePage.ELEMENT_LIST_BOTS;

import java.util.concurrent.TimeUnit;

import org.slf4j.LoggerFactory;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class IntoToCreateKnow implements Task {

	private String nameBot;

	public IntoToCreateKnow() {
		// It's empty intentionally
	}

	public IntoToCreateKnow(String nameBot) {
		this.nameBot = nameBot;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		if (!ELEMENT_LIST_BOTS.of(nameBot).resolveFor(actor).isVisible()) {
			theActorInTheSpotlight().attemptsTo(Click.on(BUTTON_SOCIAL));
		}

		theActorInTheSpotlight().attemptsTo(Click.on(ELEMENT_LIST_BOTS.of(nameBot)));
		theActorInTheSpotlight().attemptsTo(Click.on(CARD_BUTTON_KNOW));

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			LoggerFactory.getLogger(this.getClass()).error(e.getMessage(), e);
		}

		theActorInTheSpotlight().attemptsTo(Click.on(CARD_BUTTON_CREATE));
		theActorInTheSpotlight().attemptsTo(Click.on(CARD_BUTTON_CREATE_QUESTION));

	}

	public static IntoToCreateKnow newInTheBot(String nameBot) {
		return Tasks.instrumented(IntoToCreateKnow.class, nameBot);
	}

}
