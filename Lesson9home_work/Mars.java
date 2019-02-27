package Lesson9home_work;

public class Mars extends Planet {
	private Integer temperature = 200;
	
	private Long distanceToSun = 1000000000L;
	
	public Integer getTemperature() {
		return temperature;
	}
	
	public Long getDistanceToSun() {
		return distanceToSun;
	}
	
	public String [] getSatelliteNames() {
		return new String [] {"Phobos", "Deimos"};
	}

}
