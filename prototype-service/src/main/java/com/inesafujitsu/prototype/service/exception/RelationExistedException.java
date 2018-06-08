package com.inesafujitsu.prototype.service.exception;

public class RelationExistedException extends RuntimeException {

    public RelationExistedException() {
        super("The relation has been established!");
    }
}
