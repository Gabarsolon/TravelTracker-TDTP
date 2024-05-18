package traveltracker.steps.serenity;

import net.thucydides.core.annotations.Step;
import traveltracker.pages.BucketListPage;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class BucketListSteps {

    BucketListPage bucketListPage;

    @Step
    public void is_on_bucket_list_page(){
        assert bucketListPage.is_page_open();
    }

    @Step
    public void drag_first_location_from_public_list_to_bucket_list(){
        bucketListPage.drag_first_location_from_public_list_to_bucket_list();
    }

    @Step
    public void can_see_added_location_from_public_list(){
        assert bucketListPage.getLastLocationFromBucketListName().equals("Casa poporului");
    }

    @Step
    public void go_to_map(){
        bucketListPage.goToMap();
    }

    @Step
    public void clearBucketList(){
        bucketListPage.clearBucketList();
    }

}
