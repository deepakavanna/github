package edu.sjsu.amq.request;

public enum DurationEnum {
	
	Hours("hours"),
	Minutes("minutes");
	
	private String duration;
	
	private DurationEnum(String duration) {
		this.duration = duration;
	}
	
	public String getDuration() {
		return duration;
	}

}
