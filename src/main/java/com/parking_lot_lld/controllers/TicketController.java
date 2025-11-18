package com.parking_lot_lld.controllers;

import com.parking_lot_lld.dtos.IssueTicketRequestDto;
import com.parking_lot_lld.dtos.IssueTicketResponseDto;
import com.parking_lot_lld.services.TicketService;

public class TicketController {

    private TicketService ticketService;

    //Dependency Injection - via constructor
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto issueTicketRequestDto){
        return null;
    }
}
