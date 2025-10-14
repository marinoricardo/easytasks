package cm.mz.easytasks.api.controller;


import cm.mz.easytasks.api.dto.ApiResponse;
import cm.mz.easytasks.domain.model.Activity;
import cm.mz.easytasks.domain.model.Notification;
import cm.mz.easytasks.domain.service.ActivityService;
import cm.mz.easytasks.domain.service.NotificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cm.mz.easytasks.api.util.Response.buildResponse;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {
    private final ActivityService activityService;
    private final NotificationService notificationService;

    public ActivityController(ActivityService activityService, NotificationService notificationService) {
        this.activityService = activityService;
        this.notificationService = notificationService;
    }

    @GetMapping()
    public ResponseEntity<List<Activity> > getActivities() {
        List<Activity> activities = this.activityService.findAllIncidents();
        return ResponseEntity.ok(activities);
    }

    @GetMapping("/users")
    public ResponseEntity<ApiResponse<List<Activity>>> getUsers(
            @RequestParam String name,
            @RequestParam String status,
            Pageable pageable
    ) {
        Page<Activity> activities;
        if (!name.isEmpty() || !status.isEmpty()) {
            activities = this.activityService.findByStatusAndName(name.trim(), status, pageable);
        } else{
            activities = this.activityService.findAll(pageable);
        }
        return ResponseEntity.ok(buildResponse(activities));
    }


    @GetMapping("/dashboard/notifications")
    public ResponseEntity<List<Notification>> getDashboardNotifications() {
        List<Notification> notification = this.notificationService.findAll();
        return ResponseEntity.ok(notification);
    }

    @GetMapping("/dashboard/data")
    public ResponseEntity<Map<String, Object>> getDashboardDummy() {
        // Totais de usuários
        Map<String, Object> users = new HashMap<>();
        users.put("admin", 3);
        users.put("normal", 12);

        // Status das atividades
        Map<String, Object> status = new HashMap<>();
        status.put("curso", 5);
        status.put("continuo", 2);
        status.put("supervisor", 1);
        status.put("pendente", 3);
        status.put("concluido", 8);

        // Estatísticas por usuário
        List<Map<String, Object>> userStats = new ArrayList<>();

        Map<String, Object> u1 = new HashMap<>();
        u1.put("name", "Marino Ricardo");
        u1.put("curso", 2);
        u1.put("supervisor", 1);
        u1.put("continuo", 0);
        u1.put("pendente", 1);
        u1.put("concluido", 5);
        userStats.add(u1);

        Map<String, Object> u2 = new HashMap<>();
        u2.put("name", "Joana Silva");
        u2.put("curso", 1);
        u2.put("supervisor", 0);
        u2.put("continuo", 2);
        u2.put("pendente", 0);
        u2.put("concluido", 3);
        userStats.add(u2);

        Map<String, Object> u3 = new HashMap<>();
        u3.put("name", "Carlos M.");
        u3.put("curso", 0);
        u3.put("supervisor", 0);
        u3.put("continuo", 1);
        u3.put("pendente", 2);
        u3.put("concluido", 4);
        userStats.add(u3);

        // Lista de atividades pendentes
        List<Map<String, Object>> pendentes = new ArrayList<>();
        Map<String, Object> a1 = new HashMap<>();
        a1.put("actividade", "Verificação de sistema");
        a1.put("estado", "pendente");
        a1.put("user", "Marino Ricardo");
        a1.put("manager", "Joana Silva");
        a1.put("data_prevista", "2025-10-15");
        a1.put("data_final", null);
        pendentes.add(a1);

        // Lista de atividades concluídas
        List<Map<String, Object>> concluidos = new ArrayList<>();
        Map<String, Object> c1 = new HashMap<>();
        c1.put("actividade", "Relatório semanal");
        c1.put("estado", "concluido");
        c1.put("user", "Carlos M.");
        c1.put("manager", "Marino Ricardo");
        c1.put("data_prevista", "2025-10-05");
        c1.put("data_final", "2025-10-06");
        concluidos.add(c1);

        // Lista de atividades em curso
        List<Map<String, Object>> curso = new ArrayList<>();
        Map<String, Object> e1 = new HashMap<>();
        e1.put("actividade", "Revisão de processos");
        e1.put("estado", "em curso");
        e1.put("user", "Joana Silva");
        e1.put("manager", "Carlos M.");
        e1.put("data_prevista", "2025-10-20");
        e1.put("data_final", null);
        curso.add(e1);

        // Resposta final
        Map<String, Object> response = new HashMap<>();
        response.put("usersTotla", 15);
        response.put("users", users);
        response.put("actividadestotal", 19);
        response.put("totalIncident", 7);
        response.put("status", status);
        response.put("stats", userStats);
        response.put("pendentes", pendentes);
        response.put("concluidos", concluidos);
        response.put("curso", curso);

        return ResponseEntity.ok(response);
    }

}
