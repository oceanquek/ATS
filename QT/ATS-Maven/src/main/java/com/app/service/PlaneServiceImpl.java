package com.app.service;

import com.app.model.Plane;
import com.app.repository.PlaneRepository;
import com.app.repository.PlaneRepositoryImpl;
import java.util.ArrayList;
import java.util.List;

public class PlaneServiceImpl implements PlaneService {
    private PlaneRepository planeRepositoryImpl;

    public PlaneServiceImpl() {
        planeRepositoryImpl = new PlaneRepositoryImpl();
    }

    @Override
    public Plane getPlane(int planeIdD) {
        return planeRepositoryImpl.getPlane(planeIdD);
    }

    @Override
    public ArrayList<Plane> getPlanes() {
        return planeRepositoryImpl.getPlanes();
    }

    @Override
    public boolean insertPlanesIntoDB(Plane plane) {
        int valuesAdded = planeRepositoryImpl.insertPlane(plane);
        if (valuesAdded > 0) return true;
        else return false;
    }

    @Override
    public boolean deletePlanesFromDB(int planeID) {
        int valuesDeleted = planeRepositoryImpl.deletePlane(planeID);
        if (valuesDeleted > 0) return true;
        else return false;
    }

    @Override
    public boolean updatePlanesFromDB(int id,Plane plane) {
        int valuesUpdated = planeRepositoryImpl.updatePlane(id,plane);
        if (valuesUpdated > 0) return true;
        else return false;
    }

    @Override
    public List<Plane> searchPlaneByRegNo(String regNo) {
        return planeRepositoryImpl.searchPlaneByRegNo(regNo);
    }

    @Override
    public List<Plane> searchPlaneByMaker(String maker) {
        return planeRepositoryImpl.searchPlaneByMaker(maker);
    }

    @Override
    public List<Plane> searchPlaneByModel(String model) {
        return planeRepositoryImpl.searchPlaneByModel(model);
    }
}
