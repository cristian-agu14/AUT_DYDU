package interactions;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

public class Switch implements Interaction {

	private WebDriver driver;
	private Target iframe;
	private boolean isBackFrame = false;

	public Switch(WebDriver driver, Target iframe) {

		this.driver = driver;
		this.iframe = iframe;
	}

	public Switch(WebDriver driver) {
		this.driver = driver;
	}

	// para cambiarle el foco al driver

	@Override
	public <T extends Actor> void performAs(T actor) {

		if (isBackFrame) {
			driver.switchTo().parentFrame();
		} else {
			driver.switchTo().frame(iframe.resolveFor(actor));
		}
	}

	public static Switch toFrame(WebDriver driver, Target iframe) {
		return new Switch(driver, iframe);
	}

	public static Switch toFrame(WebDriver driver) {
		return new Switch(driver);
	}

	public Switch backFrame() {
		this.isBackFrame = true;
		return this;
	}

}
