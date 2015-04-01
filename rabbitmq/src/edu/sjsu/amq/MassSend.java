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

public class MassSend {

	/**
	 * @param args
	 */
	
	private final static String QUEUE_NAME = "hello";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Generating 100 Requests ...");
		
		Channel channel = null;
		Connection connection = null;
		
		try {

			ConnectionFactory factory = new ConnectionFactory();
		    factory.setHost("localhost");
		    connection = factory.newConnection();
		    channel = connection.createChannel();
		    
		    channel.queueDeclare(QUEUE_NAME, false, false, false, null);

			
			for (int i = 0; i < 100; i++) {
			    Request request = new Request();
			    request.setMemoryCapacity(Random.getRandomDouble() < 0.5d ? MemoryCapacityEnum.MegaBytes: MemoryCapacityEnum.GigaBytes);
			    request.setMemorySize(256D);
			    request.setDurationMeasure(Random.getRandomDouble() < 0.5d ? DurationEnum.Hours : DurationEnum.Minutes);
			    request.setDurationSize(12D);
			    request.setPlatform(Random.getRandomDouble() < 0.3d ? PlatformEnum.Android : Random.getRandomDouble() < 0.6d ? PlatformEnum.IOS : PlatformEnum.Server );
			    request.setQuantiy(12);
			    request.setRamCapacity(Random.getRandomDouble() < 0.5d ? RAMCapacityEnum.KiloBytes : RAMCapacityEnum.GigaBytes);
			    request.setRamSize(256D);
			    request.setResourceType(Random.getRandomDouble() < 0.5d ? ResourceTypeEnum.Emulator : ResourceTypeEnum.Server);

			    Gson gson = new Gson();
			    String json = gson.toJson(request);  
			    channel.basicPublish("", QUEUE_NAME, null, json.getBytes());
			    System.out.println(" [x] Sent '" + json + "'");

			}
			
			 channel.close();
			 connection.close();
	
		}
		catch (Exception e) {
			System.out.println("exception occured " + e);
			e.printStackTrace();
		}
	}

}
