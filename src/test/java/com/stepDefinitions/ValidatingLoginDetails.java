package com.stepDefinitions;

import java.io.IOException;

import com.pageObjects.ValidatingLoginDetailsObjects;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidatingLoginDetails {
	
	ValidatingLoginDetailsObjects validate_login_object= new ValidatingLoginDetailsObjects(BaseClass.getDriver());
	
	@When("User click on login\\/signup button")
	public void user_click_on_login_signup_button() {
	    
		validate_login_object.clickLoginButton();		
	}

	@Then("User should able to view Login\\/Register to ZigWheels page")
	public void user_should_able_to_view_login_register_to_zig_wheels_page() {
	    
		validate_login_object.verifyLoginRegisterPage();		
	}

	@When("User click on google button")
	public void user_click_on_google_button() throws InterruptedException{
		validate_login_object.clickGoogleButton();
		
	}

	@Then("User should switch to new sign in window")
	public void user_should_switch_to_new_sign_in_window(){

		validate_login_object.switchToNewWindow();
		
	}

	@When("User fill invalid account details")
	public void user_fill_invalid_account_details() throws InterruptedException, IOException {
		validate_login_object.fillDetails();
		
	}

	@Then("User should able to capture error masseage")
	public void user_should_able_to_capture_error_masseage() {


		validate_login_object.displayMsg();
	}


}
