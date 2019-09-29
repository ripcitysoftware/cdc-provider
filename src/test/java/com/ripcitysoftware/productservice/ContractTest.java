package com.ripcitysoftware.productservice;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.web.context.ConfigurableWebApplicationContext;

@RunWith(PactRunner.class)
@Provider("productServiceProvider")
@PactFolder("pacts")
public class ContractTest {
    @TestTarget
    public static Target target = new HttpTarget(9090);

    private static ConfigurableWebApplicationContext applicationContext;
    @BeforeClass
    public static void start() {
        applicationContext =
                (ConfigurableWebApplicationContext) SpringApplication
                        .run(DemoApplication.class);
    }

    @State("Product 1 exists")
    public void productServiceClient() { }
}
