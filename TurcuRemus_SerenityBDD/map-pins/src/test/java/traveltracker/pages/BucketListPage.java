package traveltracker.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class BucketListPage extends PageObject {
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[3]/div/div/div[1]/ul/li[1]")
    private WebElementFacade firstLocationFromPublicList;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[1]/div/div/div[2]")
    private WebElementFacade bucketListContainer;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[1]/div/div/div[2]/ul")
    private WebElementFacade bucketList;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[1]/div/div/div[2]/ul/li/strong")
    private WebElementFacade lastLocationInBucketListName;

    @FindBy(xpath = "//*[@id=\"root\"]/div/nav/ul/li[3]/a")
    private WebElementFacade mapHyperLink;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div[2]/button[2]")
    private WebElementFacade deleteButtonFromModalWindow;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[1]/div/div/div[1]/div/button")
    private WebElementFacade addDestinationToBucketListButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[1]/div/div/div[5]/label[1]/input")
    private WebElementFacade nameTextField;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[1]/div/div/div[5]/label[2]/input")
    private WebElementFacade countryTextField;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[1]/div/div/div[5]/label[3]/input")
    private WebElementFacade cityTextField;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[1]/div/div/div[5]/label[4]/input")
    private WebElementFacade descriptionTextField;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div[1]/div/div/div[5]/button[1]")
    private WebElementFacade submitDestinationButton;

    public boolean is_page_open() {
        return find(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[1]/div/div/div[1]/h2")).isPresent();
    }

    public void drag_first_location_from_public_list_to_bucket_list() {
        Actions actions = new Actions(getDriver());

        actions.dragAndDrop(firstLocationFromPublicList, bucketListContainer).perform();
    }

    public String getLastLocationFromBucketListName() {
        return lastLocationInBucketListName.getText();
    }

    public void goToMap() {
        mapHyperLink.click();
    }

    public void clearBucketList() {
        //check if the list is empty
        if(!bucketList.isPresent()){
            return;
        }

        bucketList
                .findElements(By.tagName("li"))
                .forEach(
                        element -> {
                            element
                                    .findElement(By.tagName("div"))
                                    .findElement(By.tagName("svg"))
                                    .click();
                            deleteButtonFromModalWindow.click();
                        }
                );

        getDriver().navigate().refresh();
    }

    public void clickAddDestinationToBucketListButton(){
        addDestinationToBucketListButton.click();
    }

    public void fillAddDestinationForm(
            String name,
            String country,
            String city,
            String description
    ){
        nameTextField.type(name);
        countryTextField.type(country);
        cityTextField.type(city);
        descriptionTextField.type(description);
    }

    public void clickSubmitDestination(){
        submitDestinationButton.click();
    }
}
