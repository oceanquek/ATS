package service.plane;

import model.planes.Plane;
import java.util.ArrayList;

public interface PlaneService {
    public Plane getPlane(int planeId);
    public ArrayList<Plane> getPlanes();
    public boolean insertPlanesIntoDB(Plane plane);
    public boolean deletePlanesFromDB(int planeID);
    public boolean updatePlanesFromDB(int id, Plane plane);
}
