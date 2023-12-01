package com.softuni.mobielele.model.dto;

import com.softuni.mobielele.model.enums.EngineEnum;
import com.softuni.mobielele.model.enums.Transmission;


public record CreateOfferDTO(
        String description,
        Long modelId,
        EngineEnum engine,
        Transmission transmission,
        String imageUrl,
        Integer mileage,
        Integer price,
        Integer year) {
}
