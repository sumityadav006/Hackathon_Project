package testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.pageObjects.UpcomingBikesObjects;
import com.pageObjects.UsedCarsObjects;

import factory.BaseClass;
import factory.CrossBrowsing;

public class TC002_UsedCars extends CrossBrowsing{
	
	 UsedCarsObjects used_cars_object;
	List<String> popular_models_details=new ArrayList<>();
	
	@Test(priority=0)
	public void user_navigates_to_zigwheels_page() {
		used_cars_object=new UsedCarsObjects(driver);
	}
	
	@Test(priority=1)
	public void user_move_cursor_to_used_cars(){
		
		used_cars_object.hoverUsedCars();
		
	}

	@Test(priority=2)
	public void user_click_to_chennai() {
		
		used_cars_object.clickLoocation();
	   
		
	}

	@Test(priority=3)
	public void user_should_able_to_view_uesd_cars_in_chennai() {
	    
		used_cars_object.validateUsedCarsPage();
		
	}

	@Test(priority=4)
	public void user_scroll_to_popular_models() {
	    
		used_cars_object.scrollToPopularModels();
		
	}

	@Test(priority=5)
	public void user_extract_all_the_popular_models() {
	    
		popular_models_details=used_cars_object.extractDetails();
		
	}

	@Test(priority=6)
	public void user_display_all_popular_models() throws IOException {
	   
		used_cars_object.displayPopularModels(popular_models_details);
		
	}

	@Test(priority=7)
	public void user_click_on_the_zigwheels_to_navigate_homepage() {
		
		used_cars_object.navigateToHomePage();


	}



}
