package de.saxsys.service;

import de.saxsys.client.SupermarketService;
import de.saxsys.core.PastaLogic;
import de.saxsys.model.NoodlesPackage;
import de.saxsys.model.Pasta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PastaService {

    @Autowired
    SupermarketService supermarketService;

    @Autowired
    PastaLogic pastaLogic;

    @RequestMapping("/preparePasta")
    public Pasta preparePasta() {
        NoodlesPackage noodlesPackage = supermarketService.getNoodlesPackage();
        return pastaLogic.cookPasta(noodlesPackage);
    }

}
