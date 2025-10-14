package cm.mz.easytasks.api.controller;

import cm.mz.easytasks.domain.model.Incident;
import cm.mz.easytasks.domain.service.IncidentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class IncidentController {
    private final IncidentService  incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @GetMapping("/incident")
    public ResponseEntity<List<Incident>> findAll(){
        List<Incident> incidents = this.incidentService.findAll();
        return ResponseEntity.ok().body(incidents);
    }
}
