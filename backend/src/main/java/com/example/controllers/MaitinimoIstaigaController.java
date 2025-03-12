
package com.example.controllers;

import com.example.models.MaitinimoIstaiga;
import com.example.services.MaitinimoIstaigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maitinimo_istaigos")
public class MaitinimoIstaigaController {

    @Autowired
    private MaitinimoIstaigaService maitinimoIstaigaService;

    @GetMapping
    public List<MaitinimoIstaiga> getAll() {
        return maitinimoIstaigaService.getAll();
    }

    @PostMapping
    public MaitinimoIstaiga create(@RequestBody MaitinimoIstaiga maitinimoIstaiga) {
        return maitinimoIstaigaService.create(maitinimoIstaiga);
    }

    @PutMapping("/{id}")
    public MaitinimoIstaiga update(@PathVariable Long id, @RequestBody MaitinimoIstaiga maitinimoIstaiga) {
        return maitinimoIstaigaService.update(id, maitinimoIstaiga);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        maitinimoIstaigaService.delete(id);
    }
}
