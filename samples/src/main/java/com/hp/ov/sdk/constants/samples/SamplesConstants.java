/*
 * (C) Copyright 2015-2016 Hewlett Packard Enterprise Development LP
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hp.ov.sdk.constants.samples;

import com.hp.ov.sdk.rest.http.core.client.ApiVersion;

public class SamplesConstants {

    public static final String SCMB_TASKS_ROUTING_KEY = "scmb.tasks.#";
    public static final String MSMB_EXCHANGE_NAME = "msmb";
    public static final String MSMB_ALERTS_ROUTING_KEY = "msmb.#";
    public static final String KEY_STORE_FILE = "src/main/resources/KeyStore";
    public static final String TRUST_STORE_FILE = "src/main/resources/TrustStore";
    public static final String KEY_STORE_TYPE = "jks";
    public static final String TRUST_STORE_TYPE = "jks";
    public static final String DOMAIN = "LOCAL";

    // MOST LIKELY TO CHANGE ACCORDING TO YOUR CONFIGURATION
    public static final ApiVersion VERSION = ApiVersion.V_120;
    public static final String KEY_STORE_PASSWORD = "changeit";
    public static final String TRUST_STORE_PASSWORD = "changeit";
    public static final String HOSTNAME = "10.10.10.2";
    public static final String USERNAME = "administrator";
    public static final String PASSWORD = "admin";
}
