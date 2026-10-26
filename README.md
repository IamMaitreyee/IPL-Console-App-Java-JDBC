# IPL Console App – Java JDBC

## About the Project
The **IPL Console App** is a Java-based application that uses JDBC and MySQL to manage and analyze IPL player statistics. It allows users to view team-wise player details, search for players, sort statistics, and identify top-performing players.

## Features
- Display all IPL teams
- Display all players
- View players team-wise
- Display batsmen, bowlers, all-rounders, and wicket-keepers
- Find the top 5 batsmen based on runs
- Find the top 5 bowlers based on wickets
- Display the top 5 players based on catches
- Find the top 5 all-rounders
- Search players by name or ID
- Sort players by runs, wickets, and catches
- Display the top 3 players based on runs
- Connect to a MySQL database using JDBC

## Technologies Used
- **Programming Language:** Java
- **Database:** MySQL
- **Database Connectivity:** JDBC
- **Concepts:** OOP, Collections Framework, ArrayList, Set, Comparator, Sorting, and Searching
- **IDE:** Eclipse / IntelliJ IDEA

## Project Structure
```text
IPL-Console-App-Java-JDBC/
├── IplMainApp.java
├── MyDbCong.java
├── Player.java
├── PlayerOperations.java
├── PlayersDao.java
├── PlayerAllRounderComparator.java
├── PlayerBatsmanComaparator.java
├── PlayerBowlerComaparator.java
├── PlayerCatchesComparator.java
└── README.md
```

## Database Configuration
1. Install MySQL Server and create a database named `ipl_db`.
2. Create the `Player` table with the required player details.
3. Insert IPL player records into the table.
4. Add the MySQL Connector/J dependency to your Java project.
5. Update your database username and password in `MyDbCong.java`.

Example JDBC URL:

```java
String url = "jdbc:mysql://localhost:3306/ipl_db";
String username = "root";
String password = "your_password";
```

## How to Run
1. Clone or download this repository.
2. Open the project in your Java IDE.
3. Configure the MySQL database and JDBC driver.
4. Run the SQL script to create and populate the player table.
5. Run `IplMainApp.java`.
6. Select an option from the console menu to explore player statistics.

## Learning Outcomes
- Practiced JDBC connectivity with MySQL.
- Applied object-oriented programming concepts.
- Used Java Collections to store and process player data.
- Implemented custom comparators for sorting.
- Developed search, filtering, and statistical analysis features.

## Future Enhancements
- Add player and team CRUD operations.
- Add IPL season-wise statistics.
- Implement a graphical user interface.
- Add advanced player performance analytics.

## Author
**Maitreyee Patil**

---

*This project was developed for learning and practicing Java, JDBC, MySQL, and the Java Collections Framework.*
