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
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.google.gson.annotations.Since;
import com.hp.ov.sdk.dto.DevicePresence;

public class FanBay implements Serializable {

    /**
	 *
	 */
    private static final long serialVersionUID = 1L;
    private Integer bayNumber;
    @Since(200)
    private String changeState;
    private DevicePresence devicePresence;
    private Boolean deviceRequired;
    private Boolean forceInstallFirmware;
    private FanBay.Status status;
    private FanBay.State state;
    private String model;
    private String partNumber;
    private String sparePartNumber;

    /**
     *
     *@return The bayNumber
     */
    public Integer getBayNumber() {
        return bayNumber;
    }

    /**
     *
     *@param bayNumber
     *           The bayNumber
     */
    public void setBayNumber(final Integer bayNumber) {
        this.bayNumber = bayNumber;
    }

    /**
     *
     *@return The changeState
     */
    public String getChangeState() {
        return changeState;
    }

    /**
     *
     *@param changeState
     *           The changeState
     */
    public void setChangeState(final String changeState) {
        this.changeState = changeState;
    }

    /**
     *
     *@return The devicePresence
     */
    public DevicePresence getDevicePresence() {
        return devicePresence;
    }

    /**
     *
     *@param devicePresence
     *           The devicePresence
     */
    public void setDevicePresence(final DevicePresence devicePresence) {
        this.devicePresence = devicePresence;
    }

    /**
     *
     *@return The deviceRequired
     */
    public Boolean getDeviceRequired() {
        return deviceRequired;
    }

    /**
     *
     *@param deviceRequired
     *           The deviceRequired
     */
    public void setDeviceRequired(final Boolean deviceRequired) {
        this.deviceRequired = deviceRequired;
    }

    /**
     *
     *@return The forceInstallFirmware
     */
    public Boolean getForceInstallFirmware() {
        return forceInstallFirmware;
    }

    /**
     *
     *@param forceInstallFirmware
     *           The forceInstallFirmware
     */
    public void setForceInstallFirmware(final Boolean forceInstallFirmware) {
        this.forceInstallFirmware = forceInstallFirmware;
    }

    /**
     *
     *@return The status
     */
    public FanBay.Status getStatus() {
        return status;
    }

    /**
     *
     *@param status
     *           The status
     */
    public void setStatus(final FanBay.Status status) {
        this.status = status;
    }

    /**
     *
     *@return The state
     */
    public FanBay.State getState() {
        return state;
    }

    /**
     *
     *@param state
     *           The state
     */
    public void setState(final FanBay.State state) {
        this.state = state;
    }

    /**
     *
     *@return The model
     */
    public String getModel() {
        return model;
    }

    /**
     *
     *@param model
     *           The model
     */
    public void setModel(final String model) {
        this.model = model;
    }

    /**
     *
     *@return The partNumber
     */
    public String getPartNumber() {
        return partNumber;
    }

    /**
     *
     *@param partNumber
     *           The partNumber
     */
    public void setPartNumber(final String partNumber) {
        this.partNumber = partNumber;
    }

    /**
     *
     *@return The sparePartNumber
     */
    public String getSparePartNumber() {
        return sparePartNumber;
    }

    /**
     *
     *@param sparePartNumber
     *           The sparePartNumber
     */
    public void setSparePartNumber(final String sparePartNumber) {
        this.sparePartNumber = sparePartNumber;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(bayNumber)
                .append(changeState)
                .append(devicePresence)
                .append(deviceRequired)
                .append(forceInstallFirmware)
                .append(status)
                .append(state)
                .append(model)
                .append(partNumber)
                .append(sparePartNumber)
                .toHashCode();
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FanBay) == false) {
            return false;
        }
        final FanBay rhs = ((FanBay) other);
        return new EqualsBuilder()
                .append(bayNumber, rhs.bayNumber)
                .append(changeState, rhs.changeState)
                .append(devicePresence, rhs.devicePresence)
                .append(deviceRequired, rhs.deviceRequired)
                .append(forceInstallFirmware, rhs.forceInstallFirmware)
                .append(status, rhs.status)
                .append(state, rhs.state)
                .append(model, rhs.model)
                .append(partNumber, rhs.partNumber)
                .append(sparePartNumber, rhs.sparePartNumber)
                .isEquals();
    }

    public static enum State {

        Misplaced("Misplaced"), Missing("Missing"), Degraded("Degraded"), Failed("Failed"), OK("OK");
        private final String value;
        private static Map<String, FanBay.State> constants = new HashMap<String, FanBay.State>();

        static {
            for (final FanBay.State c : values()) {
                constants.put(c.value, c);
            }
        }

        private State(final String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public static FanBay.State fromValue(final String value) {
            final FanBay.State constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public static enum Status {

        Unknown("Unknown"), OK("OK"), Disabled("Disabled"), Warning("Warning"), Critical("Critical");
        private final String value;
        private static Map<String, FanBay.Status> constants = new HashMap<String, FanBay.Status>();

        static {
            for (final FanBay.Status c : values()) {
                constants.put(c.value, c);
            }
        }

        private Status(final String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public static FanBay.Status fromValue(final String value) {
            final FanBay.Status constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
