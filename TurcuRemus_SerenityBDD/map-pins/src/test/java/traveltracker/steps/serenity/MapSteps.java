package traveltracker.steps.serenity;

import net.thucydides.core.annotations.Step;
import traveltracker.pages.MapPage;

public class MapSteps {
    private MapPage mapPage;

    @Step
    public void isOnMapPage(){
        assert mapPage.getTitleText().equals("My Google Map");
    }

    @Step
    public void canSeeMarkerAtCorrectLocation(Double latitude, Double longitude) {
        assert mapPage.isMarkerAtCorrectLocation(latitude, longitude);
    }

    @Step
    public void cantSeeAnyMarkers(){
        assert mapPage.mapHasNoMarkers();
    }
}
