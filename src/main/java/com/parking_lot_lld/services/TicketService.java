package com.parking_lot_lld.services;

import com.parking_lot_lld.exceptions.GateNotFoundException;
import com.parking_lot_lld.factory.SpotAssignmentStrategyFactory;
import com.parking_lot_lld.models.*;
import com.parking_lot_lld.repositories.GateRepository;
import com.parking_lot_lld.repositories.ParkingLotRepository;
import com.parking_lot_lld.repositories.TicketRepository;
import com.parking_lot_lld.repositories.VehicleRepository;
import com.parking_lot_lld.strategies.SpotAssignmentStrategy;

import java.util.Optional;

public class   TicketService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public  TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }
    public Ticket issueTicket(Long gateId, String vehicleNumber, String vehicleOwnerName, VehicleType vehicleType) throws GateNotFoundException {

        Ticket ticket = new Ticket();
        //Get the gate object from gateId -> gates are stored in DB -> To fetch from DB will use repositories
        Optional<Gate> optionalGate = gateRepository.findGateById(gateId);
        if(optionalGate.isEmpty()){
            //gateId is not a valid -> throw exception
            throw new GateNotFoundException("Invalid gateId: " + gateId);
        }
        Gate gate = optionalGate.get();
        ticket.setGenerateAt(gate);

        Vehicle savedVehicle = null;
        //Get the vehicle object with the vehicleNumber
        Optional<Vehicle> optionalVehicle = vehicleRepository.findVehicleByVehicleNumber(vehicleNumber);
        if(optionalVehicle.isEmpty()){
            //If it is not present - create vehicle object and save it to vehicleRepository - DB
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle.setOwnerName(vehicleOwnerName);

            savedVehicle = vehicleRepository.saveVehicle(vehicle);
        }
        else savedVehicle = optionalVehicle.get();
        ticket.setVehicle(savedVehicle);

        ticket.setGeneratedBy(gate.getOperator());

        //Assign the spot
        //Based on getId we get ParkingLot object
        Optional<ParkingLot> parkingLot = parkingLotRepository.getParkingLotByGateId(gateId);
        //From parkingLot object we get SpotAssignmentStrategy
        SpotAssignmentStrategyType spotAssignmentStrategyType = parkingLot.get().getSpotAssignmentStrategyType();

        //Factory Design Pattern
        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentStrategyFactory.getSpotAssignmentStrategy(spotAssignmentStrategyType);

        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(vehicleType, gate);
        ticket.setParkingSpot(parkingSpot);

        ticket.setNumber("Ticket" + "_" + gateId + "_" + vehicleNumber);
        return ticketRepository.save(ticket);
    }
}
/*
        CARDINALITY
1 parkingLot  -->  M gates
1 parkingLot  <--  1 gate
---------------------------
 1: M
 -> Id of one side on M side
 -> parkingLot id in the Gate side
 */