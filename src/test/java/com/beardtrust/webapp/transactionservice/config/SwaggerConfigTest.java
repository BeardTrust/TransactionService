package com.beardtrust.webapp.transactionservice.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import springfox.documentation.spring.web.plugins.Docket;

class SwaggerConfigTest {
	@Test
	void testApi() {
		Docket actualApiResult = (new SwaggerConfig()).api();
		assertTrue(actualApiResult.isEnabled());
		assertEquals("default", actualApiResult.getGroupName());
	}
}

