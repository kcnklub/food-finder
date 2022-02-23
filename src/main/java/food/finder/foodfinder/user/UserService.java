package food.finder.foodfinder.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
final class UserService {

    private final UserRepository userRepository;

    Mono<Object> makeSureNewUserDoesNotAlreadyExist(String email) {
        return userRepository.existsById(email)
                .handle((exists, sink) -> {
                    if (Boolean.TRUE.equals(exists)) {
                        sink.error(new UserFoundException("User already exists"));
                    } else {
                        sink.next(exists);
                    }
                });
    }
}