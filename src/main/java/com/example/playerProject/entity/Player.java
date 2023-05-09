package com.example.playerProject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "player")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "album")
    private String album;

    @Column(name = "introduce", length = 500)
    private String introduce;

    @Column(name = "player-price")
    private Integer playerPrice;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "isPlayerDuo")
    private Boolean isPlayerDuo;

    @Column(name = "notification")
    private String notification;

    // so tien da nap
    @Column(name = "payment")
    private Integer payment;

    // so du
    @Column(name = "credit")
    private Integer credit;

    // so tien da donate
    @Column(name = "amount_donate")
    private Integer amountDonate;

    // so tien da duoc donate
    @Column(name = "donation_amount")
    private Integer donationAmount;

    // so gio thue
    @Column(name = "hours_rented")
    private Integer hoursRented;

    // so gio da duoc thue
    @Column(name = "hours_worked")
    private Integer hoursWorked;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "link_facebook")
    private String linkFacebook;

    @ManyToMany
    @JoinTable(name = "player_categories",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id"))
    private Set<Category> categories = new LinkedHashSet<>();

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        hoursRented = 0;
        hoursWorked = 0;
        payment = 0;
        credit = 0;
        amountDonate = 0;
        donationAmount = 0;
    }
}