package io.namoosori.travelclub.web.dto;

import lombok.Data;

//사용자와 인터렉션할 데이타
@Data
public class UserLocationDTO {
    private long userId;
    private String email;
    private String place;
    private double longitude;
    private double latitude;
}