package com.sskva.footballnews.util;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Parser {

    public static String parseKulichki(String url) {

        String footballNewText = null;
        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select("div.title_m");
            footballNewText = elements.get(0).ownText();
        } catch (Exception e){
        }
        return footballNewText;
    }



    public static boolean validationText(String text) {

        boolean isValidText = true;

        if (text == null) {
            isValidText = false;
        } else {
            if (text.equalsIgnoreCase("")) {
                isValidText = false;
            }
            if (text.toLowerCase().contains("текстовая трансляция")) {
                isValidText = false;
            }
            if (text.toLowerCase().contains("обзор")) {
                isValidText = false;
            }
            if (text.toLowerCase().contains("«")) {
                isValidText = false;
            }
            if (text.toLowerCase().contains("»")) {
                isValidText = false;
            }
            if (text.toLowerCase().contains("фнк")) {
                isValidText = false;
            }
        }
        return isValidText;
    }

}
