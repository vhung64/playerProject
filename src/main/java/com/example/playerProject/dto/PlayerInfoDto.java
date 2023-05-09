package com.example.playerProject.dto;
import com.example.playerProject.entity.Category;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerInfoDto {
    private Integer id;
    private String name;
    private String url;
    private String avatar;
    private String album;
    private String introduce;
    private Integer playerPrice;
    private Double rate;
    private Boolean status;
    private Integer donationAmount;
    private Integer hoursWorked;
    private LocalDateTime createdAt;
    private String linkFacebook;
    private Set<Category> categories = new LinkedHashSet<>();
}
