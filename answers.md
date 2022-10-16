## Please type your answers or explanations below.
#### A - The entities
I think and design the entities, these are User, Slot and Booking entities.

I draw the diagram on https://moqups.com/

The image can be found with name UML.png

#### B - Manage The Data

The project created at https://start.spring.io/ 
Models and repositories created for User, Slot, Booking.

#### C - Expose data with a RESTful API

findAvailableSlots, createSlots and bookSlot API's implemented.

When calling findAvailableSlots API, we should give userId, who we want to book an appointment with as a request parameter.

When calling createSlots API, we should give some parameters as request body, in some alternative ways due to mandatory and optional parameters.
We should set "userId" as slot owner, "begin" as slot begin time in epoch seconds.
Optional parameters are "end" as last slot end time in epoch seconds between begin and end parameters, and "durationMinutes" slot duration in minutes, which is 30 minutes by default.

When calling bookSlot API, we should give slotId and booker userId as request parameters.

Further API information can be found at http://localhost:8090/v2/api-docs after running the server.

Requests tested with Postman manually.

#### D - Scheduled Task

In NotifyService class appointments notified.

#### E - Improvements
