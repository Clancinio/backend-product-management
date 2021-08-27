package com.deanclancydev.backendproductmanagement.dto;

import com.deanclancydev.backendproductmanagement.entity.ProductEntity;
import com.deanclancydev.backendproductmanagement.entity.UserEntity;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;

@Value
@Builder(builderClassName = "Builder")
@JsonDeserialize(builder = Transaction.Builder.class)
public class Transaction {

    Long id;

    ProductEntity product;

    UserEntity userEntity;

    @JsonPOJOBuilder(withPrefix = StringUtils.EMPTY)
    public static class Builder {
    }
}
