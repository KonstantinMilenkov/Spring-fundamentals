package com.softuni.mobielele.model.dto;

public record UserRegistrationDto (String firstName,
                                   String lastName,
                                   String email,
                                   String password,
                                   String confirmPassword ){
}
