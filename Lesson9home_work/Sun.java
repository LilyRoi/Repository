package Lesson9home_work;

public class Sun extends Star {

	private Integer temperature = 600;

	private Long weight = 333333333L;

	public Sun(Integer temperature, Long weight) {
		this(temperature);
		weight = weight;
	}

	public Sun(Integer temperature) {
		this.temperature = temperature;
	}

	private Sun() {

	}

	public Integer getTemperature() {
		return temperature;
	}

	public Long getWeight() {
		return weight;
	}

}
