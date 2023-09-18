package com.hafiz.blog.controllers;

import com.hafiz.blog.payloads.ApiResponse;
import com.hafiz.blog.payloads.UserDto;
import com.hafiz.blog.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    //POST -create user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createdUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    //PUT - update user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uid){
        UserDto updatedUser = this.userService.updateUser(userDto, uid);
        return ResponseEntity.ok(updatedUser);
    }

    //DELETE -delete user

    @DeleteMapping("/{userId}")
    public  ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
            this.userService.deleteUser(uid);
            return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted successfully", true), HttpStatus.OK);
    }

    //GET -user get
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }


    //GET -user get
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUsers(@PathVariable("userId") Integer uid){
        return ResponseEntity.ok(this.userService.getUserById(uid));
    }

}
