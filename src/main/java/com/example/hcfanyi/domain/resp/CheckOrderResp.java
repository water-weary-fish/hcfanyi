package com.example.hcfanyi.domain.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CheckOrderResp {

    @JsonProperty("paid")
    private Boolean paid;
    @JsonProperty("user")
    private UserDTO user;
    private Boolean forever;
    private Long endTime;
    private Boolean isOpened;

    @NoArgsConstructor
    @Data
    public static class UserDTO {
        @JsonProperty("points")
        private Integer points;
        @JsonProperty("_id")
        private String id;
        @JsonProperty("email")
        private String email;
        @JsonProperty("vipActivated")
        private Boolean vipActivated;
        @JsonProperty("rebatePoints")
        private Integer rebatePoints;

        private Long endTime;
        private Boolean isOpened;
        private Boolean forever;
    }
}
