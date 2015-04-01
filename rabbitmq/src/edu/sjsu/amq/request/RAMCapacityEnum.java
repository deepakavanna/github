package edu.sjsu.amq.request;

public enum RAMCapacityEnum {
	
	KiloBytes("KB"),
	MegaBytes("MB"),
	GigaBytes("GB");
	
	private String capacity;
	
	private RAMCapacityEnum(String capacity) {
		this.capacity = capacity;
	}

	public String getRAMCapacity() {
		return capacity;
	}
}
