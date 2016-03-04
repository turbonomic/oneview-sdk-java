/*******************************************************************************
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
 *******************************************************************************/
package com.hp.ov.sdk.rest.client;

import com.hp.ov.sdk.dto.AddStorageVolumeV2;
import com.hp.ov.sdk.dto.AttachableStorageVolumeCollection;
import com.hp.ov.sdk.dto.ExtraStorageVolumeCollection;
import com.hp.ov.sdk.dto.ExtraStorageVolumeRepair;
import com.hp.ov.sdk.dto.StorageVolumeCollection;
import com.hp.ov.sdk.dto.StorageVolumeSnapshot;
import com.hp.ov.sdk.dto.StorageVolumeSnapshotCollection;
import com.hp.ov.sdk.dto.StorageVolumeV2;
import com.hp.ov.sdk.dto.TaskResourceV2;
import com.hp.ov.sdk.rest.http.core.client.RestParams;

public interface StorageVolumeClient {

    String REPAIR_FILTER = "alertFixType=ExtraManagedStorageVolumePaths";

    /**
     * The module aids in fetching the StorageVolume details for the specified
     * StorageVolume resourceId.
     * 
     * @param params
     *            The RestParams is a structure containing the connection
     *            details.
     * @param resourceId
     *            The resourceId for StorageVolume as seen in HP OneView.
     * @return storageVolumeDto, which is a object containing the StorageVolume
     *         details.
     */
    StorageVolumeV2 getStorageVolume(final RestParams params, final String resourceId);

    /**
     * The module aids in fetching the StorageVolume details for all the
     * StorageVolume found under the current HP OneView.
     * 
     * @param params
     *            The RestParams is a structure containing the connection
     *            details.
     * @return storageVolumeCollectionDto, which is a object containing a
     *         collection of StorageVolume details.
     */
    StorageVolumeCollection getAllStorageVolumes(final RestParams params);

    /**
     * The module aids in fetching the StorageVolume details for the
     * StorageVolume name as specified in HP OneView.
     * 
     * @param params
     *            The RestParams is a structure containing the connection
     *            details.
     * @param name
     *            The name is the StorageVolume name as seen in HP OneView.
     * @return storageVolumeDto, which is a object containing the StorageVolume
     *         details.
     */
    StorageVolumeV2 getStorageVolumeByName(final RestParams params, final String name);

    /**
     * The module aids in creation of StorageVolume when provided with the
     * StorageVolume details as AddStorageVolume object or JsonRequest.It can
     * process the request asynchronously or synchronously based on flag input.
     * 
     * @param params
     *            The RestParams is a structure containing the connection
     *            details.
     * @param addStorageVolumeDto
     *            This is a object containing the StorageVolume details, used to
     *            create a StorageVolume.
     * @param aSync
     *            Flag input to process request asynchronously or synchronously.
     * @param useJsonRequest
     *            The JsonRequest body is part of StorageVolume Object which
     *            takes in a String containing new StorageVolume details, which
     *            is converted to StorageVolume Object using adaptor and
     *            processed.
     * @return taskResource which returns the task status for the process
     */
    TaskResourceV2 createStorageVolume(final RestParams params, final AddStorageVolumeV2 addStorageVolumeDto,
            final boolean aSync, final boolean useJsonRequest);

    /**
     * The module takes in an StorageVolume object or JsonRequest and updates
     * the existing StorageVolume based on resource Id.
     * 
     * @param params
     *            The RestParams is a structure containing the connection
     *            details.
     * @param resourceId
     *            The resourceId for StorageVolume as seen in HP OneView.
     * @param storageVolumeDto
     *            This is a object containing the StorageVolume details, used to
     *            update a StorageVolume.
     * @param useJsonRequest
     *            The JsonRequest body is part of StorageVolume Object which
     *            takes in a String containing the update to be made, which is
     *            converted to StorageVolume Object using adaptor and processed.
     * @return String, is Updated if successful.
     */
    String updateStorageVolume(final RestParams params, final String resourceId, final StorageVolumeV2 storageVolumeDto,
            final boolean useJsonRequest);

    /**
     * The module aids in deleting a StorageVolume for the specified
     * StorageVolume resourceId.It can process the request asynchronously or
     * synchronously based on flag input.
     * 
     * @param params
     *            The RestParams is a structure containing the connection
     *            details.
     * @param resourceId
     *            The resourceId for StorageVolume as seen in HP OneView.
     * @param aSync
     *            Flag input to process request asynchronously or synchronously.
     * @return taskResource which returns the task status for the process
     */
    TaskResourceV2 deleteStorageVolume(final RestParams params, final String resourceId, final boolean aSync);

    /**
     * This method aids in fetching the volumes that are connected on the
     * specified networks based on the storage system port's expected network
     * connectivity.
     * 
     * @param params
     *            The RestParams is a structure containing the connection
     *            details.
     * @return attachableStorageVolumeCollection, volume object that are
     *         attached to storage system.
     */
    AttachableStorageVolumeCollection getAttachableVolumes(final RestParams params);

    /**
     * Gets a snapshot of a volume.
     *
     * @param params structure containing the connection details.
     * @param storageVolumeId resourceId for storage volume as seen in HP OneView.
     * @param snapshotId resourceId for the snapshot of the storage volume.
     *
     * @return a {@link StorageVolumeSnapshot} or null in case the parameter snapshotId
     * does not match any existing snapshot.
     */
    StorageVolumeSnapshot getStorageVolumeSnapshot(RestParams params, String storageVolumeId, String snapshotId);

    /**
     * Gets all snapshots of a volume.
     *
     * @param params structure containing the connection details.
     * @param storageVolumeId resourceId for storage volume as seen in HP OneView.
     *
     * @return a {@link StorageVolumeSnapshotCollection} containing all snapshots for
     * a storage volume.
     */
    StorageVolumeSnapshotCollection getAllStorageVolumeSnapshots(RestParams params, String storageVolumeId);

    /**
     * Creates a snapshot for the volume specified.
     *
     * @param params structure containing the connection details.
     * @param storageVolumeId resourceId for storage volume as seen in HP OneView.
     * @param snapshot {@link StorageVolumeSnapshot} object containing the data to be used during
     * the snapshot creation.
     * @param aSync flag input to process request asynchronously or synchronously.
     *
     * @return {@link TaskResourceV2} which returns the task status for the process.
     */
    TaskResourceV2 createStorageVolumeSnapshot(RestParams params, String storageVolumeId,
            StorageVolumeSnapshot snapshot, boolean aSync);

    /**
     * Deletes a snapshot from OneView and storage system.
     *
     * @param params structure containing the connection details.
     * @param storageVolumeId resourceId for storage volume as seen in HP OneView.
     * @param snapshotId resourceId for the snapshot of the storage volume.
     * @param aSync flag input to process request asynchronously or synchronously.
     *
     * @return {@link TaskResourceV2} which returns the task status for the process.
     */
    TaskResourceV2 deleteStorageVolumeSnapshot(RestParams params, String storageVolumeId,
            String snapshotId, boolean aSync);

    /**
     * Gets the list of extra managed storage volume paths.
     *
     * @param params structure containing the connection details.
     *
     * @return {@link ExtraStorageVolumeCollection} containing the resources found.
     */
    ExtraStorageVolumeCollection getExtraManagedStorageVolumePaths(RestParams params);

    /**
     * Removes extra presentations from a specified volume on the storage system.
     *
     * @param params structure containing the connection details.
     * @param repair information about the extra paths to delete.
     * @param aSync flag input to process request asynchronously or synchronously.
     *
     * @return {@link TaskResourceV2} which returns the task status for the process.
     */
    TaskResourceV2 repairExtraManagedStorageVolumePath(RestParams params,
            ExtraStorageVolumeRepair repair, boolean aSync);

    /**
     * The module aids in fetching the StorageVolume details for the
     * StorageVolume name as specified in HP OneView.
     * 
     * @param params
     *            The RestParams is a structure containing the connection
     *            details.
     * @param name
     *            The resourceName is the StorageVolume name as seen in HP
     *            OneView.
     * @return String, which is a resource Id for the StorageVolume name as seen
     *         in HPOneView.
     */
    String getId(final RestParams params, final String name);
}
