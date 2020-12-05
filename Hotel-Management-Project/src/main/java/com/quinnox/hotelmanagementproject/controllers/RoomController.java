package com.quinnox.hotelmanagementproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.hotelmanagementproject.dto.RoomDto;
import com.quinnox.hotelmanagementproject.entities.Room;
import com.quinnox.hotelmanagementproject.service.RoomService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RoomController {

	@Autowired
	RoomService service;

	@PostMapping("/addroom")
	public boolean addRoom(@RequestBody RoomDto room) {
		service.addRoom(room);
		return true;
	}

	@GetMapping("/getroom")
	public List<Room> getAllRooms() {
		return service.getAllRooms();
	}

	@PutMapping("/updateroom/{roomId}")
	public boolean updateRoom(@PathVariable int roomId,@RequestBody RoomDto room) {
		
		return service.updateRoom(roomId,room);
	}

	@DeleteMapping("/deleteroom/{roomId}")
	public String deleteRoom(@PathVariable int roomId) {
		service.deleteRoom(roomId);
		return "Room deleted succesfully";
	}

	@GetMapping("/getoneroom/{roomId}")
	public Room getOneRoom(@PathVariable int roomId) {
		return service.getOneRoom(roomId);

	}
	@GetMapping("/getVaccantRooms")
	
	public List<Room> getVaccantRooms(){
		return service.getVaccantRooms();	
	}

}
