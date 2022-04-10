package food.finder.foodfinder.user;

import food.finder.foodfinder.Place;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Node
@Getter
@Setter
public final class User {

    @Id
    private final String email;

    @Property
    private final String username;

    @Property
    private Date createDate;

    @Relationship(type = "LIKED", direction = Relationship.Direction.OUTGOING)
    private Set<Place> likedPlaces = new HashSet<>();

    public User(String email, String username) {
        this.email = email;
        this.username = username;
    }
}
