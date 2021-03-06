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
package com.hp.ov.sdk.dto;

import java.io.Serializable;

public class LogicalDrive implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean bootable;
    private String driveName;
    private Integer driveNumber;
    private String driveTechnology;
    private Integer numPhysicalDrives;
    private String raidLevel;

    /**
     * @return the bootable
     */
    public boolean isBootable() {
        return bootable;
    }
    /**
     * @param bootable the bootable to set
     */
    public void setBootable(boolean bootable) {
        this.bootable = bootable;
    }
    /**
     * @return the driveName
     */
    public String getDriveName() {
        return driveName;
    }
    /**
     * @param driveName the driveName to set
     */
    public void setDriveName(String driveName) {
        this.driveName = driveName;
    }
    /**
     * @return the driveNumber
     */
    public Integer getDriveNumber() {
        return driveNumber;
    }
    /**
     * @param driveNumber the driveNumber to set
     */
    public void setDriveNumber(Integer driveNumber) {
        this.driveNumber = driveNumber;
    }
    /**
     * @return the driveTechnology
     */
    public String getDriveTechnology() {
        return driveTechnology;
    }
    /**
     * @param driveTechnology the driveTechnology to set
     */
    public void setDriveTechnology(String driveTechnology) {
        this.driveTechnology = driveTechnology;
    }
    /**
     * @return the numPhysicalDrives
     */
    public Integer getNumPhysicalDrives() {
        return numPhysicalDrives;
    }
    /**
     * @param numPhysicalDrives the numPhysicalDrives to set
     */
    public void setNumPhysicalDrives(Integer numPhysicalDrives) {
        this.numPhysicalDrives = numPhysicalDrives;
    }
    /**
     * @return the raidLevel
     */
    public String getRaidLevel() {
        return raidLevel;
    }
    /**
     * @param raidLevel the raidLevel to set
     */
    public void setRaidLevel(String raidLevel) {
        this.raidLevel = raidLevel;
    }

}
