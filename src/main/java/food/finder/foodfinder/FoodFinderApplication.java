package food.finder.foodfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableReactiveNeo4jRepositories;

@EnableReactiveNeo4jRepositories
@SpringBootApplication
public class FoodFinderApplication {
	public static void main(String[] args) {
		SpringApplication.run(FoodFinderApplication.class, args);
	}
}