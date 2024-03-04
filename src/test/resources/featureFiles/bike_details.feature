Feature: Identify New Bikes
  
  Scenario: Displaying details of Upcoming Bikes in India
    Given User navigates to zigwheels page
    When User move cursor to New Bikes
    Then User click the Upcoming Bike option
    When User should able to view Upcoming Bikes in India
    And User Scroll to Upcoming Bikes by Brand
    Then User click to Honda manufacturer
    When User Should able to view Honda Upcoming Bikes in India
    And User Scroll to View more Bikes
    Then User Display the Bike details where price less than four lakh
    And User Scroll back to Honda Upcoming Bikes in India
  
  Scenario: Displaying details of used cars in Chennai
    When User move cursor to Used cars
    Then User click to Chennai
    When User should able to view Uesd Cars in Chennai
    And User scroll to Popular Models
    And User extract all the Popular Models
    Then User display all Popular Models
    And User click on the Zigwheels to navigate homepage

  Scenario: Validating login details
    When User click on login/signup button
    Then User should able to view Login/Register to ZigWheels page
    When User click on google button
    Then User should switch to new sign in window
    When User fill invalid account details
    Then User should able to capture error masseage
