package com.example.playerProject.service;

import com.example.playerProject.dto.PlayerInfoDto;
import com.example.playerProject.entity.Player;
import com.example.playerProject.exception.NotFoundException;
import com.example.playerProject.mapper.PlayerInfoMapper;
import com.example.playerProject.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public PlayerInfoDto getInfoPlayer(String url) {
        Player player = playerRepository.findByUrl(url).orElseThrow(() -> {
            throw new NotFoundException("Not found player with url = " + url);
        });
        PlayerInfoDto p = PlayerInfoMapper.toPlayerInfoDto(player);
        return p;
    }

    public List<PlayerInfoDto> getTop15Player() {
        List<Player> list = playerRepository.findByStatusOrderByRateDesc(true);
        list = list.subList(0, Math.min(list.size(), 15));
        List<PlayerInfoDto> dtoList = list.stream().map(PlayerInfoMapper::toPlayerInfoDto).collect(Collectors.toList());
        return dtoList;

    }
}
