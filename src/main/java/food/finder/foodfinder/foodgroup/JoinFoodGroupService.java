package food.finder.foodfinder.foodgroup;

import food.finder.foodfinder.user.User;
import food.finder.foodfinder.user.UserNotFoundException;
import food.finder.foodfinder.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
final class JoinFoodGroupService {

    private final UserRepository userRepository;
    private final FoodGroupRepository foodGroupRepository;

    Mono<FoodGroup> AddUserToFoodGroup(String joiningEmail, Long groupId) {
        return verifyUserExists(joiningEmail)
                .then(userRepository.findById(joiningEmail)
                        .flatMap(joiningUser -> addUserToFoodGroup(joiningUser, groupId)));
    }

    private Mono<Object> verifyUserExists(String email) {
        return userRepository.existsById(email)
                .handle((exists, sink) -> {
                    if (Boolean.FALSE.equals(exists)) {
                        sink.error(new UserNotFoundException());
                    } else {
                        sink.next(exists);
                    }
                });
    }

    private Mono<FoodGroup> addUserToFoodGroup(User user, Long groupId) {
        return foodGroupRepository.findById(groupId)
                .flatMap(group -> {
                    group.getUsersInGroup().add(user);
                    return foodGroupRepository.save(group);
                });
    }
}