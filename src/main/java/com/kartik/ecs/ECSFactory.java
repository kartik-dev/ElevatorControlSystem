package main.java.com.kartik.ecs;

public interface ECSFactory {
	public void pickup(Integer pickupFloor, Integer direction);
	public void destination(Integer elevatorId, Integer destinationFloor);
	public void step();
}
