/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.util.LinkedList;

/**
 *
 * @author Mk Solucoes
 */
public class DefineOrdemFocoGenerica extends FocusTraversalPolicy{
  protected final java.util.List<Component> componentes = new LinkedList<>();
  private int focado = 0;

  @Override
  public Component getComponentAfter(Container focusCycleRoot, Component aComponent) {
    this.focado = (this.focado + 1) % this.componentes.size();

    return this.componentes.get(focado);
  }

  @Override
  public Component getComponentBefore(Container focusCycleRoot, Component aComponent) {
    this.focado = (this.componentes.size() + this.focado - 1) % this.componentes.size();

    return this.componentes.get(focado);
  }

  @Override
  public Component getDefaultComponent(Container focusCycleRoot) {
    return this.componentes.get(0);
  }

  @Override
  public Component getLastComponent(Container focusCycleRoot) {
    return this.componentes.get(this.componentes.size() - 1);
  }

  @Override
  public Component getFirstComponent(Container focusCycleRoot) {
    return this.componentes.get(0);
  }
    
}
