package com.deanclancydev.backendproductmanagement.dto;

import com.deanclancydev.backendproductmanagement.entity.Role;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;

@Value
@Builder(builderClassName = "Builder")
@JsonDeserialize(builder = User.Builder.class)
public class User{

    Long id;

    String name;

    String userName;

    String password;

    Role role;

    @JsonPOJOBuilder(withPrefix = StringUtils.EMPTY)
    public static class Builder {
    }
}

