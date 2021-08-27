package com.deanclancydev.backendproductmanagement.dto;


import com.deanclancydev.backendproductmanagement.entity.Role;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;

@Value
@Builder(builderClassName = "Builder")
@JsonDeserialize(builder = Product.Builder.class)
public class Product{

    Long id;

    String name;

    @JsonPOJOBuilder(withPrefix = StringUtils.EMPTY)
    public static class Builder {
    }
}
