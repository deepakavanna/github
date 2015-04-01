package edu.sjsu.amq.request;

public enum PlatformEnum {
	
	Android("android"),
	IOS("ios"),
	Server("server");
	
	private String platform;
	
	private PlatformEnum(String platform) {
		this.platform = platform;
	}
	
	public String getPlatform() {
		return platform;
	}

}
