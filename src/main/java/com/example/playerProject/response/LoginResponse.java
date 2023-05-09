package com.example.playerProject.response;

import com.example.playerProject.entity.Player;
import com.example.playerProject.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private Player auth;
    private String token;
    @JsonProperty("isAuthenticated")
    private Boolean isAuthenticated;
}
