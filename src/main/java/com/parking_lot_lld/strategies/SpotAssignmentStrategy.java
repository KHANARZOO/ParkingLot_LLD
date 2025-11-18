package com.parking_lot_lld.strategies;

import com.parking_lot_lld.models.Gate;
import com.parking_lot_lld.models.ParkingSpot;
import com.parking_lot_lld.models.VehicleType;

public interface SpotAssignmentStrategy {

    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate);
}
