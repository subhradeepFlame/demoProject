package testcases.demoTestcases;

import org.testng.annotations.Test;
import initiate.BaseClass;

public class demoTestcase01 extends BaseClass {

	@Test
	public void demo() {

		testStepsLog("this is a demo step");
		demopage.demo();
		testVerifyLog("This is demo verified");

	}

}
