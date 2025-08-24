package com.sigwarthsoftware.net;

public enum AuthStatus {
    AUTHORIZED(true),
    UNAUTHORIZED(false);
    public final boolean isAuthorized;
    AuthStatus(boolean authorized) {
        this.isAuthorized = authorized;
    }
    public static AuthStatus from(boolean authorized) {
        return authorized ? AUTHORIZED : UNAUTHORIZED;
    }
}

