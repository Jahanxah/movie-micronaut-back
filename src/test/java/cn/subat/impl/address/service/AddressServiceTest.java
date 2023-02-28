package cn.subat.impl.address.service;

import cn.subat.impl.common.singleton.ImplClient;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



@MicronautTest
class AddressServiceTest {


    @Inject
    ImplClient implClient;
    @Test
    void getAddress() {
        implClient.rpc("address.add").subscribe(System.out::println);
        implClient.rpc("address.get").subscribe(System.out::println);
    }
}