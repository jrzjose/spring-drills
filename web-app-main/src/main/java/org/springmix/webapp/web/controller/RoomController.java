package org.springmix.webapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springmix.webapp.data.service.RoomService;

@Controller
@RequestMapping("rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public String GetRoomsPage(Model model) {
        model.addAttribute("rooms", this.roomService.getAllRooms());
        return "rooms";
    }
    
}
