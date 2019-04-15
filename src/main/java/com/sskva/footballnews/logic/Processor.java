package com.sskva.footballnews.logic;

import com.sskva.footballnews.domain.FootballNew;
import com.sskva.footballnews.service.FootballNewService;
import com.sskva.footballnews.util.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Processor {

    private FootballNewService footballNewService;

    @Autowired
    public Processor(FootballNewService footballNewService) {
        this.footballNewService = footballNewService;
    }


    public void start() {

        FootballNew footballNewWorld = new FootballNew("http://football.kulichki.net/worldnews/", "world");
        handlerNew(footballNewWorld);

        FootballNew footballNewRussian = new FootballNew("http://football.kulichki.net/rusnews/", "russian");
        handlerNew(footballNewRussian);
    }


    private void handlerNew(FootballNew footballNew) {

        String url = footballNew.getUrl();
        String text = Parser.parseKulichki(url);
        boolean isValidText = Parser.validationText(text);

        if (isValidText) {
            footballNew.setText(text);
            footballNewService.insertIfNotExist(footballNew);
        }
    }

}
