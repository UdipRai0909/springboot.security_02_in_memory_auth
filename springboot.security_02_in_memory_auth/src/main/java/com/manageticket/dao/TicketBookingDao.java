package com.manageticket.dao;

import org.springframework.data.repository.CrudRepository;

import com.manageticket.entities.Ticket;

public interface TicketBookingDao extends CrudRepository<Ticket, Integer>{

}
