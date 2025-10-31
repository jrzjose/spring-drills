package org.sandbox.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
@Scope("prototype")
// Bean Scopes, singleton = default, prototype, request, session, application, websocket
//  each HTTP request has its own instance of a bean created off the back of a single bean definition. 
// Only valid in the context of a web-aware Spring ApplicationContext
// @RequestScope, ...
public class ProtoService {
    private List<String> items;
    
    @PostConstruct
    public void loadWork() {
        System.out.println("post construct work....");
    }

    @PreDestroy
    public void beforeDest() {
        System.out.println("pre-destroy work....");
    }

    public void someTask() {
        if (items==null)
            items = new ArrayList<>();

        for (int i=0; i<10; i++)
            items.add(RandomStringUtils.secure().next(10, true, true));
    }

    public void print() {
        items.forEach(i -> System.out.println(i));
    }
}
