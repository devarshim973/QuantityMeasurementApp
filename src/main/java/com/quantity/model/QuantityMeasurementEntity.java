package com.quantity.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(
    name = "quantity_measurement_entity",
    indexes = {
        @Index(name = "idx_operation",        columnList = "operation"),
        @Index(name = "idx_measurement_type", columnList = "this_measurement_type"),
        @Index(name = "idx_created_at",       columnList = "created_at")
    }
)

public class QuantityMeasurementEntity {

    public QuantityMeasurementEntity(Long id, double thisValue, String thisUnit, String thisMeasurementType,
			double thatValue, String thatUnit, String thatMeasurementType, String operation, String resultString,
			double resultValue, String resultUnit, String resultMeasurementType, String errorMessage, boolean isError,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		
		this.id = id;
		this.thisValue = thisValue;
		this.thisUnit = thisUnit;
		this.thisMeasurementType = thisMeasurementType;
		this.thatValue = thatValue;
		this.thatUnit = thatUnit;
		this.thatMeasurementType = thatMeasurementType;
		this.operation = operation;
		this.resultString = resultString;
		this.resultValue = resultValue;
		this.resultUnit = resultUnit;
		this.resultMeasurementType = resultMeasurementType;
		this.errorMessage = errorMessage;
		this.isError = isError;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public QuantityMeasurementEntity() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getThisValue() {
		return thisValue;
	}

	public void setThisValue(double thisValue) {
		this.thisValue = thisValue;
	}

	public String getThisUnit() {
		return thisUnit;
	}

	public void setThisUnit(String thisUnit) {
		this.thisUnit = thisUnit;
	}

	public String getThisMeasurementType() {
		return thisMeasurementType;
	}

	public void setThisMeasurementType(String thisMeasurementType) {
		this.thisMeasurementType = thisMeasurementType;
	}

	public double getThatValue() {
		return thatValue;
	}

	public void setThatValue(double thatValue) {
		this.thatValue = thatValue;
	}

	public String getThatUnit() {
		return thatUnit;
	}

	public void setThatUnit(String thatUnit) {
		this.thatUnit = thatUnit;
	}

	public String getThatMeasurementType() {
		return thatMeasurementType;
	}

	public void setThatMeasurementType(String thatMeasurementType) {
		this.thatMeasurementType = thatMeasurementType;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getResultString() {
		return resultString;
	}

	public void setResultString(String resultString) {
		this.resultString = resultString;
	}

	public double getResultValue() {
		return resultValue;
	}

	public void setResultValue(double resultValue) {
		this.resultValue = resultValue;
	}

	public String getResultUnit() {
		return resultUnit;
	}

	public void setResultUnit(String resultUnit) {
		this.resultUnit = resultUnit;
	}

	public String getResultMeasurementType() {
		return resultMeasurementType;
	}

	public void setResultMeasurementType(String resultMeasurementType) {
		this.resultMeasurementType = resultMeasurementType;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "this_value", nullable = false)
    private double thisValue;

    @Column(name = "this_unit", nullable = false)
    private String thisUnit;

    @Column(name = "this_measurement_type", nullable = false)
    private String thisMeasurementType;

    @Column(name = "that_value", nullable = false)
    private double thatValue;

    @Column(name = "that_unit", nullable = false)
    private String thatUnit;

    @Column(name = "that_measurement_type", nullable = false)
    private String thatMeasurementType;

    // e.g. "COMPARE", "CONVERT", "ADD", "SUBTRACT", "DIVIDE"
    @Column(name = "operation", nullable = false)
    private String operation;

    @Column(name = "result_string", nullable = true)
    private String resultString;

    @Column(name = "result_value", nullable = true)
    private double resultValue;

    @Column(name = "result_unit", nullable = true)
    private String resultUnit;

    @Column(name = "result_measurement_type", nullable = true)
    private String resultMeasurementType;

    @Column(name = "error_message", nullable = true)
    private String errorMessage;

    @Column(name = "is_error", nullable = false)
    private boolean isError;

    @Column(name = "created_at", nullable = true)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}