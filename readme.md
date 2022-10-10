## Albert Java Coding Challenge
The goal of this challenge is to give you an opportunity to show us what you know and how you would work in a real life project.

## General aspects
We expect you to fork this github repository that contains the instructions.
Please always commit and push over your fork and when you are done create a pull request to this repository to deliver the results.
In order to be practical, we ask you to make one commit per challenge part and use the comment to identify it. Ie: commit description "A" should have all the changes to answer the challenge part A.

Be sure to always include your code and also the written answers/explanations in the ANSWERS.md file within the same commit if they belongs to the same challenge part.

## The application technology
You should start with start.spring.io and add the necessary dependencies according to your need. [Use H2 DB]

## Challenge introduction
Imagine you are trying to implement basic appointment booking system where users create their own availability slots and other users try to book those slots.

The aim of this challange is to unify the data and expose it with a standar interface like a RESTful webservice.

For the sake of simplicity you can ignore user related aspects and create basic entities for whole system.

##### A - The entities
Create the entities according to your need.

Create a UML class model diagram to explain how you will represent the information in that file. Remember to create a normalized data structure, entities and relationships.

Please provide the diagram as an image and include it in this answer commit.
You can also use the ANSWERS.md file to explain in more detail if you want.

##### B - Manage The Data
Implement all the necessary classes using JPA entities and Spring repositories in order to persist the data.

##### C - Expose data with a RESTful API
Create the following RESTful API endpoints to:

* Create available slots
* Get available slots
* Book an appointment

All the endpoints must expose the results in JSON format.

##### D - Scheduled Task
Create a scheduled service that remind the appointment is going to happen in 15 min.

##### E - Improvements
Is there anything that you consider that can be improved in your solution? Please explain

### Deliverables
The client is going to code review the changes, so you must create a pull request.

## FAQ

#### Should I deliver clean code and apply design patterns and good practices?
Definitely yes! We will evaluate those aspects.
#### Do I need to add tests?
Tests are always important! In the case of this challenge they are not mandatory, but always test what you consider important.
#### Do I need to use some specific libraries?
No, build the application with the tools you prefer, there are no limits.
#### When should i deliver it?
The sooner the better