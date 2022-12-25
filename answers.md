## Please type your answers or explanations below.

The project contains Swagger UI. You can visit Swagger UI and test endpoints by going
to http://localhost:8080/swagger-ui

#### A - The entities

I created User, Slot & Booking entities. `Slot` is for available slots of specified user. `Booking` is used to determine
is a slot booked.

[UML Class Diagram](uml-diagram.png) is created with IntelliJ Idea Ultimate.

#### B - Manage The Data

Generated repositories & services for Booking, Slot and User entities.

#### C - Expose data with a RESTful API

Added Swagger UI generation. UserController, SlotController and BookingController was added.
Returning exceptions if an entity is not exists.

#### D - Scheduled Task

Added a scheduler which runs every minute. The scheduler checks meetings which has 15 minutes left and prints a log in
console. (to be honest, not sure is this working, since didn't wait for 15 minutes)

#### E - Improvements
