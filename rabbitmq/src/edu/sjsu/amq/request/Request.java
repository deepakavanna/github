package edu.sjsu.amq.request;

public class Request {
	MemoryCapacityEnum memoryCapacity;
	Double memorySize;
	RAMCapacityEnum ramCapacity;
	Double ramSize;
	DurationEnum durationMeasure;
	Double durationSize;
	PlatformEnum platform;
	int quantiy;
	ResourceTypeEnum resourceType;
	
	public MemoryCapacityEnum getMemoryCapacity() {
		return memoryCapacity;
	}
	public void setMemoryCapacity(MemoryCapacityEnum memoryCapacity) {
		this.memoryCapacity = memoryCapacity;
	}
	public Double getMemorySize() {
		return memorySize;
	}
	public void setMemorySize(Double memorySize) {
		this.memorySize = memorySize;
	}
	public RAMCapacityEnum getRamCapacity() {
		return ramCapacity;
	}
	public void setRamCapacity(RAMCapacityEnum ramCapacity) {
		this.ramCapacity = ramCapacity;
	}
	public Double getRamSize() {
		return ramSize;
	}
	public void setRamSize(Double ramSize) {
		this.ramSize = ramSize;
	}
	public DurationEnum getDurationMeasure() {
		return durationMeasure;
	}
	public void setDurationMeasure(DurationEnum durationMeasure) {
		this.durationMeasure = durationMeasure;
	}
	public Double getDurationSize() {
		return durationSize;
	}
	public void setDurationSize(Double durationSize) {
		this.durationSize = durationSize;
	}
	public PlatformEnum getPlatform() {
		return platform;
	}
	public void setPlatform(PlatformEnum platform) {
		this.platform = platform;
	}
	public int getQuantiy() {
		return quantiy;
	}
	public void setQuantiy(int quantiy) {
		this.quantiy = quantiy;
	}
	public ResourceTypeEnum getResourceType() {
		return resourceType;
	}
	public void setResourceType(ResourceTypeEnum resourceType) {
		this.resourceType = resourceType;
	}
	
	
	

}
