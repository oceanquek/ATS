package com.app.ui;

import com.app.model.Plane;
import com.app.service.PlaneService;
import com.app.service.PlaneServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        PlaneService planeService = new PlaneServiceImpl();
        List<Plane> listOfPlanes = planeService.searchPlaneByMaker("Boeing");
    }
}
