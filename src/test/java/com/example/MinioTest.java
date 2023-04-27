package com.example;

import io.minio.MinioClient;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.config.ConfigProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
@QuarkusTestResource(MinioTestResource.class)
public class MinioTest {

    @Test
    public void emptyTest() {
        MinioClient mc = MinioClient.builder()
                .endpoint(ConfigProvider.getConfig().getValue("minio_url", String.class))
                .credentials("testAccessKey", "testSecretKey")
                .build();

        Assertions.assertNotNull(mc);
    }
}
