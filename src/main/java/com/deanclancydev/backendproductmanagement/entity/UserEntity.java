package com.deanclancydev.backendproductmanagement.entity;

import com.deanclancydev.backendproductmanagement.security.ApplicationUserRole;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@Builder(builderClassName = "Builder")
@JsonDeserialize(builder = UserEntity.Builder.class)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String firstName;

    private String lastName;

    private String userName;

    private String password;

    private String email;

    private String profileImageUrl;

    private Date lastLoginDate;

    private Date lastLoginDateDisplay;

    private Date joinDate;

    private ApplicationUserRole role;

    private Boolean isActive;

    private Boolean isNotLocked;

    @JsonPOJOBuilder(withPrefix = StringUtils.EMPTY)
    public static class Builder {
    }
}
