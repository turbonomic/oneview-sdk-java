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
package com.hp.ov.sdk.dto.generated;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "logicalDrives", "manageLocalStorage", "initialize" })
public class LocalStorage implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    @JsonProperty("logicalDrives")
    private List<LogicalDrife> logicalDrives = new ArrayList<LogicalDrife>();
    @JsonProperty("manageLocalStorage")
    private Boolean manageLocalStorage;
    @JsonProperty("initialize")
    private Boolean initialize;

    /**
     * 
     * @return The logicalDrives
     */
    @JsonProperty("logicalDrives")
    public List<LogicalDrife> getLogicalDrives() {
        return logicalDrives;
    }

    /**
     * 
     * @param logicalDrives
     *            The logicalDrives
     */
    @JsonProperty("logicalDrives")
    public void setLogicalDrives(final List<LogicalDrife> logicalDrives) {
        this.logicalDrives = logicalDrives;
    }

    /**
     * 
     * @return The manageLocalStorage
     */
    @JsonProperty("manageLocalStorage")
    public Boolean getManageLocalStorage() {
        return manageLocalStorage;
    }

    /**
     * 
     * @param manageLocalStorage
     *            The manageLocalStorage
     */
    @JsonProperty("manageLocalStorage")
    public void setManageLocalStorage(final Boolean manageLocalStorage) {
        this.manageLocalStorage = manageLocalStorage;
    }

    /**
     * 
     * @return The initialize
     */
    @JsonProperty("initialize")
    public Boolean getInitialize() {
        return initialize;
    }

    /**
     * 
     * @param initialize
     *            The initialize
     */
    @JsonProperty("initialize")
    public void setInitialize(final Boolean initialize) {
        this.initialize = initialize;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(logicalDrives).append(manageLocalStorage).append(initialize).toHashCode();
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LocalStorage) == false) {
            return false;
        }
        final LocalStorage rhs = ((LocalStorage) other);
        return new EqualsBuilder().append(logicalDrives, rhs.logicalDrives).append(manageLocalStorage, rhs.manageLocalStorage)
                .append(initialize, rhs.initialize).isEquals();
    }

}
