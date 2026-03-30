package com.quantity.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;



public class QuantityInputDTO {


	   @NotNull(message = "thisQuantityDTO cannot be null")
	    @Valid
    private QuantityDTO quantity1;

	    @NotNull(message = "thatQuantityDTO cannot be null")
	    @Valid
	    private QuantityDTO quantity2;
    public QuantityInputDTO(QuantityDTO quantity1, QuantityDTO quantity2, String targetUnit) {
		
		this.quantity1 = quantity1;
		this.quantity2 = quantity2;
		this.targetUnit = targetUnit;
	}

	public QuantityDTO getQuantity1() {
		return quantity1;
	}

	public void setQuantity1(QuantityDTO quantity1) {
		this.quantity1 = quantity1;
	}

	public QuantityDTO getQuantity2() {
		return quantity2;
	}

	public void setQuantity2(QuantityDTO quantity2) {
		this.quantity2 = quantity2;
	}

	public String getTargetUnit() {
		return targetUnit;
	}

	public void setTargetUnit(String targetUnit) {
		this.targetUnit = targetUnit;
	}

	

    // Optional target unit for convert / add / subtract operations
    private String targetUnit;

}