# Train-Reservation-System-
A console-based Train Reservation System developed using Core Java and Object-Oriented Programming (OOP). It allows users to view and search trains, book tickets, generate PNR numbers, check booking status, cancel reservations, and manage seat availability. Built using Java Collections Framework with sample data.


# Train Reservation System

A console-based Train Reservation System developed using Core Java and Object-Oriented Programming (OOP).

## Features

- View all available trains
- Search trains by source and destination
- Book tickets for multiple passengers
- Generate a PNR number
- Check reservation status
- Cancel tickets
- Track available seats
- Calculate total fare

## Technologies Used

- Java
- Object-Oriented Programming
- ArrayList and HashMap
- Java Collections Framework

## Project Structure

TrainReservationSystem/
├── src/
│   ├── Train.java
│   ├── Passenger.java
│   ├── Booking.java
│   ├── TrainService.java
│   └── Main.java
├── README.md
└── .gitignore

## Requirements

- JDK 8 or later
- Terminal or command prompt
- Any Java-compatible IDE (optional)

## How to Run

Open a terminal in the project root folder.

Compile the Java files:

    javac -d out src/*.java

Run the application:

    java -cp out Main

On Windows, these commands work in Command Prompt
and PowerShell.

## Application Menu

1. View All Trains
2. Search Trains
3. Book Ticket
4. Check PNR Status
5. Cancel Ticket
6. Exit

## Important Note

This is an educational demonstration project.
It uses sample train data and stores reservations
in memory. Data resets when the application exits.

It is not connected to Indian Railways or a live
ticket reservation service.

## Future Improvements

- MySQL database integration using JDBC
- Login and registration
- Travel date and class selection
- Persistent booking history
- Graphical user interface

