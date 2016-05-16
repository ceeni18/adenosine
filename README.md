# EaseMySleep
This project tracks the user's sleep, food, heart rate and activity. The users can see the co-relation between these details and their ambient temperature, light and humidity. The website also allows users to see recommendations and facts related to sleep.

### Prerequisities: 
  Fitbit device  
  register at www.fitbit.com  
  register application here - https://dev.fitbit.com/apps/new   
  TI sensor  

### Technologies stack:
  Twitter Bootstrap  
  Javascript  
  Jquery  
  Highcharts  
  Spring MVC  
  MongoDb  

### Installing:

Edit Constants.java file with
  1. Fitbit client Id
  2. Fitbit Application Secret
  3. Mongo db host and port
  
The SpringMongoConfig.java file reads the host and port from Constants.java and these details gets autowired in required files.

### Run using TOMCAT MAVEN PLUGIN
The Tomcat Maven Plugin provides goals to manipulate WAR projects within the Apache Tomcat servlet container Or to run your war project in an embeded Apache Tomcat.

mvn clean install tomcat7:run 

### Website Structure:
  Models : A model stores data that is retrieved according to commands from the controller and displayed in the view  
  Views: A view generates new output to the user based on changes in the model (JSP files)  
  Controller: consists of data points that handles user's request  
  Services: used by controllers to obtain and process data  
  Repositories: used to interact with the database  

### Services used:
  FitbitOAuthService: Used to get Fitbit access and refresh tokens 
  UserProfileServiceImpl : Used to get and save user profile details from Fitbit  
  TiSensorService : Used to get TI Sensor data(temperature, luminosity, humidity) from database  
  RecommendationServiceImpl : Used to generate and save recommendations based on user's data  
  FitbitDetailsServiceImpl: Used to get and save user's data from Fitbit    

### Deployment:


### Built With:
Maven 

### Authors:
  Neha Viswanathan  
  Sreenivaasan Gajapathy  
  Srinidhi Srinivasa Raghavan 
  Uday Sagar Shiramshetty  

### Acknowledgments:
  Fitbit docs  
  Texas Instruments  
  
### Links: 
https://github.com/ceeeni/sensortag  
https://github.com/udaysagar2177/tisensor-mongod  






