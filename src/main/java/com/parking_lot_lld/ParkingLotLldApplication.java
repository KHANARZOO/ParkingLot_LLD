package com.parking_lot_lld;

import com.parking_lot_lld.controllers.TicketController;
import com.parking_lot_lld.dtos.IssueTicketRequestDto;
import com.parking_lot_lld.dtos.IssueTicketResponseDto;
import com.parking_lot_lld.exceptions.GateNotFoundException;
import com.parking_lot_lld.models.Ticket;
import com.parking_lot_lld.models.VehicleType;
import com.parking_lot_lld.repositories.GateRepository;
import com.parking_lot_lld.repositories.ParkingLotRepository;
import com.parking_lot_lld.repositories.TicketRepository;
import com.parking_lot_lld.repositories.VehicleRepository;
import com.parking_lot_lld.services.TicketService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class ParkingLotLldApplication {

    public static void main(String[] args)  throws GateNotFoundException {
        //Create Ticket
        IssueTicketRequestDto issueTicketRequestDto = new IssueTicketRequestDto();
        issueTicketRequestDto.setGateId(123L);
        issueTicketRequestDto.setVehicleType(VehicleType.SEDAN);
        issueTicketRequestDto.setVehicleNumber("123");
        issueTicketRequestDto.setOwnerName("Arzoo");

             GateRepository gateRepository = new GateRepository();
             VehicleRepository vehicleRepository = new VehicleRepository();
             TicketRepository ticketRepository = new TicketRepository();
             ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
             TicketService ticketService = new TicketService(gateRepository, vehicleRepository,parkingLotRepository, ticketRepository);

             TicketController ticketController = new TicketController(ticketService);
             IssueTicketResponseDto issueTicketResponseDto = ticketController.issueTicket(issueTicketRequestDto);

            Ticket ticket = issueTicketResponseDto.getTicket();

    }
}
