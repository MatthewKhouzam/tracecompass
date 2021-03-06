/**********************************************************************
 * Copyright (c) 2015 Ericsson
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License 2.0 which
 * accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Bernd Hufmann - Initial API and implementation
 **********************************************************************/
package org.eclipse.tracecompass.internal.tmf.remote.core.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;

/**
 * A class to initialize the preferences.
 *
 * @author Bernd Hufmann
 */
public class TmfRemotePreferenceInitializer extends AbstractPreferenceInitializer {

    @Override
    public void initializeDefaultPreferences() {
        TmfRemotePreferences.init();
    }
}
