package ru.cordell.stores.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.cordell.stores.models.Request;

import java.util.*;

@Controller
@RequestMapping("/api")
public class TestController {

    @GetMapping("")
    public String api(Model model) {
        return "api";
    }

    @GetMapping("/prices")
    public String prices(Model model) {
        model.addAttribute("request", new Request());

        return "prices";
    }

    @PostMapping("")
    public String getPrices(@ModelAttribute("request") Request request) {
        RestTemplate restTemplate = new RestTemplate();

        SortedMap<String, String> jsonToSend = new TreeMap<>();
        jsonToSend.put("Address", request.getAddress());
        jsonToSend.put("Radius", "50");

        List<Map<String, String>> test = new ArrayList<>();
        test.add(jsonToSend);

        String url = "http://localhost:5000/predict";
        String response = restTemplate.postForObject(url, test, String.class);

        System.out.println(response);
        return "api";
    }
}
