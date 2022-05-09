package it.lucianofilippucci.zgest.helper.exceptions;

public class EntityAlreadyExist extends Exception {
    private final ErrorCodes errorCode;
    private final String entityName;

    public EntityAlreadyExist(ErrorCodes errorCode, String entityName) {
        this.errorCode = errorCode;
        this.entityName = entityName;
    }

    public ErrorCodes getErrorCode() {
        return errorCode;
    }

    public String getEntityName() {
        return entityName;
    }
}
