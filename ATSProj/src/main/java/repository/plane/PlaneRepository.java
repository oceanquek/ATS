package repository.plane;

import model.planes.Plane;
import java.util.ArrayList;

public interface PlaneRepository {
    public abstract ArrayList getPlanes();
    public Plane getPlane(int planeID);
    public int insertPlane(Plane plane);
    public int updatePlane(int id, Plane plane);
    public int deletePlane(int id);
}
