package com.teamdev.wikiformatting.business.impl;

public final class TransitionExpression {

    private final String fromPresentation;
    private final String toPresentation;

    public TransitionExpression(String fromPresentation, String toPresentation) {
        this.fromPresentation = fromPresentation;
        this.toPresentation = toPresentation;
    }

    public String getFromPresentation() {
        return fromPresentation;
    }

    public String getToPresentation() {
        return toPresentation;
    }
}
