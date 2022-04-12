package food.finder.foodfinder.foodgroup;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
final class DeleteFoodGroupService {

    private final FoodGroupRepository foodGroupRepository;

    Mono<Void> deleteFoodGroup(Long id) {
        return verifyFoodGroupExists(id)
                .then(foodGroupRepository.deleteById(id));
    }

    private Mono<Object> verifyFoodGroupExists(Long id) {
        return foodGroupRepository.existsById(id)
                .handle((exists, sink) -> {
                    if (Boolean.FALSE.equals(exists)) {
                        sink.error(new FoodGroupNotFoundException());
                    } else {
                        sink.next(exists);
                    }
                });
    }
}