/*
 * Licensed to Marvelution under one or more contributor license
 * agreements.  See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Marvelution licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.marvelution.bamboo.plugins.sonar.tasks;

import static com.marvelution.bamboo.plugins.sonar.tasks.configuration.SonarConfigConstants.SONAR_M3_PLUGIN_VERSION;

import com.atlassian.bamboo.process.EnvironmentVariableAccessor;
import com.atlassian.bamboo.task.TaskContext;
import com.atlassian.bamboo.v2.build.agent.capability.CapabilityContext;
import org.jetbrains.annotations.NotNull;

/**
 * {@link AbstractSonarMavenConfig} implementaiton for the Maven3 executable
 * 
 * @author <a href="mailto:markrekveld@marvelution.com">Mark Rekveld</a>
 */
public class SonarMaven3Config extends AbstractSonarMavenConfig {

	public static final String M3_CAPABILITY_PREFIX = "system.builder.mvn3";

	/**
	 * Constructor
	 *
	 * @param taskContext the {@link TaskContext} of the current executing taks
	 * @param capabilityContext the {@link CapabilityContext}
	 * @param environmentVariableAccessor the {@link EnvironmentVariableAccessor} implementation
	 */
	public SonarMaven3Config(@NotNull TaskContext taskContext, @NotNull CapabilityContext capabilityContext,
								@NotNull EnvironmentVariableAccessor environmentVariableAccessor) {
		super(taskContext, capabilityContext, environmentVariableAccessor, M3_CAPABILITY_PREFIX, getExecutableName());
		this.extraEnvironment.put("MAVEN2_HOME", this.builderPath);
		this.extraEnvironment.put("M2_HOME", this.builderPath);
	}

	/**
	 * Getter for the executable name
	 * 
	 * @return the executable name
	 */
	public static String getExecutableName() {
		return SonarMaven2Config.getExecutableName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getSonarMavenPluginVersion() {
		return SONAR_M3_PLUGIN_VERSION;
	}

}
