package food.finder.foodfinder;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
class UserController {

    private final UserRepository userRepository;

    @Transactional
    @PostMapping("/createNewUser")
    Mono<User> createNewUser(@RequestBody User user) {
       return userRepository.existsById(user.getEmail())
                .handle((exists, sink) -> {
                    if(Boolean.TRUE.equals(exists)){
                        sink.error(new UserFoundException("User already exists"));
                    } else {
                        sink.next(exists);
                    }
                }).then(userRepository.save(user));
    }
}
