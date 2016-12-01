package br.com.alltrade.functionaltesting.configuration;

import java.io.InputStream;
import java.util.Properties;

public class ConfigurationProperties {

	public static final String APP_BASE_URL = "app.base.url";

	public static final String TESTS_PASSWORD = "tests.password";

	public static final String TESTS_USERNAME = "tests.username";

	public static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";

	private static ConfigurationProperties instance = null;

	private Properties properties;

	private ConfigurationProperties() {
		readProperties();
	}

	public static ConfigurationProperties getConfigurations() {
		if (instance == null)
			instance = new ConfigurationProperties();
		return instance;
	}

	private void readProperties() {
		properties = new Properties();
		InputStream input = null;

		try {
			input = getClass().getClassLoader().getResourceAsStream("config.properties");
			properties.load(input);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private String getValue(String property) {
		return properties.getProperty(property);
	}

	public String getWebDriverLocation() {
		return getValue(WEBDRIVER_CHROME_DRIVER);
	}

	public String getTestsUser() {
		return getValue(TESTS_USERNAME);
	}

	public String getTestsPassword() {
		return getValue(TESTS_PASSWORD);
	}
	
	public String getBaseAppUrl(){
		return getValue(APP_BASE_URL);
	}

}
