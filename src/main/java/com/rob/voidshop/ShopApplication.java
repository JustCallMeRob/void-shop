package com.rob.voidshop;

import com.rob.voidshop.model.Product;
import com.rob.voidshop.model.User;
import com.rob.voidshop.repository.ProductRepository;
import com.rob.voidshop.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShopApplication {

	private static final Logger log = LoggerFactory.getLogger(ShopApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository userRep, ProductRepository productRep) {
		return (args) -> {

			userRep.deleteAll();
			productRep.deleteAll();

			userRep.save(new User("harry", "hunter1"));
			userRep.save(new User("larry", "hunter2"));

			String imagePath = "/img/1.png";
			productRep.save(new Product("Compressed anti-matter", "Good with anti-milk", "-50$$", imagePath));
			imagePath = "/img/2.png";
			productRep.save(new Product("Compressed anti-anti-matter", "Good with milk", "50$$", imagePath));
			imagePath = "/img/3.png";
			productRep.save(new Product("Gluten enriched entropy", "For anyone who wants to decrease the complexity of their lives", "50$$", imagePath));
			imagePath = "/img/4.png";
			productRep.save(new Product("Free range Shoggoth", "Warning! Incomprehensible, you've met with a terrible faith.", "100$$", imagePath));
			imagePath = "/img/5.png";
			productRep.save(new Product("Tiamat creation framework license", "A must have for any creator.", "50000$$", imagePath));


			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (User user : userRep.findAll()) {
				log.info(user.toString());
			}
			log.info("");

			User user = userRep.findByUsername("harry");
			log.info("Customer found with findByUsername(harry):");
			log.info("--------------------------------");
			log.info(user.toString());
			log.info("");

			Product product = productRep.findByName("Free range Shoggoth");
			log.info("Product found with findByName(Free range Shoggoth):");
			log.info("--------------------------------");
			log.info(product.toString());
			log.info("");
		};
	}
}
