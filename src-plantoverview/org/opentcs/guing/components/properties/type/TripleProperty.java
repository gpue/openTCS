/*
 * openTCS copyright information:
 * Copyright (c) 2013 Fraunhofer IML
 *
 * This program is free software and subject to the MIT license. (For details,
 * see the licensing information (LICENSE.txt) you should have received with
 * this copy of the software.)
 */

package org.opentcs.guing.components.properties.type;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.opentcs.data.model.Triple;
import org.opentcs.guing.model.ModelComponent;

/**
 * Ein Property f�r einen 3D-Punkt. Der Datentyp f�r die Koordinaten des Punktes
 * ist <code>long</code>.
 *
 * @author Heinz Huber (Fraunhofer IML)
 */
public class TripleProperty
    extends AbstractProperty {

  /**
   * Der Punkt.
   */
  private Triple fTriple;

  /**
   * Creates a new instance of PointProperty.
   *
   * @param model
   */
  public TripleProperty(ModelComponent model) {
    super(model);
  }

  @Override
  public Object getComparableValue() {
    return fTriple.getX() + "," + fTriple.getY() + "," + fTriple.getZ();
  }

  /**
   * Setzt f�r das Attribut einen neuen Wert und eine neue Ma�einheit. Eine
   * Ausnahme wird ausgel�st, wenn es sich bei der Ma�einheit um keine m�gliche
   * Einheit handelt.
   *
   * @param triple
   */
  public void setValue(Triple triple) {
    fTriple = triple;
  }

  @Override
  public Triple getValue() {
    return fTriple;
  }

  @Override
  public String toString() {
    return fTriple == null ? "null"
        : String.format("(%d, %d, %d)", fTriple.getX(), fTriple.getY(), fTriple.getZ());
  }

  @Override
  public void copyFrom(Property property) {
    TripleProperty tripleProperty = (TripleProperty) property;

    try {
      Triple foreignTriple = tripleProperty.getValue();
      setValue(foreignTriple.clone());
    }
    catch (Exception e) {
      Logger.getLogger(TripleProperty.class.getName()).log(Level.SEVERE, "Exception: ", e);
    }
  }
}
