package com.sipankaj.springReactiveFlux.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Column;

import java.util.UUID;

@Data
@Builder
public class User {
    @Id
    private UUID id;
    @Column("user_id")
    private Integer user_id;
    @Column("name")
    private String name;
    @CreatedBy
    @Column("created_by")
    private String createdBy;
    @CreatedDate
    @Column("created_date")
    private Long createdDate;
    @LastModifiedBy
    @Column("last_modified_by")
    private String lastModifiedBy;
    @LastModifiedDate
    @Column("last_modified_date")
    private Long lastModifiedDate;
}
