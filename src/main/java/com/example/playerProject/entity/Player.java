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
public class Player implements UserDetails {
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

    @Column(name = "password")
    private String password;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "album")
    private String album;

    @Column(name = "introduce")
    private String introduce;

    @Column(name = "player-price")
    private Integer playerPrice;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "notification")
    private String notification;

    // so tien da nap
    @Column(name = "payment")
    private String payment;

    // so du
    @Column(name = "credit")
    private String credit;

    // so tien da donate
    @Column(name = "amount_donate")
    private String amountDonate;

    // so tien da duoc donate
    @Column(name = "donation_amount")
    private String donationAmount;

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

    @Column(name = "role")
    private String role;

    @ManyToMany
    @JoinTable(name = "player_categories",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id"))
    private Set<Category> categories = new LinkedHashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_" + this.role));
        return roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.url;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @PostPersist
    public void postPersist() {
        createdAt = LocalDateTime.now();
    }
}