package ru.cordell.stores.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.cordell.stores.models.Root;
import ru.cordell.stores.models.Store;

import java.util.ArrayList;

@Controller
@RequestMapping("/answer")
public class RController {
    @PostMapping("/test")
    public ResponseEntity<HttpStatus> create(@RequestBody ArrayList<Root> answer) {
        System.out.println(answer.get(0).storage.size());

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
