package ru.netology.bffservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.bffservice.model.BffResponse;
import ru.netology.bffservice.service.BffService;

@RestController
@RequestMapping("/api/site-bff")
public class BffController {
    private final BffService bffService;

    public BffController(BffService bffService) {
        this.bffService = bffService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<BffResponse> getUserAndOrdersByUserId(@PathVariable int userId) {
        BffResponse resp = bffService.getByUserId(userId);
        if (resp.getUser() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    
//    public BffResponse getUserAndOrdersByUserId(@PathVariable int userId) {
//        return bffService.getByUserId(userId);
//    }
}
