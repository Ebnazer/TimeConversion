/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Service.ConversionService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.inject.Inject;

/**
 *
 * @author user1
 */
@Named("conversionController")
@RequestScoped
public class ConversionController implements Serializable {

    private String clockTime;
    private String currentTimeInWords;

    @Inject
    Service.ConversionService conversionService;

    public ConversionController() {
    }

    @PostConstruct
    public void init() {
        clockTime = null;
        currentTimeInWords = null;
    }

    public String getClockTime() {
        return clockTime;
    }

    public void setClockTime(String clockTime) {
        this.clockTime = clockTime;
    }

    public String getCurrentTimeInWords() {
        return currentTimeInWords;
    }

    public void setCurrentTimeInWords(String currentTimeInWords) {
        this.currentTimeInWords = currentTimeInWords;
    }

    public ConversionService getConversionService() {
        return conversionService;
    }

    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    public void convertToWords() {
        try {
            currentTimeInWords = conversionService.convertToWords(clockTime);
//            return "index.xhml?faces-redirect=true";
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
//            return e.getMessage();
        }
    }

}
