import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class myTestCases extends Parameters {

//@Test()
//public void get_the_title() {
//	String actualTitle=driver.getTitle();
//	softassert.assertEquals(actualTitle, expectedTitle);
//	softassert.assertAll();
//	
//	
//	
//}
	@Test()
	public void check_image_slider() {
		List<WebElement> myImages = driver.findElements(By.className("img-fluid"));
		boolean checkImage1 = myImages.get(0).getAttribute("src") == myImages.get(1).getAttribute("src");
		boolean checkImage2 = myImages.get(1).getAttribute("src") == myImages.get(2).getAttribute("src");
		boolean checkImage3 = myImages.get(2).getAttribute("src") == myImages.get(0).getAttribute("src");
		softassert.assertEquals(checkImage1, false, "this is between image one and image two");
		softassert.assertEquals(checkImage2, false, "this is between image two and image three");
		softassert.assertEquals(checkImage3, false, "this is between image three and image one");
		softassert.assertAll();

	}

	@Test()
	public void validate_contact_form() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String emails[] = { "ahmad@yahoo", "nm24gmail", "f33.com", "xc24@gmail.com" };
		Random email_Index = new Random();
		int index = email_Index.nextInt(4);
		driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a")).click();
		driver.findElement(By.id("recipient-email")).sendKeys(emails[index]);// send random values from list depends on
																				// random index iteger
		String regexPattern = "^[A-Za-z0-9+_.-]+@(.+)+.+(.+)$";
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(emails[index]);
		System.out.println("********************");
		System.out.println(emails[index]+" is a valid email? " + matcher.matches());
		System.out.println("********************");
		boolean checkEmailProcess = matcher.matches();
		softassert.assertEquals(checkEmailProcess, true);
		softassert.assertAll();


		
		
		

	}

}
