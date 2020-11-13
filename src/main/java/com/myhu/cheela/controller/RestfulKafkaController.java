/**
 * 
 */
package com.myhu.cheela.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.myhu.cheela.pojo.Transaction;
import com.myhu.cheela.producer.KafkaProducer;
import com.myhu.cheela.util.DateUtil;
import com.opencsv.CSVReader;

/**
 * @author nithinyama
 *
 */
@RestController
@RequestMapping("/creditcard/v1")
public class RestfulKafkaController {

	@Autowired
	KafkaProducer producer;
	
	public String csvFileToRead = "/Users/nithinyama/Documents/workspace-sts/creditcard-transactions-kafka-producer/src/main/resources/transaction.csv";
	
	ObjectMapper mapper = new ObjectMapper();
	
	@PostMapping(value="/test")
	public void sendCreditCardData(@RequestParam("txn") String txnMsg) {
		
	}
	
	@PostMapping(value="/publish")
	public void sendCreditCardData_1() {
		try {
			List<Transaction> txns = parseTransactionsFromCSV();
			
			for(Transaction txn : txns) {
				txn.setTxnTime(DateUtil.getCurrentDateTime());
				String value = convertToJSON(txn);
				producer.sendMessage(txn.getTxnId(), value);
				//Thread.sleep(10000);
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected String convertToJSON(Transaction txn) throws JsonProcessingException {
		
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		return mapper.writeValueAsString(txn);	
	}
	
	public List<Transaction> parseTransactionsFromCSV() {
        CSVReader reader = null;
        List<Transaction> transactions = new ArrayList<>();
        try {
            reader = new CSVReader(new FileReader(csvFileToRead));
            String[] line;
            while ((line = reader.readNext()) != null) {
            		Transaction txn = new Transaction();
            		txn.setCustId(line[0]);
    		        txn.setFirstName(line[1]);
    		        txn.setLastName(line[2]);
    		        txn.setTxnId(line[3]);
    		        txn.setTxnTime(DateUtil.getCurrentDateTime());
    		        txn.setCategory(line[7]);
    		        txn.setMerchant(line[8]);
    		        txn.setTxnAmnt(line[9]);
    		        txn.setLat(line[10]);
    		        txn.setLongi(line[11]);
    		        
    		        transactions.add(txn);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return transactions;
	}
	
}
