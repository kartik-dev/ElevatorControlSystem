# Elevator Control System

## System Design
The Elevator Control System has two classes `ElevatorControlSystem` and `Elevator`

### ElevatorControlSystem

The ElevatorControlSystem implements ECSFactory interface. It manages all of the Elevators and their states. It is also responsible for receiving pickup request (Pickup Floor and Direction) from passengers outside the elevator. 
Elevator Control is also responsible for time-stepping every elevators.

__ECSFactory__ - Interface to define the ElevatorControlSystem attributes and behaviours
```java
public interface ECSFactory {
	public void pickup(Integer pickupFloor, Integer direction);
	public void destination(Integer elevatorId, Integer destinationFloor);
	public void step();
}
```
### Elevator
The Elevator class is responsible for elevator's behaviours (i.e moveUp, moveDown) and maintain the state (current floor and destination floors list)

__ElevatorFactory__ - Interface to define the ElevatorControlSystem attributes and behaviours
```java
public interface ElevatorFactory {
	public void moveUp();
	public void moveDown();
	public void addNewDestinatoin(Integer destination);
	ElevatorDirection direction();
	ElevatorStatus status();
}
```
## Build instructions

Elevator Control System is implemented in Java using Eclipse IDE, therefore please checkout this project in eclipse and run the JUnit testcases for Elevator and ElevatorControlSystem classes

## Things to improve
- [ ] Implement Pickup direction with direction
- [ ] Implement exception handling
- [ ] Better way of sorting pickup and destination location lists
- [ ] Test case to test all the possible scheduling scenarios
