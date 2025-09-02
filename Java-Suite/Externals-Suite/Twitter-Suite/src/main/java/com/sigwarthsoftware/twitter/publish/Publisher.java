package com.sigwarthsoftware.twitter.publish;

import com.sigwarthsoftware.twitter.models.Tweeter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Publisher {
    //------------------------------Publish-----------------------------------
    public static void publish(String message) {
        log.info(message);
        String mode = System.getenv("PROMOBOT_MODE");
        boolean publishEnabled = mode.equalsIgnoreCase("prod") ||
                                 mode.equalsIgnoreCase("post");
        publish(message, publishEnabled);
    }
    //------------------------------Publish-----------------------------------
    public static void publish(String message, boolean shouldPublish) {
        if (shouldPublish) {
            Tweeter tweeter = new Tweeter();
            tweeter.tweet(message);
        } else {
            log.warn("[INFO] Dry run mode: not posting to X.");
        }
    }
}
