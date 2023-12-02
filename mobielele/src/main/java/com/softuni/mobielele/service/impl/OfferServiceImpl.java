package com.softuni.mobielele.service.impl;

import com.softuni.mobielele.model.dto.CreateOfferDTO;
import com.softuni.mobielele.repository.OfferRepository;
import com.softuni.mobielele.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO) {
//        throw new UnsupportedOperationException("Coming soon");
        return UUID.randomUUID();
    }
}
