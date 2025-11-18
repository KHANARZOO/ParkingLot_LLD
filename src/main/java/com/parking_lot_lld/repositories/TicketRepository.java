package com.parking_lot_lld.repositories;

import com.parking_lot_lld.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {

    private Map<Long, Ticket> ticketMap = new HashMap<>();
    private Long previousTicketId = 0L;

    public Ticket save(Ticket ticket) {
        if(ticket.getId() == null){
            //new Ticket - save
            previousTicketId += 1;
            ticket.setId(previousTicketId);
            ticketMap.put(previousTicketId, ticket);

        }

        //Update the existing ticket
        return ticket;
    }
}
