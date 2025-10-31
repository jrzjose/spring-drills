package org.micro.webapp.data.service;

import java.util.ArrayList;
import java.util.List;

import org.micro.webapp.web.model.Tour;
import org.springframework.stereotype.Service;


import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class TourService {

    public TourService() {}
        
    
    public List<Tour> getAllTours() {
        List<Tour> entities = new ArrayList<>();
        entities.add(
            Tour.builder()
                .id(1)
                .description("abc")
                .title("title")
                .blurb("blurb")
                .price(100)
                .duration("2h")
                .bullets("1.2.3..")
                .keywords("k1, k2...")
                .build()
            );
        
        log.info("Get All Tours");

        return entities;
    }
}
