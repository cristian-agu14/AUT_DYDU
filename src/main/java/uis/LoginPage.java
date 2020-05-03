package uis;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage extends PageObject {

	public static final Target TEXT_FIELD_USER = Target.the("Text field for enter the email address")
			.located(By.id("emailAddress"));

	public static final Target TEXT_FIELD_PASSWORD = Target.the("Text field for enter the user password")
			.located(By.id("password"));

	public static final Target BUTTON_CONNECT = Target.the("Button for login").located(By.id("submit_0"));

}
