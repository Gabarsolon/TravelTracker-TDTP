package traveltracker.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import traveltracker.steps.serenity.BucketListSteps;
import traveltracker.steps.serenity.LoginSteps;
import traveltracker.steps.serenity.MapSteps;

@RunWith(SerenityRunner.class)
public class SeeLocationsPinsOnMapStory {
    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @Steps
    public LoginSteps loginSteps;

    @Steps
    public BucketListSteps bucketListSteps;

    @Steps
    public MapSteps mapSteps;

    public void login_with_valid_credentials() {
        loginSteps.opens_login_page();
        loginSteps.enters_username("Gabarsolonic");
        loginSteps.enters_password("Parola1234$");
        loginSteps.performs_login();
    }

    public void clear_bucket_list() {
        bucketListSteps.clearBucketList();
    }

    @Before
    public void before() {
        login_with_valid_credentials();
        clear_bucket_list();
    }

    @Test
    public void add_destination_with_valid_country_and_city_from_public_list__pin_should_be_displayed() throws InterruptedException {
        bucketListSteps.is_on_bucket_list_page();
        bucketListSteps.drag_first_location_from_public_list_to_bucket_list();
        bucketListSteps.can_see_added_location_from_public_list();
        bucketListSteps.go_to_map();

        mapSteps.isOnMapPage();
        mapSteps.canSeeMarkerFromPublicLocation();
    }

}
