package com.todo.list.controller;

import com.todo.list.dao.entity.User;
import com.todo.list.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserControlller {

    private final UserService userService;
    @GetMapping("/{username}")
    public ResponseEntity<User> getByUsername(@PathVariable String username){
       User user=userService.getByUsername(username);
       return ResponseEntity.ok(user);
    }
    @PostMapping("/saveUser")
    public void saveUser(@RequestBody User user){
    userService.save(user);
    }
}
