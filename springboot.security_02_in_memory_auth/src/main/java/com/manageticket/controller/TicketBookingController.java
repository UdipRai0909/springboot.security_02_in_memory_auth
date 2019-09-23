package com.manageticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manageticket.entities.Ticket;
import com.manageticket.service.TicketBookingService;

@RestController
@RequestMapping(value="/api/tickets")
public class TicketBookingController {
	
	@Autowired
	private TicketBookingService ticketBookingService;
	
	@PostMapping(value="/ticket/create")
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return ticketBookingService.createTicket(ticket);
	}
	
	@GetMapping(value="/ticket/{ticketId}")
	public Ticket getTicketById(@PathVariable("ticketId") int ticketId) {
		return ticketBookingService.getTicketById(ticketId);
	}
	
	@GetMapping(value="/ticket/alltickets")
	public Iterable<Ticket> getAllBookedTickets() {
		return ticketBookingService.getAllBookedTickets();
	}
	
	@PutMapping(value="/ticket/{ticketId}")
	public Ticket updateTicket(@RequestBody Ticket ticket, @PathVariable("ticketId") int ticketId) {
		return ticketBookingService.updateTicket(ticketId, ticket);
	}
	
	@PutMapping(value="/ticket/{ticketId}/{newEmail:.+}")
	public Ticket updateTicketById(@PathVariable("ticketId") int ticketId, @PathVariable("newEmail") String newEmail) {
		return ticketBookingService.updateTicketById(ticketId, newEmail);
	}
	
	
	
	@DeleteMapping(value="/ticket/{ticketId}")
	public void deleteTicketById(@PathVariable("ticketId") int ticketId) {
		ticketBookingService.deleteTicketById(ticketId);
	}
}
