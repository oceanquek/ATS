package java.repository.plane;

import java.model.planes.Plane;
import java.util.ArrayList;

public interface PlaneRepository {
    public abstract ArrayList getPlanes();
    public Plane getPlane();
    public int insertPlane(Plane plane);
    public int updatePlane(int id, Plane plane);
    public int deletePlane(int id);
}
