package com.parking_lot_lld.controllers;

import com.parking_lot_lld.dtos.IssueTicketRequestDto;
import com.parking_lot_lld.dtos.IssueTicketResponseDto;
import com.parking_lot_lld.dtos.ResponseStatus;
import com.parking_lot_lld.exceptions.GateNotFoundException;
import com.parking_lot_lld.models.Ticket;
import com.parking_lot_lld.repositories.GateRepository;
import com.parking_lot_lld.repositories.ParkingLotRepository;
import com.parking_lot_lld.repositories.TicketRepository;
import com.parking_lot_lld.repositories.VehicleRepository;
import com.parking_lot_lld.services.TicketService;

public class TicketController {
    private TicketService ticketService;

    //Dependency Injection - via constructor
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto issueTicketRequestDto) throws GateNotFoundException {
        IssueTicketResponseDto issueTicketResponseDto = new IssueTicketResponseDto();
        Ticket ticket = null;
        try {
            ticket = ticketService.issueTicket(issueTicketRequestDto.getGateId(),
                    issueTicketRequestDto.getVehicleNumber(), issueTicketRequestDto.getOwnerName(), issueTicketRequestDto.getVehicleType());
            issueTicketResponseDto.setTicket(ticket);
            issueTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);

        } catch (GateNotFoundException e) {
            e.getMessage();
            issueTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return issueTicketResponseDto;
    }
}
