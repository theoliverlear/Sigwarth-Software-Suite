package com.sigwarthsoftware.promo.github.release;


public record Release(String name, String body) {
    public static Release fromSystem() {
        return new Release(
                System.getenv("RELEASE_NAME"),
                System.getenv("RELEASE_BODY")
        );
    }
}