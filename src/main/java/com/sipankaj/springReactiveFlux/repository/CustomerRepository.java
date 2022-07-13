package com.sipankaj.springReactiveFlux.repository;

import com.sipankaj.springReactiveFlux.entity.Users;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface CustomerRepository extends R2dbcRepository<Users, String>{
}
