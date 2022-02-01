package sensors;

import java.time.LocalDateTime;

public abstract class Measurement {

    protected final LocalDateTime measurementTime;

    public Measurement(LocalDateTime measurementTime) {
        this.measurementTime = measurementTime;
    }

}
