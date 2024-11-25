package com.baraka.boms.domain.model;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.requireNonNull;

public record AccountId(String value) implements Microtype<String> {

    public AccountId {
        requireNonNull(value, "id");
        checkArgument(!value.isBlank(), "id must not be blank");
    }

    public static AccountId accountId(String id) {
        return new AccountId(id);
    }

    @Override
    public String toString() {
        return value;
    }
}
