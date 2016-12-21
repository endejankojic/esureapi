package com.esure.esureapi.core.util;

import java.util.Objects;

import com.google.common.base.Strings;

/**
 * Utility class for various checks.
 */
public class ParameterCheck {

	/**
	 * Checks that the parameter with the given name has content i.e. it is not null
	 *
	 * @param strParamName Name of parameter to check
	 * @param object Value of the parameter to check
	 */
	public static final void mandatory(final String strParamName, final Object object) {
		// check that the object is not null
		if (Objects.isNull(object)) {
			throw new IllegalArgumentException(strParamName + " is a mandatory parameter");
		}
	}

	/**
	 * Checks that the string parameter with the given name has content i.e. it is not null and not zero length
	 *
	 * @param strParamName Name of parameter to check
	 * @param strParamValue Value of the parameter to check
	 */
	public static final void mandatoryString(final String strParamName, final String strParamValue) {
		// check that the given string value has content
		if (Strings.isNullOrEmpty(strParamValue)) {
			throw new IllegalArgumentException(strParamName + " is a mandatory parameter");
		}
	}

}
