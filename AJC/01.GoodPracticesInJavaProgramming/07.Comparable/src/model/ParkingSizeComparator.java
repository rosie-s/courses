package model;

import java.util.Comparator;

public class ParkingSizeComparator implements Comparator<Parking> {
    @Override
    public int compare(Parking o1, Parking o2) {
        if (o1.getVehicleList().size() > o2.getVehicleList().size())
            return 1;
        else if (o1.getVehicleList().size() < o2.getVehicleList().size())
            return -1;
        return 0;
    }
}
