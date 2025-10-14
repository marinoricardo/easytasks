package cm.mz.easytasks.api.controller;

import cm.mz.easytasks.domain.model.Incident;
import cm.mz.easytasks.domain.service.IncidentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/teste")
    public ResponseEntity<Map<String, String>> teste(){
        Map<String, String> map = new HashMap<>();
        map.put("nome", "Aninha");
        map.put("idade", "30");
        map.put("profissao", "Desenvolvedor");  
        return ResponseEntity.ok().body(map);
    }
}
