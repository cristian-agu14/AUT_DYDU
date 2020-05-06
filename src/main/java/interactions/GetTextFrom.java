package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import static uis.TestPage.TEXT_BOX_OF_ANSWER;
import static utils.RemembresTheActor.ANSWER_BOT_FROM_CHAT_BOT;

public class GetTextFrom implements Interaction {

	private String indiceXpaht;

	public GetTextFrom() {
		// It's empty intentionally
	}

	public GetTextFrom(String indiceXpaht) {
		this.indiceXpaht = indiceXpaht;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		String textReturn = TEXT_BOX_OF_ANSWER.of(indiceXpaht).resolveFor(actor).getText();
		actor.remember(ANSWER_BOT_FROM_CHAT_BOT, textReturn);
	}

	public static GetTextFrom chatBox(String indiceXpaht) {
		return new GetTextFrom(indiceXpaht);
	}

}
