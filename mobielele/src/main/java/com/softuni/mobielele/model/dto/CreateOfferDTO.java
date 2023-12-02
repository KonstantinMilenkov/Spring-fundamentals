package com.softuni.mobielele.model.dto;

import com.softuni.mobielele.model.enums.EngineEnum;
import com.softuni.mobielele.model.enums.Transmission;
import jakarta.validation.constraints.*;


public record CreateOfferDTO(
        @NotEmpty
        @Size(min = 5, max = 512)
        String description,
        @Positive
        @NotNull
        Long modelId,
        @NotNull
        EngineEnum engine,
        @NotNull
        Transmission transmission,
        @NotNull
        String imageUrl,
        @NotNull
        @Positive
        Integer mileage,
        @NotNull
        @Positive
        Integer price,
        @NotNull
        @Min(1930)
        Integer year) {
    public CreateOfferDTO (){
        this(null,null,null,null,null,null,null,null);
    }
}
