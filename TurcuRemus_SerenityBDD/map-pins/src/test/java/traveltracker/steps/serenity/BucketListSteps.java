package traveltracker.steps.serenity;

import net.thucydides.core.annotations.Step;
import traveltracker.pages.BucketListPage;

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
    public void canSeeAddedDestination(String destinationName){
        assert bucketListPage.getLastLocationFromBucketListName().equals(destinationName);
    }

    @Step
    public void go_to_map(){
        bucketListPage.goToMap();
    }

    @Step
    public void clearBucketList(){
        bucketListPage.clearBucketList();
    }

    @Step
    public void clickAddDestinationToBucketListButton(){
        bucketListPage.clickAddDestinationToBucketListButton();
    }

    @Step
    public void fillAddDestinationFormFields(
            String name,
            String country,
            String city,
            String description
    ){
        bucketListPage.fillAddDestinationForm(name, country, city, description);
    }

    @Step
    public void clickSubmitDestinationButton(){
        bucketListPage.clickSubmitDestination();
    }
}
