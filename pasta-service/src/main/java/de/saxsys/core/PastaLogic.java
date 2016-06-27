package de.saxsys.core;

import de.saxsys.model.NoodlesPackage;
import de.saxsys.model.Pasta;
import org.springframework.stereotype.Component;

@Component
public class PastaLogic {

    public Pasta cookPasta(NoodlesPackage noodlesPackage) {
        Pasta pasta = new Pasta();
        pasta.setShape(noodlesPackage.getShape());
        pasta.setFlourType(noodlesPackage.getFlourType());
        cookPasta(pasta);
        return pasta;
    }

    private void cookPasta(Pasta pasta) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pasta.setAlDente(true);
    }

}
