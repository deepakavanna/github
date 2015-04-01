/**
 * 
 */
package edu.sjsu.amq.request;

/**
 * @author davanna
 *
 */
public enum MemoryCapacityEnum {
	
	GigaBytes("GB"),
	MegaBytes("MB");
	
	private String capacity;
	
	private MemoryCapacityEnum(String str) {
		this.capacity = str;
	}
	
	public String getValue() {
		return capacity;
	}

}
