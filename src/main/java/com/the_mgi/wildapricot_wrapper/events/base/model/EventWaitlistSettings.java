package com.the_mgi.wildapricot_wrapper.events.base.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.the_mgi.wildapricot_wrapper.events.base.model.enums.InformationToCollect;
import com.the_mgi.wildapricot_wrapper.events.base.model.enums.WaitlistType;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventWaitlistSettings {
    /**
     * Indicates how the waitlist works for the event.
     */
    @JsonProperty("WaitlistType")
    private WaitlistType waitlistType;

    /**
     * Indicates what information should be collected for people being added to the waitlist.
     */
    @JsonProperty("InformationToCollect")
    private InformationToCollect informationToCollect;

    public EventWaitlistSettings setWaitlistType(WaitlistType waitlistType) {
        this.waitlistType = waitlistType;
        return this;
    }

    public EventWaitlistSettings setInformationToCollect(InformationToCollect informationToCollect) {
        this.informationToCollect = informationToCollect;
        return this;
    }

    @Override
    public String toString() {
        return "EventWaitlistSettings{" +
            "waitlistType=" + waitlistType +
            ", informationToCollect=" + informationToCollect +
            '}';
    }
}
