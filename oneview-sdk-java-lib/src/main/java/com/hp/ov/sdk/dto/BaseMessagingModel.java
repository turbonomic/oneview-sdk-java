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
package com.hp.ov.sdk.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseMessagingModel implements Serializable {

    /**
	 *
	 */
    private static final long serialVersionUID = 1L;

    private String data;
    private String eTag;
    private String resourceUri;
    private String changeType;
    private String newState;
    private String associatedTask;
    private String userInitiatedTask;
    private List<String> changedAttributes = new ArrayList<String>();
    private String newSubState;
    private String timestamp;
    private String uri;

    public String getData() {
        return data;
    }

    public void setData(final String data) {
        this.data = data;
    }

    public String geteTag() {
        return eTag;
    }

    public void seteTag(final String eTag) {
        this.eTag = eTag;
    }

    public String getResourceUri() {
        return resourceUri;
    }

    public void setResourceUri(final String resourceUri) {
        this.resourceUri = resourceUri;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(final String changeType) {
        this.changeType = changeType;
    }

    public String getNewState() {
        return newState;
    }

    public void setNewState(final String newState) {
        this.newState = newState;
    }

    public String getAssociatedTask() {
        return associatedTask;
    }

    public void setAssociatedTask(final String associatedTask) {
        this.associatedTask = associatedTask;
    }

    public String getUserInitiatedTask() {
        return userInitiatedTask;
    }

    public void setUserInitiatedTask(final String userInitiatedTask) {
        this.userInitiatedTask = userInitiatedTask;
    }

    public List<String> getChangedAttributes() {
        return changedAttributes;
    }

    public void setChangedAttributes(final List<String> changedAttributes) {
        this.changedAttributes = changedAttributes;
    }

    public String getNewSubState() {
        return newSubState;
    }

    public void setNewSubState(final String newSubState) {
        this.newSubState = newSubState;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(final String uri) {
        this.uri = uri;
    }

}
