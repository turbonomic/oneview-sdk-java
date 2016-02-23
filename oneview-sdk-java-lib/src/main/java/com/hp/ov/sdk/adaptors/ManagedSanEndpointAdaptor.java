/*******************************************************************************
 * (C) Copyright 2016 Hewlett Packard Enterprise Development LP
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
package com.hp.ov.sdk.adaptors;

import com.hp.ov.sdk.dto.EndpointResponse;
import com.hp.ov.sdk.dto.EndpointResponseCollection;
import com.hp.ov.sdk.rest.client.EndpointsCsvFileResponse;
import com.hp.ov.sdk.util.ObjectToJsonConverter;
import com.hp.ov.sdk.util.StringUtil;

public class ManagedSanEndpointAdaptor extends BaseAdaptor<EndpointResponse, String> {

    @Override
    public EndpointResponse buildDto(String source) {
        ObjectToJsonConverter converter = ObjectToJsonConverter.getInstance();

        return converter.convertJsonToObject(
                StringUtil.replaceQuotesAndBackSlash(converter.convertObjectToJsonString(source)),
                EndpointResponse.class);
    }

    public EndpointResponseCollection buildCollectionDto(Object source) {
        ObjectToJsonConverter converter = ObjectToJsonConverter.getInstance();

        return converter.convertJsonToObject(
                StringUtil.replaceQuotesAndBackSlash(converter.convertObjectToJsonString(source)),
                EndpointResponseCollection.class);
    }

    public EndpointsCsvFileResponse buildEndpointCsvFileResponse(String source) {
        ObjectToJsonConverter converter = ObjectToJsonConverter.getInstance();

        return converter.convertJsonToObject(
                StringUtil.replaceQuotesAndBackSlash(converter.convertObjectToJsonString(source)),
                EndpointsCsvFileResponse.class);
    }

}
