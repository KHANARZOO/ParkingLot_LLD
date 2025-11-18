package com.parking_lot_lld.repositories;

import com.parking_lot_lld.models.Vehicle;

import java.util.Optional;

public class VehicleRepository {

    public Optional<Vehicle> findVehicleByVehicleNumber(String vehicleNumber) {
        return null;
    }
    //this save method can be used for update as well as insert
    public Vehicle saveVehicle(Vehicle vehicle){
        //input Vehicle object don't have id associated
        //output Vehicle object have id associated
        return null;
    }
}
