package com.sipankaj.springReactiveFlux.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

@Data
@Builder
public class Users {
    @Column("user_id")
    private Integer user_id;
    @Column("name")
    private String name;
}
