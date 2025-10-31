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
import org.micro.webapp.data.service.StaffService;
import org.micro.webapp.web.model.Staff;

@RestController
@RequestMapping("/api/staff")
public class StaffApiController {
    private final StaffService staffService;

    public StaffApiController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public List<Staff> getAll() {
        return this.staffService.getAllStaff();
    }

    @GetMapping("/{id}")
    public Staff getStaff(@PathVariable(name = "id") UUID id) {
        return this.staffService.getStaffById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Staff addStaff(@RequestBody Staff staff) {
        return this.staffService.addStaff(staff);
    }

    @PutMapping("/{id}")
    public Staff updateStaff(@PathVariable(name = "id") UUID id, @RequestBody Staff staff) {
        return this.staffService.updateStaff(staff);
    }

    @DeleteMapping("/{id}")
    public void deleteStaff(@PathVariable(name = "id") UUID id) {
        this.staffService.deleteStaff(id);
    }
}
