# IPL-Console-App-Java-JDBC
A Java-based IPL Team Player Management System using JDBC and MySQL to manage and analyze player statistics. Features include team-wise player details, searching players by name or ID, sorting by runs, wickets, and catches, and displaying top-performing batsmen, bowlers, all-rounders, and wicket-keepers.

## Setup
1. Create the MySQL schema/table:
   ```sql
   source schema.sql;
   ```
2. Configure DB connection (optional environment variables, defaults shown):
   - `IPL_DB_URL` (`jdbc:mysql://localhost:3306/ipl`)
   - `IPL_DB_USER` (`root`)
   - `IPL_DB_PASSWORD` (`root`)

## Compile and Run
```bash
javac -d out src/com/ipl/console/*.java
java -cp out com.ipl.console.Main
```
