package com.manageticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manageticket.dao.TicketBookingDao;
import com.manageticket.entities.Ticket;

@Service
public class TicketBookingService {

	@Autowired
	private TicketBookingDao ticketBookingDao;
	
	public Ticket createTicket(Ticket ticket) {
		return ticketBookingDao.save(ticket);
	}

	public Ticket getTicketById(int ticketId) {
		return ticketBookingDao.findById(ticketId).get();
	}

	public Iterable<Ticket> getAllBookedTickets() {
		return ticketBookingDao.findAll();
	}

	public Ticket updateTicketById(int ticketId, String newEmail) {
		Ticket ticketFromDb = ticketBookingDao.findById(ticketId).get();
		ticketFromDb.setEmail(newEmail);
		return ticketBookingDao.save(ticketFromDb);
	}
	public void deleteTicketById(int ticketId) {
		ticketBookingDao.deleteById(ticketId);
	}

	public Ticket updateTicket(int ticketId, Ticket ticket) {
		return ticketBookingDao.save(ticket);
	}

}
