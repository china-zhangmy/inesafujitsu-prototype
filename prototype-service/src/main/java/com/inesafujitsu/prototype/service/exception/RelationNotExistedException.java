package com.inesafujitsu.prototype.service.exception;

public class RelationNotExistedException extends RuntimeException {

    public RelationNotExistedException() {
        super("The relation has not been established!");
    }
}
