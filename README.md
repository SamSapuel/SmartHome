# Omo-smarthome

Simple smarthome application

## Team members

- Richard Fritsch
- Dmitriy Shevchenko

## Processing description

### UML Diagrams

[UML Class diagram](class-diagram.png)

[UML Use case diagram](use-case-diagram.png)

[UML State machine diagram](state-machine-diagram.png)

### Verbal description

The first step in the simulation is a random generation of actions for all the people in the house. You are
randomly installed equipment in the house according to their current strategy, they move into the room,
in which it is located and will try to use it. Subsequently, the status and consumption are updated
all devices. You always have little chance of breaking down.

All entities, such as specific people, facilities or events, have one
an abstract class from which common properties inherit. These are located in the main
packages, their implementations are then in subpackages. Most of the code is then
brought together in the classes of the `api` package.

## Design patterns

- State machine, class `DeviceState` and its implementation
- Factory, classes `LivingFactory` and` DeviceFactory`
- Singleton, `House` Avenue
- Listener, class `EventService` and all classes implementing` EventListener` interface
- Bridge, eg `Event`
- Strategy, `Strategy` class and its implementation

## Functional requirements

- [x] F1 - Entities we work with are house, window (+ outdoor blinds), floor in the house, sensor, equipment (= appliance), person, car, bicycle, pet other than farm type, plus any other entities
  - contained in classes, which are found eg in packages `devices`,` house`, `living`,` sensors`.

- [x] F2. Individual devices in the house have an API for control. Devices have a state that can be changed using the API to control it. Actions from the API are applicable depending on the state of the device. Selected devices may also have content - the refrigerator has food, the CD player has a CD.
  - Implemented in the `Device` and` DeviceState` classes and their specific implementations

- [x] F3. Appliances have their consumption in active state, idle state, off state
  - is recorded using the `update ()` method
  - consumption status maps stored in `DeviceEnergyConsumption`

- [x] F4. Each device has an API for collecting data about that device. We collect data about devices such as electricity, gas, water consumption and functionality (decreases linearly with time)
  - stored in `DeviceReportService`

- [x] F5. Individuals and animals can perform activities that have some effect on the facility or another person.
  - implemented using classes in the `entityAction` package

- [x] F6. Individual devices and people appear in one room at any time (if they do not play sports) and randomly generate events (an event can be important information or an alert)
  - event generation is used only for devices, `events` package

- [x] F7. Events are taken over and handled by a suitable person (s) or facility (ies).
  - solved through the `EventService` class and` handle` methods in the `Event` class

- F8. Generating reports
  - [x] HouseConfigurationReport
  - [x] EventReport
  - [x] ActivityAndUsageReport
  - [x] ConsumptionReport
  - implemented in the `reports` package

- [] F9. When the equipment is broken, the occupants of the house must examine the documentation for the equipment - find the warranty card, go through the repair manual and carry out corrective action (eg self-repair, purchase of a new one, etc.). Manuals take up a lot of space and take a long time to find.
  - repairs are simplified

- [x] F10. The family is active and spends about their free time on a pro rata basis (50% use appliances in the house and 50% do sports when they use sports equipment bikes or skis). When there is no free equipment or sports equipment, the person is waiting.
  - implemented partly through strategies (lack of use of "means of transport" and waiting for equipment)

## Afterwords

### Richard Fritsch

I would like to brag about solving event handling using double dispatch.
I also like the use of abstract classes to share common properties.

### Dmitriy Shevchenko
For myself, I will praise the implementation of report generation and their addition to a file
I would also say that using abstract classes and interfaces is a pretty handy thing to implement in large projects
