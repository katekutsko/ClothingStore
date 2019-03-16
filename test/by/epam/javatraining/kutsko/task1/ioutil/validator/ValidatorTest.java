package by.epam.javatraining.kutsko.task1.ioutil.validator;

import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {

	@Test
	public void validateValidDataTest() {
		boolean isValid = Validator.validateData(new String[]{"2", "10.19", "COTTON", "false", "PINK", "ANY", "CHUNKY"});
		Assert.assertTrue(isValid);
	}
	
	@Test
	public void validateInvalidValidDataTest() {
		boolean isValid = Validator.validateData(new String[]{"2", "10.19", "COTTfdsN", "", "PsdfK"});
		Assert.assertFalse(isValid);
	}
	
	@Test
	public void validateNullDataTest() {
		boolean isValid = Validator.validateData(null);
		Assert.assertFalse(isValid);
	}
	
	@Test
	public void validatePartlyNullDataTest() {
		boolean isValid = Validator.validateData(new String[]{null, "10.19", null, "PsdfK", null, null});
		Assert.assertFalse(isValid);
	}
}
