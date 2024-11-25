package com.baraka.oms.model;

import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;

import java.math.BigDecimal;
import java.time.Instant;

import static java.math.RoundingMode.HALF_EVEN;
import static java.time.temporal.ChronoUnit.MICROS;
import static java.util.UUID.randomUUID;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomUtils.nextDouble;

public interface ModelTestData {

    default BookId aBookId() {
        return bookId(randomAlphabetic(10));
    }


    default BigDecimal aDecimal() {
        return aDecimal(10);
    }

    default BigDecimal aDecimalLessThan(BigDecimal other) {
        return  BigDecimal.valueOf(nextDouble(1, other.doubleValue()))
                .setScale(other.scale(), HALF_EVEN)
                .stripTrailingZeros();
    }

    default BigDecimal aDecimal(int scale) {
        return BigDecimal.valueOf(nextDouble(1, 1000))
                .setScale(scale, HALF_EVEN)
                .stripTrailingZeros();
    }

    default Currency aCurrency() {
        return anEnum(Currency.class);
    }

    default <E extends Enum<E>> E anEnum(Class<E> enumType) {
        return enumType.getEnumConstants()[anInt(0, enumType.getEnumConstants().length)];
    }

    default UniformRandomProvider random() {
        return RandomHolder.random;
    }

    default int anInt(int min, int max) {
        return random().nextInt(min, max);
    }

    default double aDouble(long min, long max) {
        return random().nextDouble(min, max);
    }

    final class RandomHolder {
        private static final UniformRandomProvider random = RandomSource.JDK.create();
    }
}
