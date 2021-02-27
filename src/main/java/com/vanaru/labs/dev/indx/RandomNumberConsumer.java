/**
 * @author Varun
 *
 */
package com.vanaru.labs.dev.indx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class RandomNumberConsumer {

	@Value("${message.processing.time}")
	private long processingTime;
	 
    @KafkaListener(topics = "random-number")
    public void consume(String message) throws UnknownHostException, InterruptedException {
        String hostName = InetAddress.getLocalHost().getHostName();
        System.out.println(String.format("%s consumed %s", hostName, message));
        Thread.sleep(processingTime);
    }

}
