# Final Project 09.11.2020. - Basic Information on the Project

## Getting started

Hello, my name is Miljan Biocanin. This is my final projected created during IT Bootcamp Upgrade from November 2020.
The basic information on the tested API can be found at <https://github.com/davellanedam/vue-skeleton-mvp>

In the beginning of the course, I tested manually API located at <https://api-demo.daniel-avellaneda.com>.


For the Final pproject, using Postman, I created a Final Project 09.11.2020 Collection with 5 folders:

- auth tests
- city tests
- profile tests
- user tests
- bonus

Each of these folders contains requests testing specific aspect of the mentioned API.

For testing, I have used Chai Assertion Library.

My Postman project is located at: <https://documenter.getpostman.com/view/12695741/TVep8nth>

## Test scripts and variables used

Test script of each request contains the name and the tested parameters, where the goal of each test can be seen.
To make the connection between the requests, I have used environment variables (Final Project 09.11.2020 Environment).
More precisely, the environment variable that was set in one request, was used for body input or parametar in a new request. 

To change the profile details, I logged in as both a user and an administrator and used the user token and admin token.

Login credentials for admin users are:

email: `admin@admin.com`  
password: `12345`

I have set login credentials for a user using dynamic variables.

## Bonus Folder


Bonus folder contains slightly more complicated tests related to the response time, as well as the testing of the Filtered list in response.


## Additional Documentation

To find out more about the requests in this collection, feel free to check out the "documentation.yaml" file attached to the project. 
