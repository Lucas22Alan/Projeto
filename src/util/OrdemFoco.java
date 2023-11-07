/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Component;
import java.util.List;

/**
 *
 * @author Mk Solucoes
 */
public class OrdemFoco extends DefineOrdemFocoGenerica{

    public OrdemFoco(List<Component> listaComponente) {
        for(Component compo: listaComponente){
            this.componentes.add(compo);
        }
    }
}
