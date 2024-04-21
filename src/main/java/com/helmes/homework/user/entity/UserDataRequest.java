package com.helmes.homework.user.entity;


import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDataRequest {
    @NotBlank(message = "Name is required")
    private String name;
    @NotEmpty(message = "At least one sector must be selected")
    private List<Long> userSectors;
    @AssertTrue(message = "Need to agree to terms")
    private boolean agreeToTerms;
}
