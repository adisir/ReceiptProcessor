package com.fetch.receiptprocessor.model;



import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Receipt {
    @NotBlank
    @Pattern(regexp = "^[\\w\\s\\-&]+$")
    private String retailer;
    @NotBlank
    private String purchaseDate;
    @NotBlank
    private String purchaseTime;
    @NotEmpty
    private List<@Valid Item> items;
    @NotBlank
    @Pattern(regexp="^\\d+\\.\\d{2}$")
    private String total;
}
