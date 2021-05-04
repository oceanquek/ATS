package app.repository;

import app.model.Plane;
import java.util.ArrayList;
import java.util.List;

public interface PlaneRepository {
    public abstract ArrayList getPlanes();
    public Plane getPlane(int planeID);
    public int insertPlane(Plane plane);
    public int updatePlane(int id, Plane plane);
    public int deletePlane(int id);
    public List<Plane> searchPlaneByRegNo(String regNo);
    public List<Plane> searchPlaneByMaker(String maker);
    public List<Plane> searchPlaneByModel(String model);
}
