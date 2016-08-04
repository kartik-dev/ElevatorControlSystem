package test.main.java.com.kartik.ecs;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.java.com.kartik.ecs.enums.ElevatorDirection;
import main.java.com.kartik.ecs.impl.Elevator;

public class ElevatorTest {

	private Elevator elevator;

	@Before
	public void initializeElevator() {
		elevator = new Elevator(0);
	}

	@Test
	public void testNextDestionation() {
		// Move the elevator to 4th Floor
		elevator.moveUp();
		elevator.moveUp();
		elevator.moveUp();
		assertEquals(3, elevator.currentFloor());
	}

	@Test
	public void checkCurrentFloor() {
		elevator.moveUp();
		elevator.moveUp();
		elevator.moveUp();
		assertEquals(3, elevator.currentFloor());
	}

	@Test
	public void checkMoveDown() {
		elevator.moveDown();
		elevator.moveDown();
		assertEquals(-2, elevator.currentFloor());
	}

	@Test
	public void checkDirectionUp() {
		elevator.addNewDestinatoin(3);
		assertEquals(ElevatorDirection.ELEVATOR_UP, elevator.direction());
	}

	@Test
	public void checkDirectionDown() {
		elevator.addNewDestinatoin(-1);
		assertEquals(ElevatorDirection.ELEVATOR_DOWN, elevator.direction());
	}

	@Test
	public void checkDirectionHold() {
		assertEquals(ElevatorDirection.ELEVATOR_HOLD, elevator.direction());
	}
}
