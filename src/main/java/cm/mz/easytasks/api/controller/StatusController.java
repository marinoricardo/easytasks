package cm.mz.easytasks.api.controller;

import cm.mz.easytasks.domain.model.Status;
import cm.mz.easytasks.domain.service.StatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping
    public ResponseEntity<List<Status>> findAll() {
        List<Status> statuses = statusService.findAll();
        return new ResponseEntity<>(statuses, HttpStatus.OK);
    }
}
