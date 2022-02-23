package food.finder.foodfinder;

import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Node
@Getter
public final class User {

    @Id
    private final String email;

    @Property
    private final String username;

    @Relationship(type = "LIKED", direction = Relationship.Direction.OUTGOING)
    private final Set<Place> likedPlaces = new HashSet<>();

    public User(String email, String username) {
        this.email = email;
        this.username = username;
    }
}