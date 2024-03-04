package testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.pageObjects.UpcomingBikesObjects;

import factory.BaseClass;
import factory.CrossBrowsing;


public class TC001_BikesDetails extends CrossBrowsing{
	
	
	UpcomingBikesObjects upcoming_bikes_object;
	List<List<String>> bike_details=new ArrayList<>();
	
	@Test(priority=0)
	public void user_navigates_to_zigwheels_page() {
		upcoming_bikes_object=new UpcomingBikesObjects(driver);
	}
    
	@Test(priority=1)
	public void user_move_cursor_to_new_bikes() {
		upcoming_bikes_object.hoverNewBikes();
	}

	@Test(priority=2)
	public void user_click_the_upcoming_bike_option() {
		upcoming_bikes_object.clickUpcomingBikes();
	    
	}

	@Test(priority=3)
	public void user_should_able_to_view_upcoming_bikes_in_india() {
		upcoming_bikes_object.validateUpcomingBikesPage();
	    
	}

	@Test(priority=4)
	public void user_scroll_to_upcoming_bikes_by_brand() {
		upcoming_bikes_object.srollToManufacturerHonda();
	    
	}

	@Test(priority=5)
	public void user_click_to_honda_manufacturer() {
		upcoming_bikes_object.clickHondaBikes();
	    
	}

	@Test(priority=6)
	public void user_should_able_to_view_honda_upcoming_bikes_in_india() {
		upcoming_bikes_object.validateUpcomingHondaBikesPage();
	    
	}

	@Test(priority=7)
	public void user_scroll_to_view_more_bikes() {
		upcoming_bikes_object.srollToViewMoreBikes();
	}

	@Test(priority=8)
	public void user_display_the_bike_details_where_price_less_than_four_lakh() throws IOException {
		bike_details=upcoming_bikes_object.extractBikeDetails();
		upcoming_bikes_object.displayBikeDetails(bike_details);
	    
	}

	@Test(priority=9)
	public void user_scroll_back_to_honda_upcoming_bikes_in_india() {
		upcoming_bikes_object.srollBackToHeader();
	}


}
