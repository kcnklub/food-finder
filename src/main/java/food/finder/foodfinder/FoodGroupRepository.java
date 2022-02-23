package food.finder.foodfinder;

import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface FoodGroupRepository extends ReactiveNeo4jRepository<FoodGroup, Long> {
    Mono<FoodGroup> findFoodGroupById(Long id);
}
