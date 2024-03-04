package com.stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.pageObjects.UpcomingBikesObjects;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpcomingBikesDetails {
	
	public static WebDriver driver=BaseClass.getDriver();
	
	UpcomingBikesObjects upcoming_bikes_object;
	List<List<String>> bike_details=new ArrayList<>();
	
	@Given("User navigates to zigwheels page")
	public void user_navigates_to_zigwheels_page() {
		upcoming_bikes_object=new UpcomingBikesObjects(BaseClass.getDriver());
	}

	@When("User move cursor to New Bikes")
	public void user_move_cursor_to_new_bikes() {
		upcoming_bikes_object.hoverNewBikes();
	}

	@Then("User click the Upcoming Bike option")
	public void user_click_the_upcoming_bike_option() {
		upcoming_bikes_object.clickUpcomingBikes();
	    
	}

	@When("User should able to view Upcoming Bikes in India")
	public void user_should_able_to_view_upcoming_bikes_in_india() {
		upcoming_bikes_object.validateUpcomingBikesPage();
	    
	}

	@When("User Scroll to Upcoming Bikes by Brand")
	public void user_scroll_to_upcoming_bikes_by_brand() {
		upcoming_bikes_object.srollToManufacturerHonda();
	    
	}

	@Then("User click to Honda manufacturer")
	public void user_click_to_honda_manufacturer() {
		upcoming_bikes_object.clickHondaBikes();
	    
	}

	@When("User Should able to view Honda Upcoming Bikes in India")
	public void user_should_able_to_view_honda_upcoming_bikes_in_india() {
		upcoming_bikes_object.validateUpcomingHondaBikesPage();
	    
	}

	@When("User Scroll to View more Bikes")
	public void user_scroll_to_view_more_bikes() {
		upcoming_bikes_object.srollToViewMoreBikes();
	}

	@Then("User Display the Bike details where price less than four lakh")
	public void user_display_the_bike_details_where_price_less_than_four_lakh() throws IOException {
		bike_details=upcoming_bikes_object.extractBikeDetails();
		upcoming_bikes_object.displayBikeDetails(bike_details);
	    
	}

	@Then("User Scroll back to Honda Upcoming Bikes in India")
	public void user_scroll_back_to_honda_upcoming_bikes_in_india() {
		upcoming_bikes_object.srollBackToHeader();
	}


}
