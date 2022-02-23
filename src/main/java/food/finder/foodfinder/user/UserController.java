package food.finder.foodfinder.user;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @Transactional
    @PostMapping("/createNewUser")
    Mono<User> createNewUser(@RequestBody User user) {
       return userService.makeSureNewUserDoesNotAlreadyExist(user.getEmail())
               .then(userRepository.save(user));
    }
}
