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
package com.hp.ov.sdk.rest.client;

import com.hp.ov.sdk.dto.FwBaselineCollection;
import com.hp.ov.sdk.dto.TaskResourceV2;
import com.hp.ov.sdk.dto.generated.FwBaseline;
import com.hp.ov.sdk.rest.http.core.client.RestParams;

public interface FirmwareDriverClient {
    /**
     * The module aids in fetching the FirmwareDriver details for the specified
     * FirmwareDriver resourceId.
     * 
     * @param params
     *            The RestParams is a structure containing the connection
     *            details.
     * @param resourceId
     *            The resourceId for FirmwareDriver as seen in HP OneView.
     * @return FwBaselineDto, which is a object containing the FirmwareDriver
     *         details.
     */
    public FwBaseline getFirmwareDriver(final RestParams params, final String resourceId);

    /**
     * The module aids in fetching the FirmwareDriver details for all the
     * FirmwareDriver found under the current HP OneView.
     * 
     * @param params
     *            The RestParams is a structure containing the connection
     *            details.
     * @return FwBaselineCollectionDto, which is a object containing a
     *         collection of FirmwareDriver details.
     */
    public FwBaselineCollection getAllFirmwareDrivers(final RestParams params);

    /**
     * The module aids in fetching the FirmwareDriver details for the
     * FirmwareDriver name as specified in HP OneView.
     * 
     * @param params
     *            The RestParams is a structure containing the connection
     *            details.
     * @param firmwareName
     *            The firmwareName is the FirmwareDriver name as seen in HP
     *            OneView.
     * @return FwBaselineDto, which is a object containing the FirmwareDriver
     *         details.
     */
    public FwBaseline getFirmwareDriverByName(final RestParams params, final String firmwareName);

    /**
     * This module aids in deletion of the firmware baseline resource with the
     * specified id. If force is set to true, the firmware baseline resource
     * will be deleted even if it is assigned to devices
     * 
     * @param params
     *            The RestParams is a structure containing the connection
     *            details.
     * @param resourceId
     *            The resourceId for FirmwareDriver as seen in HP OneView.
     * @return TaskResourceV2,which returns the task status for the process
     */
    public TaskResourceV2 deleteFirmwareDriver(final RestParams params, final String resourceId, final Boolean isForce,
            final boolean aSync, final boolean useJsonRequest);

    /**
     * The module aids in fetching the firmware driver details for the firmware
     * driver name as specified in HP OneView.
     * 
     * @param creds
     *            The RestParams is a structure containing the connection
     *            details.
     * @param name
     *            The resourceName is the firmware driver name as seen in HP
     *            OneView.
     * @return String, which is a resource Id for the firmware driver name as
     *         seen in HPOneView.
     */
    public String getId(final RestParams creds, final String name);
}
