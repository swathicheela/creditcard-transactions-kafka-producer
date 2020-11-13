package com.myhu.cheela.util;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class DateUtilTest {
	
	DateUtil dateUtil = new DateUtil();
	
	@Test
	public void test_getCurrentDateTime() {
		assertNotNull(DateUtil.getCurrentDateTime());
	}
	
}
