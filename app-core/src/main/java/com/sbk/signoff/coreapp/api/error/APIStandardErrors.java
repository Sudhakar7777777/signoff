package com.sbk.signoff.coreapp.api.error;

import org.springframework.stereotype.Component;

@Component
public class APIStandardErrors {

	public APIStandardErrors() {
	}

	public static final APIStandardError AE_UNKNOWN = new APIStandardError(
			"A1001", ErrorType.APP, "Application error processing request.");

	public static final APIStandardError SE_UNKNOWN = new APIStandardError(
			"A2001", ErrorType.SYSTEM, "System error processing request.");

}
