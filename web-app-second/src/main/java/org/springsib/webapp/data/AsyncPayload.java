package org.springsib.webapp.data;

import java.util.UUID;

import lombok.Data;

@Data
public class AsyncPayload {
    private UUID id;
    private String model;
}
