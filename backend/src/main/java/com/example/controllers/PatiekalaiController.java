
package com.example.controllers;

import com.example.models.Patiekalas;
import com.example.services.PatiekalasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patiekalai")
public class PatiekalaiController {

    @Autowired
    private PatiekalasService patiekalasService;

    @GetMapping
    public List<Patiekalas> getAll() {
        return patiekalasService.getAll();
    }

    @PostMapping
    public Patiekalas create(@RequestBody Patiekalas patiekalas) {
        return patiekalasService.create(patiekalas);
    }

    @PutMapping("/{id}")
    public Patiekalas update(@PathVariable Long id, @RequestBody Patiekalas patiekalas) {
        return patiekalasService.update(id, patiekalas);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        patiekalasService.delete(id);
    }
}
