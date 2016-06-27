package de.saxsys.client;

import de.saxsys.model.NoodlesPackage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "supermarket-service")
public interface SupermarketService {

    // accessing just the first package for simplicity
    @RequestMapping("/noodlesPackages/1")
    public NoodlesPackage getNoodlesPackage();

}
