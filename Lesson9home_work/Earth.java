package Lesson9home_work;

public class Earth extends Planet {
	private Long peopleCount = 1000000L;
	private Integer temperature = 100;
	
	public Earth (Long peopleCount) {
		this.peopleCount = peopleCount;
		
	}
	
	public Earth (Long peopleCount, Integer temperature) {
		this.peopleCount = peopleCount;
		this.temperature = temperature;
		
	}

	public Long getPeopleCount() {
		return peopleCount;
	}

	public Integer getTemperature() {
		return temperature;
	}

	public String[] getSatelliteNames() {
		return new String[] { "Moon" };
	}

}
