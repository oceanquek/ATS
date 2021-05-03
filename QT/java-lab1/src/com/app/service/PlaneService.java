package app.service;

import app.model.Plane;
import java.util.ArrayList;
import java.util.List;

public interface PlaneService {
    public Plane getPlane(int planeId);
    public ArrayList<Plane> getPlanes();
    public boolean insertPlanesIntoDB(Plane plane);
    public boolean deletePlanesFromDB(int planeID);
    public boolean updatePlanesFromDB(int id, Plane plane);
    public List<Plane> searchPlaneByRegNo(String regNo);
    public List<Plane> searchPlaneByMaker(String maker);
    public List<Plane> searchPlaneByModel(String model);
}
