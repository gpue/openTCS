/*
 * openTCS copyright information:
 * Copyright (c) 2014 Fraunhofer IML
 *
 * This program is free software and subject to the MIT license. (For details,
 * see the licensing information (LICENSE.txt) you should have received with
 * this copy of the software.)
 */
package org.opentcs.kernel;

import java.util.Arrays;
import java.util.List;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.opentcs.TestBase;

/**
 *
 * @author Tobias Marquardt (Fraunhofer IML)
 */
public class KernelStateTest
    extends TestBase {

  public KernelStateTest() {
    super();
  }

  @Override
  protected List<String> storyPaths() {
    return Arrays.asList("org/opentcs/kernel/KernelState.story");
  }

  @Override
  public InjectableStepsFactory stepsFactory() {
    return new InstanceStepsFactory(configuration(), new KernelStateSteps());
  }
}
