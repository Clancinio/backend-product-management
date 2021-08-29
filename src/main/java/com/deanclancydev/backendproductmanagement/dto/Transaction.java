package com.deanclancydev.backendproductmanagement.dto;

import com.deanclancydev.backendproductmanagement.entity.ProductEntity;
import com.deanclancydev.backendproductmanagement.entity.UserEntity;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

@Value
@Builder(builderClassName = "Builder")
@JsonDeserialize(builder = Transaction.Builder.class)
public class Transaction {

    Long id;

    ProductEntity product;

    UserEntity user;

    LocalDateTime purchaseDate;

    @JsonPOJOBuilder(withPrefix = StringUtils.EMPTY)
    public static class Builder {
    }
}
