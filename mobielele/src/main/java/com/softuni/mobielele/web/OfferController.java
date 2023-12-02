package com.softuni.mobielele.web;

import com.softuni.mobielele.model.dto.CreateOfferDTO;
import com.softuni.mobielele.model.enums.EngineEnum;
import com.softuni.mobielele.service.BrandService;
import com.softuni.mobielele.service.OfferService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/offer")
public class OfferController {
    private final OfferService offerService;
    private final BrandService brandService;

    public OfferController(OfferService offerService,
                           BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public String all(){
        return "offers";
    }
    @ModelAttribute("engines")
    public EngineEnum[] engine(){
        return EngineEnum.values();
    }
    @GetMapping("/add")
    public String add(Model model){
        if (model.containsAttribute("createOfferDto")){
            model.addAttribute("createOfferDto", new CreateOfferDTO());
        }

        model.addAttribute("brands", brandService.getAllBrands());

        return "offer-add";
    }
    @PostMapping("/add")
    public String add(@Valid CreateOfferDTO createOfferDTO,
                      BindingResult bindingResult){

        offerService.createOffer(createOfferDTO);

        return "index";
    }
    @GetMapping("/{uuid}/details")
    public String details(@PathVariable("uuid") UUID uuid){
        return "details";
    }
}
