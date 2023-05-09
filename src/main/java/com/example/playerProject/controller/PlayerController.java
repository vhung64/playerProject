package com.example.playerProject.controller;

import com.example.playerProject.repository.PlayerRepository;
import com.example.playerProject.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/public/player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    @GetMapping("{url}")
    public ResponseEntity<?> getInfoPlayer(@PathVariable String url){
        return ResponseEntity.ok(playerService.getInfoPlayer(url));
    }
    @GetMapping("top15")
    public ResponseEntity<?> getTop15Player(){
        return ResponseEntity.ok(playerService.getTop15Player());
    }
}
