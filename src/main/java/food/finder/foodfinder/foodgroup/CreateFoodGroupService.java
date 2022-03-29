package food.finder.foodfinder.foodgroup;

import food.finder.foodfinder.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Date;

@Component
@RequiredArgsConstructor
final class CreateFoodGroupService {

    private final UserRepository userRepository;
    private final FoodGroupRepository foodGroupRepository;

    Mono<FoodGroup> createFoodGroup(CreateFoodGroupRequest foodGroup) {
        return userRepository.findById(foodGroup.creatorEmail())
                .flatMap(creator -> {
                    final var newGroup = new FoodGroup(foodGroup.groupName(), creator);
                    newGroup.setCreatedDate(new Date());
                    newGroup.getUsersInGroup().add(creator);
                    return foodGroupRepository.save(newGroup);
                });
    }
}
