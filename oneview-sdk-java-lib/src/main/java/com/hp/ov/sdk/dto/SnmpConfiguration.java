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
package com.hp.ov.sdk.dto;

import java.util.ArrayList;
import java.util.List;

public class SnmpConfiguration extends BaseModelResource {
    private static final long serialVersionUID = 1L;

    private Boolean enabled;
    private String readCommunity;
    private List<String> snmpAccess = new ArrayList<String>();
    private String systemContact;
    private List<TrapDestination> trapDestinations = new ArrayList<TrapDestination>();

    /**
     * @return the enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * @param enabled
     *            the enabled to set
     */
    public void setEnabled(final Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return the readCommunity
     */
    public String getReadCommunity() {
        return readCommunity;
    }

    /**
     * @param readCommunity
     *            the readCommunity to set
     */
    public void setReadCommunity(final String readCommunity) {
        this.readCommunity = readCommunity;
    }

    /**
     * @return the snmpAccess
     */
    public List<String> getSnmpAccess() {
        return snmpAccess;
    }

    /**
     * @param snmpAccess
     *            the snmpAccess to set
     */
    public void setSnmpAccess(final List<String> snmpAccess) {
        this.snmpAccess = snmpAccess;
    }

    /**
     * @return the systemContact
     */
    public String getSystemContact() {
        return systemContact;
    }

    /**
     * @param systemContact
     *            the systemContact to set
     */
    public void setSystemContact(final String systemContact) {
        this.systemContact = systemContact;
    }

    /**
     * @return the trapDestinations
     */
    public List<TrapDestination> getTrapDestinations() {
        return trapDestinations;
    }

    /**
     * @param trapDestinations
     *            the trapDestinations to set
     */
    public void setTrapDestinations(final List<TrapDestination> trapDestinations) {
        this.trapDestinations = trapDestinations;
    }

}
