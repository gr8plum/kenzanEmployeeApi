This project an Employee API Code Sample for Kenzan


### `Setup and Backgrounnd`

Task was to build an API which could perform the following functions:

- Get employees by an ID
- Create new employees
- Update existing employees
- Delete employees
- Get all employees

I chose to develop this API using Spring Boot/JPA and initially set the database up in MySQL.  

To help ease the testing of the solution, I migrated it to H2 as in in-mem database to make it easy to view.

The easiest way to launch the service is to clone this repository, open it in an IDE (I used Intellij), and execute the EmployeeApplication.java file.

When the application starts, it will seed the H2 database with 3 employees.

Opening a browser and navigating to the following urls will allow you to view the data however, I would recommend opening POSTMAN or a similar tool to navigate REST based APIs

**GET:     /employees**      - retrieves a list of employees that have have a status set to true (1)

**GET:     /employees/{id}** - retrieves a single employee based on the provided ID and assuming their status is true

**POST:    /employees**      - Adds an employee and marks their status to valid.  A post body example is as follows:

`{
   "firstName": "Grendle",
   "middleName": "Gibberish",
   "lastName": "BigonzeFrish",
   "dateOfBirth": "2000-11-23",
   "dateOfEmployment": "2019-10-03"
}`

**PUT:    /employees/{id}**      - Updates an employee and marks their status to valid.  A post body example is as follows:

`{
   "id": "4"
   "firstName": "Grendle",
   "middleName": "Gibberish",
   "lastName": "BigonzeFrish",
   "dateOfBirth": "2000-11-23",
   "dateOfEmployment": "2019-10-03"
}`

*Please note that an id field is optional as it is not required for the update, only the path parameter is used*



**DELETE:  /employees/{id}** - updates an employees status to false removing them from view in subsequint GET calls

**GET:     /employees/validate**      - convenience  method to display all records in the database regardless of status

**AUTHENTICATION HEADER REQUIRED**
All method calls will require the use of an authentication header (Spring Security was leveraged)  for basic auth, the ID and
password are "admin" and "password" respectively



### `Additional Information`

I elected not to build an interface based on the information related in the task and the fact that I was also delivering the architect challenge.
However, an interface for this API could be put together fairly easily using a JS framework or perhaps Spring MVC and Thymeleaf.
<br/><br/>
I obviously would not suggest hardcoding secrets in the application as is the case in the application.properties file or SecurityConfig.java in favor of using environment variables or a secrets manager (i.e. CredHub or HashiCorp vault).