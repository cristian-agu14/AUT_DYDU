package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.LoggerFactory;

public class WebDriverFactory {

	// @Managed
	private static WebDriver driver;

	public static WebDriverFactory web() {
		driver = getDriver();
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return new WebDriverFactory();

	}

	public static WebDriver getDriver() {
		String webdriverstr = System.getProperty("serenity.driver.name");
		if (webdriverstr == null) {
			webdriverstr = "chrome";
		}

		switch (webdriverstr) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			FirefoxOptions fireopts = new FirefoxOptions();
			Proxy proxy = new Proxy();
			proxy.setProxyType(ProxyType.MANUAL);

			fireopts.setProxy(proxy);
			fireopts.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
			return new FirefoxDriver();
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			Proxy proxychr = new Proxy();
			proxychr.setProxyType(ProxyType.MANUAL);
			
			ChromeOptions chropts = new ChromeOptions();
			chropts.setProxy(proxychr);
			chropts.setAcceptInsecureCerts(true);		
			//chropts.addArguments("--ignore-certificate-errors");
			return new ChromeDriver();
		case "edge":
			System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/MicrosoftWebDriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.edge();
			capabilities.setJavascriptEnabled(true);
			capabilities.setAcceptInsecureCerts(true);

			return new EdgeDriver();
		case "ie":
			System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");
			InternetExplorerOptions opts = new InternetExplorerOptions();

			Proxy proxyie = new Proxy();
			proxyie.setProxyType(ProxyType.MANUAL);
			opts.ignoreZoomSettings();
			opts.enablePersistentHovering();
			opts.ignoreZoomSettings();
			opts.introduceFlakinessByIgnoringSecurityDomains();
			opts.requireWindowFocus();
			opts.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			opts.setCapability("ignoreProctectedModeSettings", true);
			opts.setCapability("enabledNativeEvents", true);

			opts.setCapability("ignoreZoomSetting", true);
			opts.setCapability("ignoreProtectedModeSettings", true);
			opts.setCapability("requireWindowFocus", true);
			opts.setCapability("enableNativeEvents", true);
			opts.setCapability("enablePersistentHover", true);

			opts.setProxy(proxyie);

			return new InternetExplorerDriver(opts);
		case "phantomjs":
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability("takesScreenshot", true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "phantomjs.exe");
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,
					new String[] { "--web-security=false", "--ssl-protocol=any", "--ignore-ssl-errors=true",
							"--webdriver-loglevel=INFO", "--web-security=no", "--proxy=10.169.104.166:8080" });

			return new PhantomJSDriver(caps);

		default:
			throw new RuntimeException("Unsupported webdriver: " + webdriverstr);
		}
	}

	public WebDriver onPage(String url) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileReader("src/test/resources/urls/urls.properties"));
		url = properties.getProperty(url);
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	
    public String consultar_propertie(String parametro) {
        Properties prop = new Properties();
        InputStream is = null;
   
    try {
        is = new FileInputStream("src/test/resources/urls/urls.properties");
        prop.load(is);
        return prop.getProperty(parametro);
       
        } catch(IOException e) {
        	LoggerFactory.getLogger(this.getClass()).error(e.getMessage(), e);
        }
       
        return null;
    }
	
}
