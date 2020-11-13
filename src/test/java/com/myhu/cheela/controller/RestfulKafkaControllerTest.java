package com.myhu.cheela.controller;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.myhu.cheela.pojo.Transaction;
import com.myhu.cheela.util.DateUtil;

public class RestfulKafkaControllerTest {

	RestfulKafkaController controller = new RestfulKafkaController();
	DateUtil dateutil=new DateUtil();
	
	@Test
	public void test_convertToJSON() throws IOException {
		String expectedJson = FileUtils.readFileToString(new File("src/test/resources/test.json"));
		
		Transaction txn = new Transaction();
		txn.setCustId("12241");
		txn.setFirstName("Swat");
		txn.setLastName("Cat");
		txn.setTxnId("bdb37f406ed660fe0452d5600b6b4df0");
		txn.setTxnTime("2019-04-17 22:28:12");
		txn.setMerchant("grocery_pos");
		txn.setLongi("45");
		txn.setCategory("1325597827");
		txn.setTxnAmnt("545");
		txn.setLat("221");
		String actualJson = controller.convertToJSON(txn);
		assertEquals(expectedJson, actualJson);
	}
	
	@Test
	public void test_parseTransactionsFromCSV() throws IOException {
		controller.csvFileToRead="src/test/resources/transaction_test.csv";
		List<Transaction> actualTransactions = controller.parseTransactionsFromCSV();
		
		Transaction expectedTransaction = new Transaction();
		expectedTransaction.setCustId("180094108369013");
		expectedTransaction.setFirstName("John");
		expectedTransaction.setLastName("Holland");
		expectedTransaction.setTxnId("80f5177be11f0bcd768e06a0b1b294c8");
		expectedTransaction.setTxnTime(DateUtil.getCurrentDateTime());
		expectedTransaction.setCategory("personal_care");
		expectedTransaction.setMerchant("Hills-Boyer");
		expectedTransaction.setTxnAmnt("64");
		expectedTransaction.setLongi("-119.937831");
		expectedTransaction.setLat("39.011566");

		assertEquals(expectedTransaction.getCustId(), actualTransactions.get(0).getCustId());
		assertEquals(expectedTransaction.getFirstName(), actualTransactions.get(0).getFirstName());
		assertEquals(expectedTransaction.getLastName(), actualTransactions.get(0).getLastName());
		assertEquals(expectedTransaction.getTxnId(), actualTransactions.get(0).getTxnId());
		assertEquals(expectedTransaction.getTxnTime(), actualTransactions.get(0).getTxnTime());
		assertEquals(expectedTransaction.getCategory(), actualTransactions.get(0).getCategory());
		assertEquals(expectedTransaction.getMerchant(), actualTransactions.get(0).getMerchant());
		assertEquals(expectedTransaction.getTxnAmnt(), actualTransactions.get(0).getTxnAmnt());
		assertEquals(expectedTransaction.getLongi(), actualTransactions.get(0).getLongi());
		assertEquals(expectedTransaction.getLat(), actualTransactions.get(0).getLat());

	}
}