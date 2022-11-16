package com.example.demo.controller;

import com.example.demo.entity.dto.UserDTO;
import com.example.demo.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserDTO userDTO){
        ResponseEntity<?> response = new ResponseEntity<>(userService.save(userDTO), HttpStatus.OK);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id){
        ResponseEntity<?> response = new ResponseEntity<>(userService.findUser(id), HttpStatus.OK);
        return response;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        ResponseEntity<?> response = new ResponseEntity<>(userService.findAllUser(), HttpStatus.OK);
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO, @PathVariable("id") Long id){
        ResponseEntity<?> response = new ResponseEntity<>(userService.updateUser(userDTO, id), HttpStatus.OK);
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        ResponseEntity<?> response = new ResponseEntity<>(HttpStatus.OK);
        return response;
    }
}
