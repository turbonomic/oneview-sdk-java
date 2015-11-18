/*******************************************************************************
 * (C) Copyright 2015 Hewlett Packard Enterprise Development LP
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
 *******************************************************************************/
package com.hp.ov.sdk.scmb.consumer;

import com.hp.ov.sdk.dto.samples.ScmbMessage;

public class ServerAlertsConsumer implements ServerHardwareListener {
    @Override
    public void notifyPowerStatus(final ScmbMessage message) {
        // TODO - consumer logic
        if (message.getSeverity().equals("OK")) {
            System.out.println("ServerAlertsConsumer: notifyPowerStatus : Health is good ");
        } else {
            System.out.println("ServerAlertsConsumer: notifyPowerStatus : Health is not good ");
        }
        System.out.println("ServerAlertsConsumer: notifyPowerStatus : resouce Name = " + message.getResourceName());
        System.out.println("ServerAlertsConsumer: notifyPowerStatus : severity = " + message.getSeverity());
        // TODO - other consumer logic
    }

    @Override
    public void notifyHealthStatus(final ScmbMessage message) {
        // TODO consumer logic
        if (message.getSeverity().equals("OK")) {
            System.out.println("ServerAlertsConsumer: notifyHealthStatus : Health is good ");
        } else {
            System.out.println("ServerAlertsConsumer: notifyHealthStatus : Health is not good ");
        }
        System.out.println("ServerAlertsConsumer: notifyHealthStatus : resouce Name = " + message.getResourceName());
        System.out.println("ServerAlertsConsumer: notifyHealthStatus : severity = " + message.getSeverity());
        // TODO - other consumer logic

    }

}