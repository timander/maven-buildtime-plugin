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

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;

import java.net.InetAddress;

/**
 * Goal that reports the build time
 *
 * @goal stop
 * @phase verify
 * @requiresOnline true
 */
public class StopTimer extends AbstractMojo {
  /**
   * The stops build and reports elapsed time
   *
   * @parameter reportUrl=""
   */
  private String reportUrl;

  public void execute() throws MojoExecutionException {
    try {
      String computername = InetAddress.getLocalHost().getHostName();
      MavenProject proj = (MavenProject) getPluginContext().get("project");
      long elapsedTime = Stopwatch.elapsedTime();
      String reportUrlWithParams = reportUrl +
        "/" + computername +
        "/" + proj.getName() +
        "/" + proj.getVersion() +
        "/" + elapsedTime;

      getLog().info("##### Stopping timer! Elapsed Time ("+ elapsedTime +" ms)");
      getLog().info(reportUrlWithParams);
  
      if (reportUrl != null && !reportUrl.equals("")) {
        new HttpClient().executeMethod(new GetMethod(reportUrlWithParams));
      }

    } catch (Exception e) {
      getLog().error("Exception caught =" + e.getMessage());
    }
  }
}

