package food.finder.foodfinder.foodgroup;

import food.finder.foodfinder.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
final class FoodGroupController {

    private final UserRepository userRepository;
    private final FoodGroupRepository foodGroupRepository;

    @PostMapping("/createFoodGroup")
    Mono<FoodGroup> createNewFoodGroup(@RequestBody CreateFoodGroupRequest foodGroup) {
        return userRepository.findById(foodGroup.creatorEmail())
                .flatMap(creator -> {
                    final var newGroup = new FoodGroup(foodGroup.groupName(), creator);
                    newGroup.getUsersInGroup().add(creator);
                    return foodGroupRepository.save(newGroup);
                });
    }
}