package food.finder.foodfinder.foodgroup;

import food.finder.foodfinder.user.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;

@Node
@Getter
@Setter
final class FoodGroup {

    @Id
    @GeneratedValue
    private Long id;

    @Property
    private final String name;

    @Relationship(type = "CREATED", direction = INCOMING)
    private final User creator;

    @Relationship(type = "IN_A", direction = INCOMING)
    private Set<User> usersInGroup = new HashSet<>();

    FoodGroup(String name,
              User creator) {
        this.name = name;
        this.creator = creator;
    }
}