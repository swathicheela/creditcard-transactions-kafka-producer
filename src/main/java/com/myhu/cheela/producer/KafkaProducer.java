/**
 * 
 */
package com.myhu.cheela.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author nithinyama
 *
 */
@Component
public class KafkaProducer {

	private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${kafka.topic}")
	private String topic;
	
	public void sendMessage(String key, String value) throws InterruptedException {
		//Thread.sleep(5000);
		kafkaTemplate.send(topic, key, value);
		logger.info("Message sent successfully with this key -> "+key);
	}
}
