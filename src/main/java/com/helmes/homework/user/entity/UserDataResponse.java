package com.helmes.homework.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDataResponse {
    private String name;
    private List<Long> userSectors;
    private boolean agreeToTerms;
}

