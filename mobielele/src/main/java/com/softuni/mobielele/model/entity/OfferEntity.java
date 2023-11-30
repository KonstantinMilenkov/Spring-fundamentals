package com.softuni.mobielele.model.entity;

import com.softuni.mobielele.model.enums.EngineEnum;
import com.softuni.mobielele.model.enums.Transmission;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.UUID;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity{
    @JdbcTypeCode(Types.VARCHAR)
    private UUID uuid;

    private String description;
    @ManyToOne
    private ModelEntity model;

    @Enumerated(EnumType.STRING)
    private EngineEnum engineEnum;

    @Enumerated(EnumType.STRING)
    private Transmission transmission;
    private String imageURL;
    private long mileage;
    private BigDecimal price;
    private int year;

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public OfferEntity setModel(ModelEntity model) {
        this.model = model;
        return this;
    }

    public OfferEntity setEngineEnum(EngineEnum engineEnum) {
        this.engineEnum = engineEnum;
        return this;
    }

    public OfferEntity setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public OfferEntity setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public OfferEntity setMileage(long mileage) {
        this.mileage = mileage;
        return this;
    }

    public OfferEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public OfferEntity setYear(int year) {
        this.year = year;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ModelEntity getModel() {
        return model;
    }

    public EngineEnum getEngineEnum() {
        return engineEnum;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public String getImageURL() {
        return imageURL;
    }

    public long getMileage() {
        return mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public UUID getUuid() {
        return uuid;
    }

    public OfferEntity setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }
}
