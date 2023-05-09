package com.example.playerProject.repository;

import com.example.playerProject.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Optional<Player> findByEmail(String email);
    @Query("select p from Player p where p.status = ?1 order by p.rate DESC")
    List<Player> findByStatusOrderByRateDesc(Boolean status);
    List<Player> findByStatus(Boolean status);
    Optional<Player> findByUrl(String url);
}