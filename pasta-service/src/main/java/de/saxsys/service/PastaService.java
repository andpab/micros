package de.saxsys.service;

import de.saxsys.model.Pasta;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PastaService {

    @RequestMapping("/preparePasta")
    public Pasta preparePasta() {
        Pasta pasta = new Pasta();
        pasta.setShape("Fusilli");
        return pasta;
    }

}
