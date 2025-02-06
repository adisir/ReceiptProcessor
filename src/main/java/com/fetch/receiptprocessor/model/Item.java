package com.fetch.receiptprocessor.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {
    @NotBlank
    @Pattern(regexp = "^[\\w\\s\\-]+$")
    private String shortDescription;
    @NotBlank
    @Pattern(regexp="^\\d+\\.\\d{2}$")
    private String price;
}
