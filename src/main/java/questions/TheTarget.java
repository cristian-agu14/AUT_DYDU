package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class TheTarget implements Question<Boolean> {

	private Target webElement;

	public TheTarget(Target webElement) {
		super();
		this.webElement = webElement;
	}

	public TheTarget() {
		// It's empty intentionally
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		return webElement.resolveFor(actor).isPresent();
	}

	public static TheTarget isPresent(Target webElement) {
		return new TheTarget(webElement);
	}

}
