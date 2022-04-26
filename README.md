# APC mobile app automation Task
###  assignment project 

This project contains Three complete test cases

### Application: Reminder 
This application is to set different reminders e.g. birthdya, anaversary, custom. App will be installed via apk file present in resource folder. Following 3 tests are autmated:
* Test to verify app can be launched for older version mobile app with soft popup message to update app
* Test to verify if user can create new reminder 
* Test to verify if user can delete reminder 

# Explaination
### Tools used
* Appium
* Testng
* Language
  * Java: I have chosedn Java to write the tests for this assigment
* Dependency: 
  * In order to run this app we need to make sure appium server is up and running on the machine and AVD is setup. 
* Maven
  * This project is maven based so all dependencies will be downloaded from maven artifactory.
* Surefire plugin
  * plugin is used to run test via testng xml and take user input from command

#### Follow below steps to successfully run the project:

#### Preconditions: 
* Make sure Java and Maven is installed on your machine
* Make sure appium server and AVD are setup
```bash
git clone git@github.com:ahmedmemon93/mobileAutomation.git
```
* After project is cloned make sure you are on **master** branch to get complete code
* Its maven project so make sure all dependencies are downloaded properly

## Run project: 
Go to parent folder i.e. flink-weathershopper where pom file is there
* Run following command
```bash
mvn clean test
```
