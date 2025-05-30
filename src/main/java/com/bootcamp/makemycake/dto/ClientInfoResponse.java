package com.bootcamp.makemycake.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientInfoResponse {
    private String fullName;
    private String phoneNumber;
    private String address;
} 