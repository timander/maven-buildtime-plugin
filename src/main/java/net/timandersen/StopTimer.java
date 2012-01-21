package net.timandersen;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

/**
 * Goal that reports the build time
 *
 * @goal stop
 * @phase verify
 */
public class StopTimer extends AbstractMojo {
  /**
   * The url to send the build time to.
   *
   * @parameter reportUrl=""
   */
  private String reportUrl;

  public void execute() throws MojoExecutionException {
    getLog().info("####### Stopping timer!");
    getLog().info("reportUrl = " + reportUrl);
    getLog().info("elaspedTime = " + Stopwatch.elapsedTime());
  }

}
