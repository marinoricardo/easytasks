package cm.mz.easytasks.api.controller;

import cm.mz.easytasks.domain.model.User;
import cm.mz.easytasks.domain.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
//
//    @GetMapping("/users")
//    public ResponseEntity<List<User>> getUsers() {
//        List<User> users = userService.findAll();
//        return ResponseEntity.ok(users);
//    }

    @GetMapping("")
    public Map<String, Object> getUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
        Page<User> userPage = userService.findAllWithPagination(pageable);

        return Map.of(
                "meta", Map.of(
                        "total", userPage.getTotalElements(),
                        "page", userPage.getNumber() + 1,
                        "per_page", userPage.getSize(),
                        "last_page", userPage.getTotalPages()
                ),
                "data", userPage.getContent()
        );
    }

    @DeleteMapping("")
    public ResponseEntity<Map<String, String>> deleteUsers(@RequestParam String userId) {
        User user = userService.findById(userId);
        this.userService.delete(user);
        return ResponseEntity.ok(new HashMap<>());
    }

}
