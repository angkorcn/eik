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

import info.evanchik.eclipse.karaf.core.LogWrapper;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class KarafWtpPluginActivator extends Plugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "info.evanchik.eclipse.karaf.wtp.core";

    /**
     * The list of runtime type identifiers that this plugin defines
     */
    public static final String[] RUNTIME_TYPE_IDS = new String[] {
        "info.evanchik.eclipse.karaf.wtp.server.runtime.2"
    };

    // The shared instance
    private static KarafWtpPluginActivator plugin;

    /**
     * Returns the shared instance
     *
     * @return the shared instance
     */
    public static KarafWtpPluginActivator getDefault() {
        return plugin;
    }

    /**
     * Getter for the {@link LogWrapper} object that makes logging much easier
     * on the caller.
     *
     * @return the {@link LogWrapper} instance
     */
    public static LogWrapper getLogger() {
        return new LogWrapper(getDefault().getLog(), PLUGIN_ID);
    }

    /**
     * The constructor
     */
    public KarafWtpPluginActivator() {
    }

    @Override
    public void start(final BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    @Override
    public void stop(final BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

}
