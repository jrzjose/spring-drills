package org.sandbox.service;

import java.util.ArrayList;
import java.util.List;

import org.sandbox.model.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import lombok.Getter;

@Service
@Getter
public class FactoryDemoService {

    @Value("${app.name}")
    private String name;

    @Value("#{new Boolean(environment['spring.profiles.active']=='dev')}")
    private Boolean isDev;
}

