package ru.cordell.stores.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cordell.stores.models.Root;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/answers")
public class RController {

    @PostMapping
    public ResponseEntity<HttpStatus> getResults(@RequestBody String answer) throws IOException {//@RequestBody ArrayList<Root> answer) throws IOException {
        Type listOfMyClassObject = new TypeToken<ArrayList<Root>>() {}.getType();

        Gson gson = new Gson();
        List<Root> outputList = gson.fromJson(answer, listOfMyClassObject);

        String text = "";
        for (var i : outputList) {
            text += i.name + ":" + "\t";
            for (var j : i.storage) {
                text += j.name + "-" + j.price;
            }
            text += "\n";
        }

        PrintWriter pwriter = new PrintWriter("my-file.txt");
        pwriter.print("");
        pwriter.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter("my-file.txt", true));
        writer.append(text);
        writer.close();
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
