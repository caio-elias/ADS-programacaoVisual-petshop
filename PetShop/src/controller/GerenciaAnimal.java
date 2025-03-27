
package controller;

import modelDAO.AnimalDAO;
import modelDAO.ItensDAO;


public class GerenciaAnimal {

    AnimalDAO ad;

    public GerenciaAnimal() {
        ad = new AnimalDAO();
    }

    public int proximoCodigo() {
        return ad.proximoCodigo();
    }

}
