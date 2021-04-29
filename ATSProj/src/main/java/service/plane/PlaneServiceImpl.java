package java.service.plane;

import java.model.planes.Plane;
import java.repository.plane.PlaneRepository;
import java.repository.plane.PlaneRepositoryImpl;
import java.util.ArrayList;

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
}
