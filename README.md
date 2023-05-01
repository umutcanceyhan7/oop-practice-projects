# Object Oriented Programming Practice Projects
This repository consists of projects that aim to practice concepts and applications about Object Oriented Programming, Object Oriented System Design and Clean Code.

## 1 Multilingualism Project
### Used Concepts
1. Object Orientation Fundamentals,
2. Abstract Data Types
3. Inheritance, Polymorphism, Abstract Classes, Interfaces, Exceptions
4. Collections Generics
5. CSV file I/O
 
<details>
 <summary>Project Details</summary>

In Multilingualism, the users of the application choose a language to learn and start taking
quizzes about the language. The users are assumed to speak English and are expected to
choose one of the languages between Turkish, German, Italian, or Spanish.

---

In this application, there are a random number of units (between 60-100) of each language
such as Unit 1, Unit 2, etc. Each unit has a random number of quizzes (between 1-10).
Additionally, there are a random number of questions (between 8 and 15) in each quiz. Each
question can be one of four types of questions which are reading, listening, speaking, and
word-matching. Also, each question type has a different point: reading is 10 points, listening
is 7 points, speaking is 8 points, and word-matching is 5 points.

---

When a user takes a quiz, whether the user answers the questions correctly or not (for each
question separately) are randomly determined. At the end of the quiz, the user wins points for
each question he/she answers correctly. For example, a user takes a quiz of 8 questions. There
are 3 reading questions, 1 word-matching question, 2 listening questions, and 2 speaking
questions. The user answers 2 reading questions, 1 word-matching question, and 1 speaking
question correctly. The user gets 33 points in total for this quiz.

---

There may be String and/or Audio in different question types. The String objects will be created
randomly and do not have to have a meaning or be in any language at all. The Audio has a
randomly created length in seconds. Here are the rules for the different types of questions:
1. A reading question consists of two strings: one is assumed to be in English, and the
other is assumed to be its translated version of the chosen language.
2. A listening question consists of one string that is assumed to be in the chosen language
and audio.
3. A speaking question consists of two audios.
4. A word-matching question consists of a matching of strings where the key strings are
assumed to be in English, and the value strings are assumed to be their translated
versions of the chosen language.

---

In this application, there are Bronze, Silver, Gold, Sapphire, and Ruby leagues for each
language. When a user first starts to use the application, he/she is in the Bronze league. For a
user to advance to the Silver League, he/she must be in the top 15 of the points ranking. To be
advanced to the Golden League, a user is expected to be in the top 10 of the points rankings.
For a user to be advanced to the Sapphire League, it is expected that she/she must have at
least a streak of 7 days and is in the top 5 of the point rankings. To be advanced to the Ruby
league, a user must have at least a streak of 30 days and collect more than 5000 points or be
in at least Unit 10 of the selected language. Each user’s number of days in his/her streak is
determined randomly (between 0 and 365).

---

When the application is first run, the number of units of each language, the number of quizzes
in each unit, and the number and the types of questions in each quiz are determined randomly
and written in a CSV file called “languages.csv”. This file SHOULD be created once, and it
SHOULD NOT change each time the application is run.
In this application, the user data file should be read for usernames and passwords; the
language choice and the number of days in the streak of each user are determined randomly
to create user objects. Also, the number of quizzes that the user will take (during the current
run) is determined randomly (between 6- the total number of quizzes in the chosen language)
and is used to determine the user’s current Unit number.

---

In this application, you are expected to implement the necessary classes to load the data from
the given CSV file and create the desired queries.

---

After creating the user, quiz, and other necessary objects, please display the results of the
following queries:
1. The user who has the maximum points.
2. The user who is in the most advanced Unit in German (Hint: Unit 10 is more advanced
than Unit 9)
3. The language which has the maximum number of units
4. The language which has the maximum number of quizzes
5. The top three users in the Silver league for Italian

---

If the result of any of the queries is more than one, please display all results. Since almost all
data are randomly determined, the results of your projects will differ from each other, and this
is normal.

---

Please record the chosen language, the current Unit, the number of solved quizzes, and the
total points to “users.csv” after each run (they may be changed after each run). 
</details>

## 2 Smart Home Project
### Used Concepts
1. Mediator Design Pattern
2. UML Class Diagrams
3. UML Sequence Diagrams
4. UML State Diagrams 
<details>
 <summary>Project Details</summary>

In this application we will implement a simulation program for a smart home automation
system. The system should have a *mediator object* that manages communication between various
components of the smart home, such as *sensors*, *actuators*, and a *control panel*. The components
should not communicate with each other directly, but through the mediator object. The simulation
program should have the following requirements:

---

1. The system should have three types of sensors: temperature sensor, light sensor, and motion
sensor. Each sensor should periodically send a reading to the mediator object.
2. The system should have three types of actuators: thermostat, light bulb, and door lock. Each
actuator should receive commands from the mediator object and perform the corresponding
action.
3. The system should have at least one control panel that allows the user to set temperature,
turn on/off lights, and lock/unlock doors. The control panel should send commands to the
mediator object.
4. The mediator object should process the sensor readings and send commands to the
appropriate actuators based on the user's commands and the sensor readings. For example,
if the temperature reading is too low or high (20° C - 25° C), the mediator should send a
command to the thermostat to lower the temperature.
5. The simulation program should run for a specified duration, during which the sensors should
periodically send readings to the mediator and the control panel should send commands to
the mediator. The program should output the current state of the system (temperature, light
status, door status) to the console at regular intervals (each 1 second).


---

The goal is to implement the mediator design pattern to manage the communication between the
sensors, actuators, and control panel, and to simulate the smart home automation system. We will
write a Java program that implements the mediator, sensors, actuators, control panel, and
simulation logic, and outputs the system state to the console for 20 seconds. We will randomly
decide the values and the commands for the actuators (thermostat should be automatic).

---

Lastly, we will support the design by drawing UML Class diagrams, UML Sequence diagrams, and UML State diagrams. 
 
</details>
