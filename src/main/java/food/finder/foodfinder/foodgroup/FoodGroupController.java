package food.finder.foodfinder.foodgroup;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
class FoodGroupController {

    private final CreateFoodGroupService createFoodGroupService;
    private final JoinFoodGroupService joinFoodGroupService;

    @Transactional
    @PostMapping("/createFoodGroup")
    Mono<FoodGroup> createNewFoodGroup(@RequestBody CreateFoodGroupRequest request) {
        return createFoodGroupService.createFoodGroup(request);
    }

    @Transactional
    @PostMapping("/foodGroup/{id}/join")
    Mono<FoodGroup> joinFoodGroup(@PathVariable Long id,
                                  @RequestBody JoinFoodGroupRequest request) {
        return joinFoodGroupService.AddUserToFoodGroup(request.email(), id);
    }
}