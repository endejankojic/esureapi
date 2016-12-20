package com.esure.esureapi.core.util;

import org.junit.Test;

public class ParameterCheckTest {

	@Test
	public void testMandatoryNotNull() {
		ParameterCheck.mandatory("paramName", new Object());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMandatoryNull() {
		ParameterCheck.mandatory("paramName", null);
	}

	@Test
	public void testMandatoryStringNotNull() {
		ParameterCheck.mandatoryString("paramaName", "stringValue");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMandatoryStringNull() {
		ParameterCheck.mandatoryString("paramaName", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMandatoryStringEmpty() {
		ParameterCheck.mandatoryString("paramName", "");
	}

}
