package food.finder.foodfinder.user;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface UserRepository extends ReactiveNeo4jRepository<User, String> {

}