package main.java.com.kartik.ecs;

import main.java.com.kartik.ecs.enums.ElevatorDirection;
import main.java.com.kartik.ecs.enums.ElevatorStatus;

public interface ElevatorFactory {
	public void moveUp();
	public void moveDown();
	public void addNewDestinatoin(Integer destination);
	ElevatorDirection direction();
	ElevatorStatus status();
}
