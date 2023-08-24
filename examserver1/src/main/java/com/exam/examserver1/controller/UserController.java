package com.exam.examserver1.controller;

import com.exam.examserver1.helper.UserFoundException;
import com.exam.examserver1.model.Role;
import com.exam.examserver1.model.User;
import com.exam.examserver1.model.UserRole;
import com.exam.examserver1.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.HashSet;
import java.util.Set;
@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class UserController {

    @Autowired
private  UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @PostMapping("/")
    public  User createUser(@RequestBody User user) throws Exception {
        user.setProfile("default.png");
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

                Set<UserRole>roles=new HashSet<>();
        Role role= new Role();
        role.setRoleId(45L);
        role.setRoleName("normal");

        UserRole userRole=new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        roles.add(userRole);

        return  this.userService.createUser(user,roles);

    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        User user = userService.getUser(username);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //delete the user by id
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        this.userService.deleteUser(userId);
    }


    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
        return ResponseEntity.ok(ex.getMessage());
    }


 //   @ExceptionHandler(UserPrincipalNotFoundException.class)
  //  public ResponseEntity<?> exceptionHandler(UserNotFoundException ex)
}
