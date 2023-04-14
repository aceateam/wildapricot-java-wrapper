package com.the_mgi.wildapricot_wrapper.events.base.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class InviteeStat {
    /**
     * Number of invitees who did not respond yet.
     */
    @JsonProperty("NotResponded")
    private Integer notResponded;

    /**
     * Number of invitees who answered NO to the invite.
     */
    @JsonProperty("NotAttended")
    private Integer notAttended;

    /**
     * Number of invitees who answered YES to the invite.
     */
    @JsonProperty("Attended")
    private Integer attended;

    /**
     * Number of invitees who answered MAY BE to the invite.
     */
    @JsonProperty("MaybeAttended")
    private Integer maybeAttended;

    public InviteeStat setNotResponded(Integer notResponded) {
        this.notResponded = notResponded;
        return this;
    }

    public InviteeStat setNotAttended(Integer notAttended) {
        this.notAttended = notAttended;
        return this;
    }

    public InviteeStat setAttended(Integer attended) {
        this.attended = attended;
        return this;
    }

    public InviteeStat setMaybeAttended(Integer maybeAttended) {
        this.maybeAttended = maybeAttended;
        return this;
    }

    @Override
    public String toString() {
        return "InviteeStat{" +
            "notResponded=" + notResponded +
            ", notAttended=" + notAttended +
            ", attended=" + attended +
            ", maybeAttended=" + maybeAttended +
            '}';
    }
}
