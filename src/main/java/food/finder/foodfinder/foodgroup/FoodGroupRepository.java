package food.finder.foodfinder.foodgroup;

import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

interface FoodGroupRepository extends ReactiveNeo4jRepository<FoodGroup, Long> {
    Mono<FoodGroup> findFoodGroupById(Long id);
}
