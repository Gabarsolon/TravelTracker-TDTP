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
                            clickDeleteButtonFromModalWindow();
                        }
                );

        getDriver().navigate().refresh();
    }

    public void clickDeleteButtonFromModalWindow() {
        deleteButtonFromModalWindow.click();
    }
}
