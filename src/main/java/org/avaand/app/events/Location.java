package org.avaand.app.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Location {
    private float latitude;
    private float longitude;

    @JsonCreator
    public Location(@JsonProperty("latitude") float latitude, @JsonProperty("longitude") float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
