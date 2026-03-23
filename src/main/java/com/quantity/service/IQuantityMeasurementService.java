package com.quantity.service;

import java.util.List;

import com.quantity.dto.QuantityDTO;
import com.quantity.model.QuantityMeasurementEntity;

public interface IQuantityMeasurementService {

    boolean compare(QuantityDTO q1, QuantityDTO q2);

    QuantityDTO convert(QuantityDTO input, String targetUnit);

    QuantityDTO add(QuantityDTO q1, QuantityDTO q2);

    QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2);

    double divide(QuantityDTO q1, QuantityDTO q2);

    List<QuantityMeasurementEntity> getAll();

    QuantityMeasurementEntity getById(Long id);

    void deleteById(Long id);

    void deleteAll();
}