package app.ui;

import app.model.Plane;
import app.service.PlaneService;
import app.service.PlaneServiceImpl;

public class App {

    public static void main(String[] args) {
        PlaneService planeService = new PlaneServiceImpl();
        planeService.insertPlanesIntoDB(new Plane(1,"Boeing","777X-10",450,"YYZ-AAD"));
    }
}
