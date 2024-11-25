package com.example.hexagonalarchitecture;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CheckDBConnectivity extends BaseModuleTest {
    @Test
    void checkDbConnection() {
        assertThat(entityManager.createNativeQuery("select 1", Integer.class).getSingleResult())
                .isEqualTo(1);
    }
}
