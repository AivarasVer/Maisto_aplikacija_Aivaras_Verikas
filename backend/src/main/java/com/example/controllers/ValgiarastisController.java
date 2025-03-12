
package com.example.controllers;

import com.example.models.Valgiarastis;
import com.example.services.ValgiarastisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/valgiarasciai")
public class ValgiarastisController {

    @Autowired
    private ValgiarastisService valgiarastisService;

    @GetMapping
    public List<Valgiarastis> getAll() {
        return valgiarastisService.getAll();
    }

    @PostMapping
    public Valgiarastis create(@RequestBody Valgiarastis valgiarastis) {
        return valgiarastisService.create(valgiarastis);
    }

    @PutMapping("/{id}")
    public Valgiarastis update(@PathVariable Long id, @RequestBody Valgiarastis valgiarastis) {
        return valgiarastisService.update(id, valgiarastis);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        valgiarastisService.delete(id);
    }
}
