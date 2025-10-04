package com.manasvinir.AirlineOperationsPortal.controller;

import com.manasvinir.AirlineOperationsPortal.entity.User;
import com.manasvinir.AirlineOperationsPortal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")     //standard url for initial release
@RequiredArgsConstructor
public class UserController {
        @Autowired
        private UserRepository userRepository;

        @GetMapping("/users")
        public List<User> getAllUsers() {
            return userRepository.findAll();
        }
}
