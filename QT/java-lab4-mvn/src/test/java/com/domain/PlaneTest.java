package com.domain;

import com.app.model.Plane;
import com.app.service.PlaneService;
import com.app.service.PlaneServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PlaneTest {

    @Test
    public void testCreatePlane() {
        Plane newPlane = new Plane(1,"Boeing","777X-10",450,"YVR-YYZ");
        assertEquals(1, newPlane.getId());
        assertEquals("Boeing",newPlane.getPlaneMaker());
        assertEquals("777X-10",newPlane.getPlaneModel());
        assertNotEquals(300,newPlane.getPlaneCapacity());
        assertNotEquals("YYZ-YVR",newPlane.getPlaneCapacity());
    }

    @Test
    public void testInsertPlane() {
        Plane newPlane = new Plane(2,"Airbus","A350",300,"9YV-JJZ");
        PlaneService planeService = new PlaneServiceImpl();
        boolean result = planeService.insertPlanesIntoDB(newPlane);
        assertEquals(result,true);
    }

    @Test
    public void getPlanes() {
        PlaneService planeService = new PlaneServiceImpl();
        List<Plane> listOfPlanes = planeService.getPlanes();
        assertEquals(listOfPlanes.size(),2);
    }

    @Test
    public void updatePlane() {
        PlaneService planeService = new PlaneServiceImpl();
        Plane newPlane = new Plane(2,"Airbus","A350",300,"9YV-JLZ");
        boolean result = planeService.updatePlanesFromDB(newPlane.getId(),newPlane);
        assertEquals(true,result);
        List<Plane> queryPlanes = planeService.searchPlaneByRegNo("9YV-JLZ");
        assertEquals(queryPlanes.size(),1);
    }

    @Test
    public void deletePlane() {
        PlaneService planeService = new PlaneServiceImpl();
        boolean result = planeService.deletePlanesFromDB(2);
        List<Plane> remainingPlanes = planeService.getPlanes();
        assertEquals(1,remainingPlanes.size());
    }
}
