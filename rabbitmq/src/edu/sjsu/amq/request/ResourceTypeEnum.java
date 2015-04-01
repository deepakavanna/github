package edu.sjsu.amq.request;

public enum ResourceTypeEnum {
	
	Emulator("emulaotr"),
	Server("server");
	
	private String resourceType;
	
	
	private ResourceTypeEnum(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getResource() {
		return resourceType;
	}
}
