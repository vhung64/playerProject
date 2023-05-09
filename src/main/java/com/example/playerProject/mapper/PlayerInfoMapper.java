package com.example.playerProject.mapper;

import com.example.playerProject.dto.PlayerInfoDto;
import com.example.playerProject.entity.Player;

public class PlayerInfoMapper {
    public static PlayerInfoDto toPlayerInfoDto(Player player){
        PlayerInfoDto dto = new PlayerInfoDto(
                player.getId(),
                player.getName(),
                player.getUrl(),
                player.getAvatar(),
                player.getAlbum(),
                player.getIntroduce(),
                player.getPlayerPrice(),
                player.getRate(),
                player.getStatus(),
                player.getDonationAmount(),
                player.getHoursWorked(),
                player.getCreatedAt(),
                player.getLinkFacebook(),
                player.getCategories()
        );
        return dto;
    }
}
