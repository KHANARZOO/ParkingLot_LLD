package com.parking_lot_lld.models;

import java.util.List;

public class ParkingLot extends BaseModel {
    private List<ParkingFloor> parkingFloor;
    private ParkingLotStatus parkingLotStatus;
    private List<Gate> gates;
    private List<VehicleType> supportedVehicleTypes;
    private SpotAssignmentStrategyType spotAssignmentStrategyType;
    private FeesCalculationType feesCalculationType;

    public List<ParkingFloor> getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(List<ParkingFloor> parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(List<VehicleType> supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }

    public SpotAssignmentStrategyType getSpotAssignmentStrategyType() {
        return spotAssignmentStrategyType;
    }

    public void setSpotAssignmentStrategyType(SpotAssignmentStrategyType spotAssignmentStrategyType) {
        this.spotAssignmentStrategyType = spotAssignmentStrategyType;
    }

    public FeesCalculationType getFeesCalculationType() {
        return feesCalculationType;
    }

    public void setFeesCalculationType(FeesCalculationType feesCalculationType) {
        this.feesCalculationType = feesCalculationType;
    }
}
