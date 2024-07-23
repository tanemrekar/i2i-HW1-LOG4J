package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class myTimerLoggings {
    private static final Logger logger = LogManager.getLogger(myTimerLoggings.class);
    private static final DateTimeFormatter secondFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter minuteFormatter = DateTimeFormatter.ofPattern("HH:mm:00");
    private static final DateTimeFormatter hourFormatter = DateTimeFormatter.ofPattern("HH:00:00");

    public static void main(String[] args) {
        Timer debugTimer = new Timer();
        Timer infoTimer = new Timer();
        Timer errorTimer = new Timer();

        debugTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                logger.debug(LocalDateTime.now().format(secondFormatter));
            }
        }, 0, 1000);

        infoTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                logger.info(LocalDateTime.now().format(minuteFormatter));
            }
        }, 0, 60000);

        errorTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                logger.error(LocalDateTime.now().format(hourFormatter));
            }
        }, 0, 3600000);
    }
}
