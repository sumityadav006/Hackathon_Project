package com.stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.pageObjects.UsedCarsObjects;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsedCarsPopularModels {
	
	UsedCarsObjects used_cars_object=new UsedCarsObjects(BaseClass.getDriver());
	List<String> popular_models_details=new ArrayList<>();
	
	@When("User move cursor to Used cars")
	public void user_move_cursor_to_used_cars(){
		used_cars_object.hoverUsedCars();
		
	}

	@Then("User click to Chennai")
	public void user_click_to_chennai() {
		
		used_cars_object.clickLoocation();
	   
		
	}

	@When("User should able to view Uesd Cars in Chennai")
	public void user_should_able_to_view_uesd_cars_in_chennai() {
	    
		used_cars_object.validateUsedCarsPage();
		
	}

	@When("User scroll to Popular Models")
	public void user_scroll_to_popular_models() {
	    
		used_cars_object.scrollToPopularModels();
		
	}

	@When("User extract all the Popular Models")
	public void user_extract_all_the_popular_models() {
	    
		popular_models_details=used_cars_object.extractDetails();
		
	}

	@Then("User display all Popular Models")
	public void user_display_all_popular_models() throws IOException {
	   
		used_cars_object.displayPopularModels(popular_models_details);
		
	}

	@Then("User click on the Zigwheels to navigate homepage")
	public void user_click_on_the_zigwheels_to_navigate_homepage() {
		
		used_cars_object.navigateToHomePage();


	}





}
