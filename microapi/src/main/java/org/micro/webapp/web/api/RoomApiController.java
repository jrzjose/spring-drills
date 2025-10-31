package org.micro.webapp.web.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.micro.webapp.data.service.RoomService;
import org.micro.webapp.web.model.Room;

@RestController
@RequestMapping("/api/rooms")
//@Tag(name = "Tour Rating", description = "The Rating for a Tour API")
public class RoomApiController {
    private final RoomService roomService;

    public RoomApiController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getAll() {
        return this.roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable(name = "id") UUID id) {
        
        return this.roomService.getRoomById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room addRoom(@RequestBody Room room) {
        return this.roomService.addRoom(room);
    }

    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable(name = "id") UUID id, @RequestBody Room room) {
        return this.roomService.updateRoom(room);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable(name = "id") UUID id) {
        this.roomService.deleteRoom(id);
    }
}
