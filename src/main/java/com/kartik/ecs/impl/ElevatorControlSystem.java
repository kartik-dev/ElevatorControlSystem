package main.java.com.kartik.ecs.impl;

import java.util.ArrayList;
import java.util.LinkedList;

import main.java.com.kartik.ecs.ECSFactory;
import main.java.com.kartik.ecs.enums.ElevatorDirection;

public class ElevatorControlSystem implements ECSFactory {

	public static final int MAX_ELEVATORS = 16;

	Integer numberOfElevators = 0;

	Integer numberOfFloors = 0;

	ArrayList<Elevator> elevators;

	LinkedList<Integer> pickupLocations;

	public ElevatorControlSystem(Integer numberOfElevator, Integer numberOfFloors) {
		this.numberOfElevators = (numberOfElevators > MAX_ELEVATORS) ? MAX_ELEVATORS : numberOfElevators;
		this.numberOfFloors = numberOfFloors;

		elevators = new ArrayList<Elevator>();
		for (int id = 0; id < MAX_ELEVATORS; id++) {
			elevators.add(new Elevator(1));
		}
		pickupLocations = new LinkedList<Integer>();
	}

	public ArrayList<Elevator> getElevators() {
		return elevators;
	}

	/**
	 * Receive pickup request from passenger outside elevator and add it to 
	 */
	public void pickup(Integer pickupFloor, Integer direction) {
		// Not the good way to sort list. if the list size grows bigger gets in to performance problem
		// TODO: use different sorting approach
		if (pickupLocations.size() == 0) {
			pickupLocations.add(pickupFloor);
		} else if (pickupLocations.get(0) > pickupFloor) {
			pickupLocations.add(0, pickupFloor);
		} else if (pickupLocations.get(pickupLocations.size() - 1) < pickupFloor) {
			pickupLocations.add(pickupLocations.size(), pickupFloor);
		} else {
			int i = 0;
			while (pickupLocations.get(i) < pickupFloor) {
				i++;
			}
			pickupLocations.add(i, pickupFloor);
		}
	}

	public void step() {
		for (Elevator currElevator : elevators) {
			switch (currElevator.status()) {
			case ELEVATOR_EMPTY:
				if (!pickupLocations.isEmpty())
					currElevator.addNewDestinatoin(pickupLocations.poll());
				break;
			case ELEVATOR_OCCUPIED:
				switch (currElevator.direction()) {
				case ELEVATOR_UP:
					currElevator.moveUp();
					break;
				case ELEVATOR_DOWN:
					currElevator.moveDown();
					break;
				case ELEVATOR_HOLD:
					// TODO: Check the elevator HOLD duration and alert
					currElevator.popDestination();
					break;
				default:
					break;
				}
				if (currElevator.direction() == ElevatorDirection.ELEVATOR_UP)
					break;
			}
		}

	}

	@Override
	public void destination(Integer elevatorId, Integer destinationFloor) {
		elevators.get(elevatorId).addNewDestinatoin(destinationFloor);
	}
}
