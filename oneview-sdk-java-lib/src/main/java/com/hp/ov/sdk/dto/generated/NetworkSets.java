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
package com.hp.ov.sdk.dto.generated;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * The NetworkSet data transfer object (DTO) contains the information used to to
 * represent a collection of network that represents a network set in the
 * system. It is passed in to the add/update networkSet REST api, as well as the
 * add/update networkSet through java client api.
 */
public class NetworkSets implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     * (Required)
     *
     */
    private List<String> networkUris = new ArrayList<String>();
    /**
     *
     * (Required)
     *
     */
    private String connectionTemplateUri;
    private String nativeNetworkUri;
    private String description;
    private String status;
    private String name;
    private String state;
    private String eTag;
    private String created;
    private String modified;
    private String category;
    private String uri;
    private String type;

    /**
     *
     * (Required)
     *
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * (Required)
     *
     * @param type
     *            The type
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     *
     * (Required)
     *
     * @return The networkUris
     */
    public List<String> getNetworkUris() {
        return networkUris;
    }

    /**
     *
     * (Required)
     *
     * @param networkUris
     *            The networkUris
     */
    public void setNetworkUris(final List<String> networkUris) {
        this.networkUris = networkUris;
    }

    /**
     *
     * (Required)
     *
     * @return The connectionTemplateUri
     */
    public String getConnectionTemplateUri() {
        return connectionTemplateUri;
    }

    /**
     *
     * (Required)
     *
     * @param connectionTemplateUri
     *            The connectionTemplateUri
     */
    public void setConnectionTemplateUri(final String connectionTemplateUri) {
        this.connectionTemplateUri = connectionTemplateUri;
    }

    /**
     *
     * @return The nativeNetworkUri
     */
    public String getNativeNetworkUri() {
        return nativeNetworkUri;
    }

    /**
     *
     * @param nativeNetworkUri
     *            The nativeNetworkUri
     */
    public void setNativeNetworkUri(final String nativeNetworkUri) {
        this.nativeNetworkUri = nativeNetworkUri;
    }

    /**
     *
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     *            The description
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     *
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     *            The status
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     *
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     *            The name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     *
     * @return The state
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     *            The state
     */
    public void setState(final String state) {
        this.state = state;
    }

    /**
     *
     * @return The eTag
     */
    public String getETag() {
        return eTag;
    }

    /**
     *
     * @param eTag
     *            The eTag
     */
    public void setETag(final String eTag) {
        this.eTag = eTag;
    }

    /**
     *
     * @return The created
     */
    public String getCreated() {
        return created;
    }

    /**
     *
     * @param created
     *            The created
     */
    public void setCreated(final String created) {
        this.created = created;
    }

    /**
     *
     * @return The modified
     */
    public String getModified() {
        return modified;
    }

    /**
     *
     * @param modified
     *            The modified
     */
    public void setModified(final String modified) {
        this.modified = modified;
    }

    /**
     *
     * @return The category
     */
    public String getCategory() {
        return category;
    }

    /**
     *
     * @param category
     *            The category
     */
    public void setCategory(final String category) {
        this.category = category;
    }

    /**
     *
     * @return The uri
     */
    public String getUri() {
        return uri;
    }

    /**
     *
     * @param uri
     *            The uri
     */
    public void setUri(final String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(type).append(networkUris).append(connectionTemplateUri).append(nativeNetworkUri)
                .append(description).append(status).append(name).append(state).append(eTag).append(created).append(modified)
                .append(category).append(uri).toHashCode();
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NetworkSets) == false) {
            return false;
        }
        final NetworkSets rhs = ((NetworkSets) other);
        return new EqualsBuilder().append(type, rhs.type).append(networkUris, rhs.networkUris)
                .append(connectionTemplateUri, rhs.connectionTemplateUri).append(nativeNetworkUri, rhs.nativeNetworkUri)
                .append(description, rhs.description).append(status, rhs.status).append(name, rhs.name).append(state, rhs.state)
                .append(eTag, rhs.eTag).append(created, rhs.created).append(modified, rhs.modified).append(category, rhs.category)
                .append(uri, rhs.uri).isEquals();
    }

}
