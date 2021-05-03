package app.ui;

import app.model.Plane;
import app.service.PlaneService;
import app.service.PlaneServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        PlaneService planeService = new PlaneServiceImpl();
        List<Plane> listOfPlanes = planeService.searchPlaneByMaker("Boeing");
    }
}
