package Lesson9home_work;

public abstract class Planet extends StarSystem {	
	
	public abstract String [] getSatelliteNames();
	
	public Boolean isPlanet() {
		return true;
	}
	
	public Boolean isStar() {
		return false;
	}
	

}
