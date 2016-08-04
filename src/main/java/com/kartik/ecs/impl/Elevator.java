package main.java.com.kartik.ecs.impl;

import java.util.LinkedList;

import main.java.com.kartik.ecs.ElevatorFactory;
import main.java.com.kartik.ecs.enums.ElevatorDirection;
import main.java.com.kartik.ecs.enums.ElevatorStatus;

public class Elevator implements ElevatorFactory {

	private Integer currFloor;

	private LinkedList<Integer> destFloors;

	public Elevator(Integer currentFloor) {
		this.currFloor = currentFloor;
		this.destFloors = new LinkedList<Integer>();
	}

	/**
	 * Find what is the next destination for the elevator
	 * 
	 * @return
	 */
	public int nextDestionation() {
		return this.destFloors.peek();
	}

	public int currentFloor() {
		return this.currFloor;
	}

	/**
	 * Remove the destination from Destination Floors list
	 */
	public void popDestination() {
		this.destFloors.remove();
	}

	@Override
	public void addNewDestinatoin(Integer dest) {
		// Not the good way to sort list. if the list size grows bigger gets in
		// to performance problem
		// TODO: use different sorting approach
		if (destFloors.size() == 0) {
			destFloors.add(dest);
		} else if (destFloors.get(0) > dest) {
			destFloors.add(0, dest);
		} else if (destFloors.get(destFloors.size() - 1) < dest) {
			destFloors.add(destFloors.size(), dest);
		} else {
			int i = 0;
			while (destFloors.get(i) < dest) {
				i++;
			}
			destFloors.add(i, dest);
		}
	}

	@Override
	public void moveUp() {
		currFloor++;
	}

	@Override
	public void moveDown() {
		currFloor--;
	}

	@Override
	public ElevatorDirection direction() {
		if (destFloors.size() > 0) {
			if (currFloor < destFloors.peek()) {
				return ElevatorDirection.ELEVATOR_UP;
			} else if (currFloor > destFloors.peek()) {
				return ElevatorDirection.ELEVATOR_DOWN;
			}
		}
		return ElevatorDirection.ELEVATOR_HOLD;
	}

	@Override
	public ElevatorStatus status() {
		return (destFloors.size() > 0) ? ElevatorStatus.ELEVATOR_OCCUPIED : ElevatorStatus.ELEVATOR_EMPTY;
	}

}
