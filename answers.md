## Please type your answers or explanations below.

The project contains Swagger UI. You can visit Swagger UI and test endpoints by going
to http://localhost:8080/swagger-ui \
Notes:

* Java 17 is required.
* H2DB Console is active. You can access by: http://localhost:8080/h2-console

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

1) I think we could add auth implementation for better security and safety.
2) Swagger UI and OpenAPI support could be added (even it wasn't asked I added it).
3) We could also use MariaDB or PostgreSQL or even better any other NoSQL databases instead of H2.
4) Could be Dockerizing the app.
5) Could add native image support with GraalVM with lower footprint in the start-up. (but since GraalVM has to cut speed
   from runtime for cold boot, it may not be the best choice)
6) Project could be written in Kotlin for better type safety and preventing developer errors.
7) This project could be implemented serverless for better scaling and cost-efficient. (Google Cloud Functions, AWS
   Lambda, any other serverless platform)