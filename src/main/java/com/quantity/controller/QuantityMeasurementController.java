package com.quantity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.quantity.dto.QuantityDTO;
import com.quantity.dto.QuantityInputDTO;
import com.quantity.model.QuantityMeasurementEntity;
import com.quantity.service.IQuantityMeasurementService;

@RestController
@RequestMapping("/api/v1/quantities")
public class QuantityMeasurementController {

    @Autowired
    private IQuantityMeasurementService service;

    @PostMapping("/compare")
    public boolean compare(@RequestBody QuantityInputDTO input) {
        return service.compare(
                input.getThisQuantityDTO(),
                input.getThatQuantityDTO()
        );
    }

    @PostMapping("/convert/{targetUnit}")
    public QuantityDTO convert(
            @RequestBody QuantityDTO input,
            @PathVariable String targetUnit) {
        return service.convert(input, targetUnit);
    }

    @PostMapping("/add")
    public QuantityDTO add(@RequestBody QuantityInputDTO input) {
        return service.add(
                input.getThisQuantityDTO(),
                input.getThatQuantityDTO()
        );
    }

    @PostMapping("/subtract")
    public QuantityDTO subtract(@RequestBody QuantityInputDTO input) {
        return service.subtract(
                input.getThisQuantityDTO(),
                input.getThatQuantityDTO()
        );
    }

    @PostMapping("/divide")
    public double divide(@RequestBody QuantityInputDTO input) {
        return service.divide(
                input.getThisQuantityDTO(),
                input.getThatQuantityDTO()
        );
    }

    @GetMapping
    public List<QuantityMeasurementEntity> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public QuantityMeasurementEntity getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return "Record deleted successfully";
    }

    @DeleteMapping
    public String deleteAll() {
        service.deleteAll();
        return "All records deleted successfully";
    }
}