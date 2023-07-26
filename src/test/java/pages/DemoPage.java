package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoPage extends CommonPage{

	public DemoPage(WebDriver dr) {
		super(dr);
	}
	
	@FindBy(xpath = "//span[text()='Demo']/..")
	public WebElement DemoXpath;
	
	public void demo() {
		System.out.println("demo test");
	}

}
