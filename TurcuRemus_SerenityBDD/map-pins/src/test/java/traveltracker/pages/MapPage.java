package traveltracker.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;

public class MapPage extends PageObject {
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/h3")
    private WebElementFacade title;

    public String getTitleText() {
        return title.getText();
    }

    public boolean isMarkerAtCorrectLocation(Double expectedLatitude, Double expectedLongitude){
        Object latitude = ((JavascriptExecutor) getDriver()).executeScript("return window.markersRef.current[0].position.lat()");
        Object longitude = ((JavascriptExecutor) getDriver()).executeScript("return window.markersRef.current[0].position.lng()");

        //Check if they are the Bucharest coordinates
        return latitude.equals(expectedLatitude) && longitude.equals(expectedLongitude);
    }

    public boolean mapHasNoMarkers(){
        try{
            Object latitude = ((JavascriptExecutor) getDriver()).executeScript("return window.markersRef.current[0].position.lat()");
            Object longitude = ((JavascriptExecutor) getDriver()).executeScript("return window.markersRef.current[0].position.lng()");

            return false;
        }catch (Exception exception){
            return true;
        }
    }
}
