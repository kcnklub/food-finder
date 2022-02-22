package food.finder.foodfinder;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public record Place(@Id String id, String name) {

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
