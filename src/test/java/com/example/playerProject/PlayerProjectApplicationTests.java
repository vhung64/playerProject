package com.example.playerProject;

import com.example.playerProject.entity.Category;
import com.example.playerProject.entity.Player;
import com.example.playerProject.repository.CategoryRepository;
import com.example.playerProject.repository.PlayerRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class PlayerProjectApplicationTests {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private Faker faker;

	@Test
	void load_Category() {
		List<String> list = List.of(
				"Liên Minh Huyền Thoại",
				"Đấu Trường Chân Lý",
				"PUBG Mobile",
				"PUBG PC",
				"Liên Quân Mobile",
				"Liên Minh Tốc Chiến",
				"Free Fire",
				"Valorant",
				"Naraka Bladepoint",
				"CSGO",
				"Hát"
		);
		list.forEach(s -> {
			Category category = Category.builder().name(s).build();
			categoryRepository.save(category);
		});
	}

	@Test
	void load_Player() {
		for(int i = 0; i < 6; i++){
			Random rd = new Random();
			List<Category> categories = categoryRepository.findAll();
			Set<Category> rdCategories = new LinkedHashSet<>();
			for (int j = 0; j < 3; j++) {
				Category rdCategory = categories.get(rd.nextInt(categories.size()));
				rdCategories.add(rdCategory);
			}
			Player player = Player.builder()
					.name(faker.name().fullName())
					.url(faker.name().lastName().toLowerCase())
					.email(faker.internet().emailAddress())
					.avatar(faker.internet().avatar())
					.introduce(faker.address().fullAddress())
					.playerPrice(50000)
					.status(true)
					.categories(rdCategories)
					.rate(4.0)
					.build();
			playerRepository.save(player);
		}
	}

}
