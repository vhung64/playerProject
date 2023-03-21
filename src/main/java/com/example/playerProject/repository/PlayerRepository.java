package com.example.playerProject.repository;

import com.example.playerProject.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findByStatusOrderByRateDesc(Boolean status);
    List<Player> findByStatus(Boolean status);
    Optional<Player> findByUrl(String url);
}