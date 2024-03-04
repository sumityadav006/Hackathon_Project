
# IDENTIFY NEW BIKES

This is a Selenium based Automation Project on a website named https://zigwheels.com

## Tech Stack

- Java(Maven Project)
- Eclipse (4.30.0)

### It is implemented by integrating Framework: ###

- ApachePOI (5.2.5)
- TestNG and (7.9.0)
- Cucumber (7.15.0)

### along with: ###

- Jenkins (2.426.3)
- ExtentReport (1.14.0)
- Page Object Model Concept

## Folder Structure

```bash
- src/test/java

 Package 1: pageObjects
   Class 1: BasePage.java
   Class 2: UpcomingBikesObjects.java
   Class 3: UsedCarsObjects.java
   Class 3: ValidatingLoginDetailsObjects.java

 Package 2: StepDefinitions
   Class 1: Hooks.java
   Class 2: UpcomingBikes.java
   Class 3: UsedCarsPopularModels.java
   Class 4: ValidatingLoginDetails.java

  Package 3: Factory
    Class 1: BaseClass.java
    Class 2: CrossBrowsing.java

  Package 4: testCases
    Class 1: TC001_BikeDetails.java
    Class 2: TC002_UsedCars.java
    Class 3: TC003_loginValdation.java
 
    

   Package 5: utilities
     Class 1: ExcelUtility.java
     Class 2: ExtentReport.java
     

 - src/test/resources
	config.properties
        ExtentReport
	

 - Excel
	BikesInfo.xlsx
 - FeatureFiles
	bikes_details.feature

-	Screenshot

-	Test-output

-	Pom.xml

-	testNG.xml

```

## Test Cases

There are total 3 Test Cases

```bash
  Test Case 1 : Display "Upcoming" bikes details like bike name, price and expected launch date in India, for manufacturer 'Honda' & Bike price should be less than 4Lac.
```
```bash
  Test Case 2 : For Used cars in Chennai, extract all the popular models in a List and Display the popular Models.
```
```bash
  Test Case 3 : Try to 'Login' with google, give invalid account details & capture the error message.
```

## Running the Project

We can run it serially and through XML file.
In order to run the project please make sure you have TestNg and Cucumber plugin installed in your Eclipse.

```bash

### Use- ###
TestNG.xml:to run Project using chrome and edge with TestNG serially.
### Use-### 
TestRun.java:to run Project with Cucumber
### Use-### 
pom.xml:right click and run as Maven Test.

``` 

## Report and Screenshots

```bash
- Extent Report (//reports//Test-Report.html)
- Cucumber Report (//reports//myreport.html)
- TestNG Report(//test-output//index.html)
- Screenshots(//screenshots//.png)
- ExcelData(//Excel)
```


## A Result folder is present where I placed all the results of Last run.


## Author

- Sumit Yadav(2303954)