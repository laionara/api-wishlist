package com.wishlist.transportlayers.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductDTO(@NotNull String name, @NotNull BigDecimal price) {

}
