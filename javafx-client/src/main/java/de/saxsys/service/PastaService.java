package de.saxsys.service;

import de.saxsys.model.ClientPasta;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "pasta-service")
public interface PastaService {

    @RequestMapping(value = "/preparePasta", method = RequestMethod.GET)
    ClientPasta getPasta();

}
