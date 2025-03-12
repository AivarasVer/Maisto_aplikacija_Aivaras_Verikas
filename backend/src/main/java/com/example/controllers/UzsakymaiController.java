
package com.example.controllers;

import com.example.models.Uzsakymas;
import com.example.services.UzsakymasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/uzsakymai")
public class UzsakymaiController {

    @Autowired
    private UzsakymasService uzsakymasService;

    @GetMapping
    public List<Uzsakymas> getAll() {
        return uzsakymasService.getAll();
    }

    @PostMapping
    public Uzsakymas create(@RequestBody Uzsakymas uzsakymas) {
        return uzsakymasService.create(uzsakymas);
    }

    @PutMapping("/{id}")
    public Uzsakymas update(@PathVariable Long id, @RequestBody Uzsakymas uzsakymas) {
        return uzsakymasService.update(id, uzsakymas);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        uzsakymasService.delete(id);
    }
}
