package com.sskva.footballnews.service;

import com.sskva.footballnews.domain.FootballNew;
import com.sskva.footballnews.repository.FootballNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FootballNewService {

    private FootballNewRepository footballNewRepository;

    @Autowired
    public FootballNewService(FootballNewRepository footballNewRepository) {
        this.footballNewRepository = footballNewRepository;
    }


    public  void insertIfNotExist(FootballNew footballNew) {

        boolean isExist = footballNewRepository.existsByText(footballNew.getText());
        if (!isExist) {
            footballNewRepository.insert(footballNew);
        }
    }

}
