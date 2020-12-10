package cz.cvut.fit.miadp.mvcgame.util;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Timer {

    private LocalDateTime startTime;

    public Timer() {
        startTime = LocalDateTime.now();
    }

    public double getTime(Unit timeUnit) {
        LocalDateTime now = LocalDateTime.now();
        return ChronoUnit.MILLIS.between(startTime, now) / timeUnit.getValue();
    }

    public void reset() {
        startTime = LocalDateTime.now();
    }

    public enum Unit {
        MILLIS(1.0), SECONDS(1000.0), TENTH_OF_SECOND(100.0);

        private final double millis;

        Unit(double millis) {
            this.millis = millis;
        }

        public double getValue() {
            return millis;
        }
    }
}
