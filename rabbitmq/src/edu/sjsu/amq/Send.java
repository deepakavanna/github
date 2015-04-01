package edu.sjsu.amq;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import edu.sjsu.amq.request.DurationEnum;
import edu.sjsu.amq.request.MemoryCapacityEnum;
import edu.sjsu.amq.request.PlatformEnum;
import edu.sjsu.amq.request.RAMCapacityEnum;
import edu.sjsu.amq.request.Request;
import edu.sjsu.amq.request.ResourceTypeEnum;

public class Send {
	
	private final static String QUEUE_NAME = "hello";
	
	public static void main(String[] args) throws java.io.IOException {
		
		ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();
	    
	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    
	    Request request = new Request();
	    request.setMemoryCapacity(MemoryCapacityEnum.MegaBytes);
	    request.setMemorySize(256D);
	    request.setDurationMeasure(DurationEnum.Hours);
	    request.setDurationSize(12D);
	    request.setPlatform(PlatformEnum.Android);
	    request.setQuantiy(12);
	    request.setRamCapacity(RAMCapacityEnum.KiloBytes);
	    request.setRamSize(256D);
	    request.setResourceType(ResourceTypeEnum.Emulator);
	    
	    Gson gson = new Gson();
	    String json = gson.toJson(request);  
	    channel.basicPublish("", QUEUE_NAME, null, json.getBytes());
	    System.out.println(" [x] Sent '" + json + "'");
	    
	    channel.close();
	    connection.close();

	}

}
