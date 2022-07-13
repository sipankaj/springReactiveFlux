package com.sipankaj.springReactiveFlux.api;

import com.sipankaj.springReactiveFlux.dto.UserRequest;
import com.sipankaj.springReactiveFlux.entity.Users;
import com.sipankaj.springReactiveFlux.exception.ApiException;
import com.sipankaj.springReactiveFlux.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserApi {
    private final CustomerRepository customerRepository;

    @PostMapping
    public Mono<Users> createUser(@RequestBody UserRequest userRequest) {
        final Users usersRequest = Users.builder()
                .user_id(userRequest.getUser_id())
                .name(userRequest.getName())
                .build();
        Mono<Users> usersResponse;
        try {
            usersResponse = customerRepository.save(usersRequest);
        } catch (Exception e) {
            throw new ApiException(e.getMessage());
        }
        return usersResponse;
    }

}
