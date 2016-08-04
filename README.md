# elevator-control-system

## Design
The elevator control system has two classes `ElevatorControlSystem` and `Elevator`

### ElevatorControlSystem

The ElevatorControlSystem implements ECSFactory interface. It manages all of the Elevators and their states. It is also responsible for receiving pickup request (Pickup Floor and Direction) from Passengers outside the Elevator and direction from Passenger inside the Elevator. 
Elevator Control is also responsible for maintaining the state of every elevators (what floor they are and where they are going)

__ECSFactory__ - Interface to define the ElevatorControlSystem attributes and behaviours
```java
public interface ECSFactory {
	public void pickup(Integer pickupFloor, Integer direction);
	public void destination(Integer elevatorId, Integer destinationFloor);
	public void step();
}
```
### Elevator
The Elevator class is responsible for elevator's behaviours (i.e moveUp, moveDown)

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
### Things to improve
- [ ] Implement Pickup direction with direction
- [ ] Implement exception handling
- [ ] Better way of sorting pickup and destination location lists
- [ ] Test case to test all the possible scheduling scenarios
