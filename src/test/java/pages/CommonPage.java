package pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import initiate.BaseClass;

public class CommonPage extends BaseClass {

	public CommonPage(WebDriver dr) {
		this.driver = dr;
		PageFactory.initElements(dr, this);
	}

	String incrementorExcelPath = System.getProperty("user.dir") + "/src/test/resources/demo.xls"; // excel path need to
																									// paste here for
																									// use excel value
																									// increment or
																									// decrement

	public void goToUrl(String url) {
		/* open a url */

		driver.get(url);
		waitForPageLoaded();
	}

	public String getIncrementedValue() throws EncryptedDocumentException, InvalidFormatException, IOException {
		/* get the excel incrementor value */

		String incrementorValue = excelhelper.getIntegerCellvalue(incrementorExcelPath, "AuthenticationSheet", 1, 0);
		excelhelper.setCellValue(incrementorExcelPath, "AuthenticationSheet", 1, 0,
				Integer.parseInt(incrementorValue) + 1);
		String upgradedincrementorValue = excelhelper.getIntegerCellvalue(incrementorExcelPath, "AuthenticationSheet",
				1, 0);
		return upgradedincrementorValue;
	}

	public String getCurrentMonth() {
		/* helps t get the current month name */
		SimpleDateFormat simpleformat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");
		simpleformat = new SimpleDateFormat("dd/MMMM/yyyy");
		simpleformat = new SimpleDateFormat("MMMM");
		String strMonth = simpleformat.format(new Date());
		return strMonth;
	}

	public String getCurrentYear() {
		/* helps t get the current year */
		SimpleDateFormat simpleformat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");
		simpleformat = new SimpleDateFormat("dd/MMMM/yyyy");
		String str[] = simpleformat.format(new Date()).split("/");
		return str[2];

	}

	public String getCurrentDate() {
		/* helps to get the current date */
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		Date date = new Date();
		return formatter.format(date);
	}

	public String getNextDate() {
		/* helps to get the current date */
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		Date date = new Date();
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		return formatter.format(calendar.getTime());
	}

	public String getCurrentDateMonthYear() {
		/* helps to get current date in dd mmm, yyyy format */
		SimpleDateFormat simpleformat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");
		simpleformat = new SimpleDateFormat("MMM");
		String strMonth = simpleformat.format(new Date());
		return getCurrentDate() + " " + strMonth + ", " + getCurrentYear();
	}

	public String getNextDateMonthYear() {
		/* helps to get tommorow date in dd mmm, yyyy format */
		SimpleDateFormat simpleformat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");
		simpleformat = new SimpleDateFormat("MMM");
		String strMonth = simpleformat.format(new Date());
		return getNextDate() + " " + strMonth + ", " + getCurrentYear();
	}

	public String getRandomString(int length) {
		/* returns a random string with given length value */
		String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890";
		String s = RandomStringUtils.random(length, alphabet);
		return s;
	}

}
