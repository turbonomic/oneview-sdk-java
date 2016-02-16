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

import com.hp.ov.sdk.adaptors.ServerHardwareAdaptor;
import com.hp.ov.sdk.adaptors.TaskAdaptor;
import com.hp.ov.sdk.constants.ResourceUris;
import com.hp.ov.sdk.constants.SdkConstants;
import com.hp.ov.sdk.dto.AddServer;
import com.hp.ov.sdk.dto.BiosSettingsStateCollection;
import com.hp.ov.sdk.dto.EnvironmentalConfigurationUpdate;
import com.hp.ov.sdk.dto.HttpMethodType;
import com.hp.ov.sdk.dto.IloSsoUrlResult;
import com.hp.ov.sdk.dto.JavaRemoteConsoleUrlResult;
import com.hp.ov.sdk.dto.RemoteConsoleUrlResult;
import com.hp.ov.sdk.dto.ServerHardwareCollection;
import com.hp.ov.sdk.dto.ServerPowerControlRequest;
import com.hp.ov.sdk.dto.TaskResourceV2;
import com.hp.ov.sdk.dto.UtilizationData;
import com.hp.ov.sdk.dto.generated.EnvironmentalConfiguration;
import com.hp.ov.sdk.dto.generated.ServerHardware;
import com.hp.ov.sdk.exceptions.SDKErrorEnum;
import com.hp.ov.sdk.exceptions.SDKInvalidArgumentException;
import com.hp.ov.sdk.exceptions.SDKNoResponseException;
import com.hp.ov.sdk.exceptions.SDKResourceNotFoundException;
import com.hp.ov.sdk.rest.http.core.client.HttpRestClient;
import com.hp.ov.sdk.rest.http.core.client.RestParams;
import com.hp.ov.sdk.tasks.TaskMonitorManager;
import com.hp.ov.sdk.util.UrlUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class ServerHardwareClientImpl implements ServerHardwareClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerHardwareClientImpl.class);
    private static final int TIMEOUT = 60000; // in milliseconds = 1 mins

    private final ServerHardwareAdaptor adaptor;
    private final TaskAdaptor taskAdaptor;
    private final TaskMonitorManager taskMonitor;

    private JSONObject jsonObject;

    protected ServerHardwareClientImpl(ServerHardwareAdaptor adaptor,
        TaskAdaptor taskAdaptor, TaskMonitorManager taskMonitor) {

        this.adaptor = adaptor;
        this.taskAdaptor = taskAdaptor;
        this.taskMonitor = taskMonitor;
    }

    public static ServerHardwareClient getClient() {
        return new ServerHardwareClientImpl(new ServerHardwareAdaptor(),
                TaskAdaptor.getInstance(),
                TaskMonitorManager.getInstance());
    }

    @Override
    public ServerHardware getServerHardware(final RestParams params, final String resourceId) {
        LOGGER.info("ServerHardwareClientImpl : getServerHardware : Start");

        // validate args
        if (null == params) {
            throw new SDKInvalidArgumentException(SDKErrorEnum.invalidArgument, null, null, null, SdkConstants.APPLIANCE, null);
        }
        // set the additional params
        params.setType(HttpMethodType.GET);
        params.setUrl(UrlUtils.createRestUrl(params.getHostname(), ResourceUris.SERVER_HARWARE_URI, resourceId));

        final String returnObj = HttpRestClient.sendRequestToHPOV(params);
        LOGGER.debug("ServerHardwareClient : getServerHardware : response from OV :" + returnObj);
        if (null == returnObj || returnObj.equals("")) {
            throw new SDKNoResponseException(SDKErrorEnum.noResponseFromAppliance, null, null, null, SdkConstants.SERVER_HARDWARE,
                    null);
        }
        // Call adaptor to convert to DTO
        final ServerHardware serverHardwareDto = adaptor.buildDto(returnObj);

        LOGGER.debug("ServerHardwareClient : getServerHardware : name :" + serverHardwareDto.getName());
        LOGGER.info("ServerHardwareClientImpl : getServerHardware : End");

        return serverHardwareDto;
    }

    @Override
    public ServerHardwareCollection getAllServerHardwares(final RestParams params) {
        LOGGER.info("ServerHardwareClientImpl : getAllServerHardwares : Start");
        // validate args
        if (null == params) {
            throw new SDKInvalidArgumentException(SDKErrorEnum.invalidArgument, null, null, null, SdkConstants.APPLIANCE, null);
        }
        // set the additional params
        params.setType(HttpMethodType.GET);
        params.setUrl(UrlUtils.createRestUrl(params.getHostname(), ResourceUris.SERVER_HARWARE_URI));

        // call rest client
        final String returnObj = HttpRestClient.sendRequestToHPOV(params);
        LOGGER.debug("ServerHardwareClientImpl : getAllServerHardwares : response from OV :" + returnObj);

        if (null == returnObj || returnObj.equals("")) {
            throw new SDKNoResponseException(SDKErrorEnum.noResponseFromAppliance, null, null, null, SdkConstants.SERVER_HARDWARES,
                    null);
        }
        // Call adaptor to convert to DTO

        final ServerHardwareCollection serverHardwareCollectionDto = adaptor.buildCollectionDto(returnObj);

        LOGGER.debug("ServerHardwareClientImpl : getAllServerHardwares : members count :" + serverHardwareCollectionDto.getCount());
        LOGGER.info("ServerHardwareClientImpl : getAllServerHardwares : End");

        return serverHardwareCollectionDto;
    }

    @Override
    public ServerHardwareCollection getServerHardwareWithNoProfile(final RestParams params) {

        LOGGER.info("ServerHardwareClientImpl : getServerHardwareWithNoProfile : Start");
        // validate args
        if (null == params) {
            throw new SDKInvalidArgumentException(SDKErrorEnum.invalidArgument, null, null, null, SdkConstants.APPLIANCE, null);
        }
        // set the additional params
        params.setType(HttpMethodType.GET);
        params.setUrl(UrlUtils.createRestUrl(params.getHostname(), ResourceUris.SERVER_HARWARE_URI));

        // call rest client
        final String returnObj = HttpRestClient.sendRequestToHPOV(params);
        LOGGER.debug("ServerHardwareClientImpl : getServerHardwareWithNoProfile : response from OV :" + returnObj);

        if (null == returnObj || returnObj.equals("")) {
            throw new SDKNoResponseException(SDKErrorEnum.noResponseFromAppliance, null, null, null, SdkConstants.SERVER_HARDWARES,
                    null);
        }
        // Call adaptor to convert to DTO

        final ServerHardwareCollection serverHardwareCollectionDto = adaptor.buildCollectionDto(returnObj);
        LOGGER.debug("ServerHardwareClientImpl : getServerHardwareWithNoProfile : members count :"
                + serverHardwareCollectionDto.getCount());
        final List<ServerHardware> tempServerHardwareCollectionDto = serverHardwareCollectionDto.getMembers();
        for (final ServerHardware serverHardwareDto : new ArrayList<>(serverHardwareCollectionDto.getMembers())) {
            if (serverHardwareDto.getServerProfileUri() != null && !serverHardwareDto.getServerProfileUri().isEmpty()) {
                tempServerHardwareCollectionDto.remove(serverHardwareDto);
            }
        }
        serverHardwareCollectionDto.setMembers(tempServerHardwareCollectionDto);
        LOGGER.debug("ServerHardwareClientImpl : getServerHardwareWithNoProfile : members count :"
                + serverHardwareCollectionDto.getCount());
        LOGGER.info("ServerHardwareClientImpl : getServerHardwareWithNoProfile : End");

        return serverHardwareCollectionDto;
    }

    @Override
    public ServerHardware getServerHardwareByName(final RestParams params, final String destinationBay) {

        LOGGER.info("ServerHardwareClientImpl : getServerHardwareByName : start");
        final ServerHardwareCollection serverHardwareCollectionDto = getAllServerHardwares(params);

        for (final ServerHardware serverHardwareDto : new ArrayList<>(serverHardwareCollectionDto.getMembers())) {
            if (serverHardwareDto.getName().equals(destinationBay)) {
                System.out.println(serverHardwareDto.getName());
                LOGGER.info("ServerHardwareClientImpl : getServerHardwareByName : End");
                return serverHardwareDto;
            }
        }
        LOGGER.error("ServerHardwareClientImpl : getServerHardwareByName : resource not Found for name :" + destinationBay);
        throw new SDKResourceNotFoundException(SDKErrorEnum.resourceNotFound, null, null, null, SdkConstants.SERVER_HARDWARE, null);
    }

    @Override
    public TaskResourceV2 powerServer(final RestParams params, final String resourceId,
            final ServerPowerControlRequest serverPowerControlRequestDto, final boolean aSync, final boolean useJsonRequest) {
        // create ServerPowerControlRequest
        LOGGER.info("ServerHardwareClientImpl : powerServer : Start");
        String returnObj = null;

        // validate params
        if (serverPowerControlRequestDto == null) {
            throw new SDKInvalidArgumentException(SDKErrorEnum.invalidArgument, null, null, null, SdkConstants.POWERSTATE, null);
        }
        // set the additional params
        params.setType(HttpMethodType.PUT);
        params.setUrl(UrlUtils.createRestUrl(params.getHostname(), ResourceUris.SERVER_HARWARE_URI, resourceId,
                ResourceUris.POWER_STATE_URI));

        // TODO - check for json request in the input dto. if it is present,
        // then
        // convert that into jsonObject and pass it rest client
        // idea is : user can create json string and call the sdk api.
        // user can save time in creating network dto.

        // create JSON request from dto
        jsonObject = adaptor.buildJsonObjectFromDto(serverPowerControlRequestDto);
        returnObj = HttpRestClient.sendRequestToHPOV(params, jsonObject);
        // convert returnObj to taskResource
        TaskResourceV2 taskResourceV2 = taskAdaptor.buildDto(returnObj);

        LOGGER.debug("ServerHardwareClientImpl : powerServer : returnObj =" + returnObj);
        LOGGER.debug("ServerHardwareClientImpl : powerServer : taskResource =" + taskResourceV2);

        // check for aSync flag. if user is asking async mode, return directly
        // the TaskResourceV2
        // if user is asking for sync mode, call task monitor polling method and
        // send the update
        // once task is complete or exceeds the timeout.
        if (taskResourceV2 != null && aSync == false) {
            taskResourceV2 = taskMonitor.checkStatus(params, taskResourceV2.getUri(), TIMEOUT);
        }
        LOGGER.info("ServerHardwareClientImpl : powerServer : End");

        return taskResourceV2;
    }

    @Override
    public String getPowerState(final RestParams params, final String resourceId) {
        LOGGER.info("ServerHardwareClientImpl : getPowerState : start");
        final ServerHardware serverHardwareDto = getServerHardware(params, resourceId);

        LOGGER.info("ServerHardwareClientImpl : getPowerState : End");
        return serverHardwareDto.getPowerState().toString();
    }

    @Override
    public TaskResourceV2 createServerHardware(RestParams params, AddServer addServerDto, final boolean aSync,
            final boolean useJsonRequest) {
        LOGGER.info("ServerHardwareClientImpl : createServerHardware : Start");
        String returnObj = null;

        // validate params
        if (addServerDto == null) {
            throw new SDKInvalidArgumentException(SDKErrorEnum.invalidArgument, null, null, null, SdkConstants.SERVER_HARDWARES,
                    null);
        }
        // set the additional params
        params.setType(HttpMethodType.POST);
        params.setUrl(UrlUtils.createRestUrl(params.getHostname(), ResourceUris.SERVER_HARWARE_URI));

        // TODO - check for json request in the input dto. if it is present,
        // then
        // convert that into jsonObject and pass it rest client
        // idea is : user can create json string and call the sdk api.
        // user can save time in creating network dto.

        // create JSON request from dto
        jsonObject = adaptor.buildJsonObjectFromDto(addServerDto);
        returnObj = HttpRestClient.sendRequestToHPOV(params, jsonObject);
        // convert returnObj to taskResource
        TaskResourceV2 taskResourceV2 = taskAdaptor.buildDto(returnObj);

        LOGGER.debug("ServerHardwareClientImpl : createServerHardware : returnObj =" + returnObj);
        LOGGER.debug("ServerHardwareClientImpl : createServerHardware : taskResource =" + taskResourceV2);

        // check for aSync flag. if user is asking async mode, return directly
        // the TaskResourceV2
        // if user is asking for sync mode, call task monitor polling method and
        // send the update
        // once task is complete or exceeds the timeout.
        if (taskResourceV2 != null && aSync == false) {
            taskResourceV2 = taskMonitor.checkStatus(params, taskResourceV2.getUri(), TIMEOUT);
        }
        LOGGER.info("ServerHardwareClientImpl : createServerHardware : End");

        return taskResourceV2;
    }

    @Override
    public BiosSettingsStateCollection getBiosForServerHardware(RestParams params, String resourceId) {
        LOGGER.info("ServerHardwareClientImpl : getBiosForServerHardware : Start");

        // validate args
        if (null == params) {
            throw new SDKInvalidArgumentException(SDKErrorEnum.invalidArgument, null, null, null, SdkConstants.APPLIANCE, null);
        }
        // set the additional params
        params.setType(HttpMethodType.GET);
        params.setUrl(UrlUtils.createRestUrl(params.getHostname(), ResourceUris.SERVER_HARWARE_URI, resourceId, SdkConstants.BIOS));

        final String returnObj = HttpRestClient.sendRequestToHPOV(params);
        LOGGER.debug("ServerHardwareClient : getBiosForServerHardware : response from OV :" + returnObj);
        if (null == returnObj || returnObj.equals("")) {
            throw new SDKNoResponseException(SDKErrorEnum.noResponseFromAppliance, null, null, null, SdkConstants.SERVER_HARDWARE,
                    null);
        }
        // Call adaptor to convert to DTO
        final BiosSettingsStateCollection biosSettingsStateCollectionDto = adaptor.buildBiosCollectionDto(returnObj);

        LOGGER.info("ServerHardwareClientImpl : getBiosForServerHardware : End");

        return biosSettingsStateCollectionDto;
    }

    @Override
    public String getId(final RestParams creds, final String name) {
        String resourceId = "";
        // fetch resource Id using resource name
        ServerHardware serverHardwareDto = getServerHardwareByName(creds, name);

        if (null != serverHardwareDto.getUri()) {
            resourceId = UrlUtils.getResourceIdFromUri(serverHardwareDto.getUri());
        }
        return resourceId;
    }

    // TODO
    @Override
    public EnvironmentalConfiguration getEnvironmentConfigurationForServerHardware(RestParams params, String resourceId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    // TODO
    @Override
    public EnvironmentalConfiguration updateEnvironmentConfigurationForServerHardware(RestParams params, String resourceId,
            EnvironmentalConfigurationUpdate environmentalConfigurationUpdateDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    // TODO
    @Override
    public IloSsoUrlResult getIloSsoUrlForServerHardware(RestParams params, String resourceId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    // TODO
    @Override
    public JavaRemoteConsoleUrlResult getJavaRemoteConsoleUrlForServerHardware(RestParams params, String resourceId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    // TODO
    @Override
    public TaskResourceV2 updateMpFirmwareVersionForServerHardware(RestParams params, String resourceId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    // TODO
    @Override
    public RemoteConsoleUrlResult getRemoteConsoleUrlForServerHardware(RestParams params, String resourceId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

    // TODO
    @Override
    public UtilizationData getUtilizationForServerHardware(RestParams params, String resourceId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }

}
