package Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static uis.TestPage.BUTTON_FOR_TEST;
import static uis.TestPage.TEXT_FIELD_QUESTION;
import static uis.TestPage.BUTTON_SEND_QUESTION;

import java.util.concurrent.TimeUnit;

import org.slf4j.LoggerFactory;

public class InTheChatBot implements Task {

	public String question;

	public InTheChatBot(String question) {
		this.question = question;
	}

	public InTheChatBot() {
		// It's empty intentionally
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(BUTTON_FOR_TEST));
		actor.attemptsTo(Enter.theValue(question).into(TEXT_FIELD_QUESTION));
		actor.attemptsTo(Click.on(BUTTON_SEND_QUESTION));
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			LoggerFactory.getLogger(this.getClass()).error(e.getMessage(), e);
		}
	}

	public static InTheChatBot enterTheQuestion(String question) {
		return Tasks.instrumented(InTheChatBot.class, question);

	}

}
