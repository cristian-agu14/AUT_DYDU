package uis;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class HomePage extends PageObject {

	public static final Target BUTTON_USER_HOMEPAGE = Target
			.the("Button that is in the homepage after successful login").located(By.id("userActionDropdown"));
}
