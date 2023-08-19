package ru.cordell.stores.controllers;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.cordell.stores.models.Request;
import ru.cordell.stores.models.Response;
import ru.cordell.stores.models.Root;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

@Controller
@RequestMapping("/api")
public class TestController {

    @GetMapping("")
    public String api(Model model) {
        return "api";
    }

    @GetMapping("/prices")
    public String prices(Model model) throws IOException {
        model.addAttribute("response", new Response());
        model.addAttribute("request", new Request());


        Response responseFromPython = new Response();
        byte[] encoded = Files.readAllBytes(Paths.get("my-file.txt"));
        responseFromPython.setText(new String(encoded, StandardCharsets.UTF_8));
        model.addAttribute("response", responseFromPython);

        System.out.println(responseFromPython.getText());
        return "prices";
    }

    @GetMapping("about")
    public String about(){
        return "about";
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

        return "api";
    }
}
