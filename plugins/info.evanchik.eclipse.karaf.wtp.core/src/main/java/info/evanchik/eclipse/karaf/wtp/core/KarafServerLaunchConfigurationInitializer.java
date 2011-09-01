/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package info.evanchik.eclipse.karaf.wtp.core;

import info.evanchik.eclipse.karaf.core.KarafPlatformModelRegistry;
import info.evanchik.eclipse.karaf.core.configuration.StartupSection;
import info.evanchik.eclipse.karaf.ui.KarafLaunchConfigurationInitializer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.ServerUtil;

/**
 * @author Stephen Evanchik (evanchsa@gmail.com)
 *
 */
public class KarafServerLaunchConfigurationInitializer extends KarafLaunchConfigurationInitializer {

    private IServer server;

    @Override
    protected void loadKarafPlatform(final ILaunchConfigurationWorkingCopy configuration) {
        try {
            server = ServerUtil.getServer(configuration);

            if (server == null) {
                return;
            }

            this.karafPlatform = KarafPlatformModelRegistry.findPlatformModel(server.getRuntime().getLocation());

            this.startupSection = (StartupSection) this.karafPlatform.getAdapter(StartupSection.class);
            this.startupSection.load();
        } catch (final CoreException e) {
        }
    }
}
