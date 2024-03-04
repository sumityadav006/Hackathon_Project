package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pageObjects.UsedCarsObjects;
import com.pageObjects.ValidatingLoginDetailsObjects;

import factory.BaseClass;
import factory.CrossBrowsing;


public class TC003_loginValidation extends CrossBrowsing{
    ValidatingLoginDetailsObjects validate_login_object;

	@Test(priority=0)
	public void user_navigates_to_zigwheels_page() {
		validate_login_object=new ValidatingLoginDetailsObjects(driver);
	}
    @Test(priority=1)
	public void user_click_on_login_signup_button() {
	    
		validate_login_object.clickLoginButton();		
	}

    @Test(priority=2)
	public void user_should_able_to_view_login_register_to_zig_wheels_page() {
	    
		validate_login_object.verifyLoginRegisterPage();		
	}

    @Test(priority=3)
	public void user_click_on_google_button() throws InterruptedException{
		validate_login_object.clickGoogleButton();
		
	}

    @Test(priority=4)
	public void user_should_switch_to_new_sign_in_window(){

		validate_login_object.switchToNewWindow();
		
	}

    @Test(priority=5)
	public void user_fill_invalid_account_details() throws InterruptedException, IOException {
		validate_login_object.fillDetails();
		
	}

    @Test(priority=6)
	public void user_should_able_to_capture_error_masseage() {


		validate_login_object.displayMsg();
	}



}
