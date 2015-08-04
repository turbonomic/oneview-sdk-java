/*******************************************************************************
 * // (C) Copyright 2015 Hewlett Packard Enterprise Development LP
 *******************************************************************************/
package com.hp.ov.sdk.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LiFirmware implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private Command command;
    private Boolean force;
    private String fwBaseline;
    private List<PhysicalInterconnectFirmware> interconnects = new ArrayList<PhysicalInterconnectFirmware>();
    private String sppName;
    private String sppUri;
    private LsFwStateEnum state;

    /**
     * 
     * @return The command
     */
    public Command getCommand() {
        return command;
    }

    /**
     * 
     * @param command
     *            The command
     */
    public void setCommand(final Command command) {
        this.command = command;
    }

    /**
     * 
     * @return The force
     */
    public Boolean getForce() {
        return force;
    }

    /**
     * 
     * @param force
     *            The force
     */
    public void setForce(final Boolean force) {
        this.force = force;
    }

    /**
     * 
     * @return The fwBaseline
     */
    public String getFwBaseline() {
        return fwBaseline;
    }

    /**
     * 
     * @param fwBaseline
     *            The fwBaseline
     */
    public void setFwBaseline(final String fwBaseline) {
        this.fwBaseline = fwBaseline;
    }

    /**
     * 
     * @return The interconnects
     */
    public List<PhysicalInterconnectFirmware> getInterconnects() {
        return interconnects;
    }

    /**
     * 
     * @param interconnects
     *            The interconnects
     */
    public void setInterconnects(final List<PhysicalInterconnectFirmware> interconnects) {
        this.interconnects = interconnects;
    }

    /**
     * 
     * @return The sppName
     */
    public String getSppName() {
        return sppName;
    }

    /**
     * 
     * @param sppName
     *            The sppName
     */
    public void setSppName(final String sppName) {
        this.sppName = sppName;
    }

    /**
     * 
     * @return The sppUri
     */
    public String getSppUri() {
        return sppUri;
    }

    /**
     * 
     * @param sppUri
     *            The sppUri
     */
    public void setSppUri(final String sppUri) {
        this.sppUri = sppUri;
    }

    /**
     * 
     * @return The state
     */
    public LsFwStateEnum getState() {
        return state;
    }

    /**
     * 
     * @param state
     *            The state
     */
    public void setState(final LsFwStateEnum state) {
        this.state = state;
    }

}
