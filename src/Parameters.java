import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parameters {
	public WebDriver driver;
	String baseUrl = "https://www.demoblaze.com/";
	SoftAssert softassert = new SoftAssert();
	String expectedTitle="Demo";
	
	@BeforeTest()
	public void pre_my_Test () {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);

	}
}
