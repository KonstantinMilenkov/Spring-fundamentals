package com.softuni.mobielele.service;

import com.softuni.mobielele.model.dto.CreateOfferDTO;

import java.util.UUID;

public interface OfferService {
    UUID createOffer(CreateOfferDTO createOfferDTO);
}
