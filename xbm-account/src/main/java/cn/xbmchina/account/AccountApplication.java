package cn.xbmchina.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EntityScan("cn.xbmchina.account.entity")
@EnableDiscoveryClient
@EnableFeignClients
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class,args);
    }
}
