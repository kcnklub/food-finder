package food.finder.foodfinder;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;

@Node
public final class FoodGroup {

    @Id @GeneratedValue
    private Long id;

    @Property("name")
    private final String name;

    @Relationship(type = "IN_A", direction = INCOMING)
    private Set<User> usersInGroup = new HashSet<>();

    public FoodGroup(String name) {
        this.name = name;
    }
}