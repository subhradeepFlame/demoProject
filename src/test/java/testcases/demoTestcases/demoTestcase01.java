package testcases.demoTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import initiate.BaseClass;

public class demoTestcase01 extends BaseClass {

	@Test
	public void demo() {

		testStepsLog("this is a demo step");
		demopage.demo();
		testVerifyLog("This is demo verified");

//		testStepsLog("fail a testcase for resport showing");
//		driver.findElement(By.xpath("//tagname[text()='value']"));

		driver.get("https://www.google.com/");
		waitForPageLoaded();
		WebElement webElement = driver.findElement(By.xpath("//input[@title='Search']"));

		for (int i = 0; i < 100000000; i++) {
			webElement.sendKeys(Keys.TAB);
			System.out.println(i
					+ ". ElementNotVisibleException: This type of Selenium exception occurs when an existing element in DOM has a feature set as hidden.");
		}

	}

}
