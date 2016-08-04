package test.main.java.com.kartik.ecs;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.java.com.kartik.ecs.impl.Elevator;
import main.java.com.kartik.ecs.impl.ElevatorControlSystem;

public class ElevatorControlSystemTest {

	private ElevatorControlSystem elevatorControlSystem;
	private ArrayList<Elevator> elevators;

	@Before
	public void initialize() {
		elevatorControlSystem = new ElevatorControlSystem(16, 20);
	}

	@Test
	public void testSendingElevatorToDestination() {
		elevatorControlSystem.destination(0, 10);

		for (int id = 0; id < 10; id++) {
			elevatorControlSystem.step();
		}
		elevators = elevatorControlSystem.getElevators();
		assertEquals(10, elevators.get(0).currentFloor());
	}

	@Test
	public void testSendingElevatorToMultipleDestinations() {
		elevatorControlSystem.destination(0, 10);
		elevatorControlSystem.destination(0, 7);
		for (int idx = 0; idx < 7; idx++) {
			elevatorControlSystem.step();
		}
		elevators = elevatorControlSystem.getElevators();
		assertEquals(7, elevators.get(0).currentFloor());
		for (int idx = 0; idx < 10 - 7; idx++) {
			elevatorControlSystem.step();
		}
		elevators = elevatorControlSystem.getElevators();
		assertEquals(10, elevators.get(0).currentFloor());
	}

}
