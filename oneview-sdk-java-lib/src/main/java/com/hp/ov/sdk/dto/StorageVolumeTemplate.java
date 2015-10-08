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

/**
 * The StorageVolumeTemplate data transfer object (DTO) contains the information
 * used to represent a storage volume template in the system. It is passed in to
 * the add/update storage volume template REST api, as well as the add/update
 * storage volume template through java client api.
 */

public class StorageVolumeTemplate extends BaseModelResource {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private TemplateProvisioningData provisioning;
    private RefreshState refreshState;
    private String stateReason;
    private String storageSystemUri;

    /**
     * 
     * @return The provisioning
     */
    public TemplateProvisioningData getProvisioning() {
        return provisioning;
    }

    /**
     * 
     * @param provisioning
     *            The provisioning
     */
    public void setProvisioning(final TemplateProvisioningData provisioning) {
        this.provisioning = provisioning;
    }

    /**
     * 
     * @return The refreshState
     */
    public RefreshState getRefreshState() {
        return refreshState;
    }

    /**
     * 
     * @param refreshState
     *            The refreshState
     */
    public void setRefreshState(final RefreshState refreshState) {
        this.refreshState = refreshState;
    }

    /**
     * 
     * @return The stateReason
     */
    public String getStateReason() {
        return stateReason;
    }

    /**
     * 
     * @param stateReason
     *            The stateReason
     */
    public void setStateReason(final String stateReason) {
        this.stateReason = stateReason;
    }

    /**
     * 
     * @return The storageSystemUri
     */
    public String getStorageSystemUri() {
        return storageSystemUri;
    }

    /**
     * 
     * @param storageSystemUri
     *            The storageSystemUri
     */
    public void setStorageSystemUri(final String storageSystemUri) {
        this.storageSystemUri = storageSystemUri;
    }

}
