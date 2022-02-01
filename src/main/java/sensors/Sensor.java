package sensors;

import java.util.ArrayList;
import java.util.List;

public abstract class Sensor<T extends Measurement> {

    protected final String name;
    protected final List<T> measurementRecord;

    public Sensor(String name) {
        this.name = name;
        measurementRecord = new ArrayList<>();
    }

}
