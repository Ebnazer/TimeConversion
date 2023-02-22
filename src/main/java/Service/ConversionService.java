/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Properties;
import javax.annotation.PostConstruct;

/**
 *
 * @author user1
 */
@Named("conversionService")
@RequestScoped
public class ConversionService implements Serializable {

    private String currentTimeInWords;
    private String firstResult;
    private String secondResult;

    private Map<String, String> oneToNine;
    private Map<String, String> tens;
    private Map<String, String> tenToNineteen;

    private final String MIDDAY = "midday";
    private final String MIDNIGHT = "midnight";

    public ConversionService() {
    }

    @PostConstruct
    public void init() {
        currentTimeInWords = null;
        oneToNine = new HashMap<>();
        tens = new HashMap<>();
        tenToNineteen = new HashMap<>();
    }

    public String getCurrentTimeInWords() {
        return currentTimeInWords;
    }

    public void setCurrentTimeInWords(String currentTimeInWords) {
        this.currentTimeInWords = currentTimeInWords;
    }

    public Map<String, String> getTens() {
        return tens;
    }

    public void setTens(Map<String, String> tens) {
        this.tens = tens;
    }

    public Map<String, String> getTenToNineteen() {
        return tenToNineteen;
    }

    public void setTenToNineteen(Map<String, String> tenToNineteen) {
        this.tenToNineteen = tenToNineteen;
    }

    public Map<String, String> getOneToNine() {
        return oneToNine;
    }

    public void setOneToNine(Map<String, String> oneToNine) {
        this.oneToNine = oneToNine;
    }

    public String getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(String firstResult) {
        this.firstResult = firstResult;
    }

    public String getSecondResult() {
        return secondResult;
    }

    public void setSecondResult(String secondResult) {
        this.secondResult = secondResult;
    }

    private void loadTens() {
        tens.put("10", "ten");
        tens.put("20", "twenty");
        tens.put("30", "thirty");
        tens.put("40", "fourty");
        tens.put("50", "fifty");
    }

    private void loadOneToNine() {
        oneToNine.put("0", "");
        oneToNine.put("00", "");
        oneToNine.put("1", "one");
        oneToNine.put("2", "two");
        oneToNine.put("3", "three");
        oneToNine.put("4", "four");
        oneToNine.put("5", "five");
        oneToNine.put("6", "six");
        oneToNine.put("7", "seven");
        oneToNine.put("8", "eight");
        oneToNine.put("9", "nine");
    }

    private void loadTenToNinteen() {
        tenToNineteen.put("10", "ten");
        tenToNineteen.put("11", "eleven");
        tenToNineteen.put("12", "twelve");
        tenToNineteen.put("13", "thirtheen");
        tenToNineteen.put("14", "forteen");
        tenToNineteen.put("15", "fiftheen");
        tenToNineteen.put("16", "sixteen");
        tenToNineteen.put("17", "seventeen");
        tenToNineteen.put("18", "eighteen");
        tenToNineteen.put("19", "nineteen");
    }

    private int getHours(String clockTime) {
        return Integer.parseInt(clockTime.substring(0, 2));
    }

    private int getMinutes(String clockTime) {
        return Integer.parseInt(clockTime.substring(3, 5));
    }

    public String convertToWords(String clockTime) {
        try {

            int hours;
            int minutes;

            hours = getHours(clockTime);
            minutes = getMinutes(clockTime);

            loadTens();
            loadOneToNine();
            loadTenToNinteen();

            if (hours == 0) {
                firstResult = MIDNIGHT;
            } else if (hours == 12) {
                firstResult = MIDDAY;
            } else {
                firstResult = convertHHMMToWords(String.valueOf(clockTime.charAt(0)), String.valueOf(clockTime.charAt(1)));
            }
            secondResult = convertHHMMToWords(String.valueOf(clockTime.charAt(3)), String.valueOf(clockTime.charAt(4)));
            currentTimeInWords = "It's " + firstResult + " " + secondResult;

            return currentTimeInWords;

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return e.getMessage();
        }
    }

    public String convertHHMMToWords(String firstDigit, String secondDigit) {
        try {
            int clockTime = Integer.parseInt(firstDigit + secondDigit);
            String res = firstDigit + secondDigit;

            if (clockTime < 10) {
                return oneToNine.get(secondDigit);
            } else if (clockTime > 9 && clockTime < 20) {
                return tenToNineteen.get(res);
            } else {
                return tens.get(firstDigit + "0") + " " + oneToNine.get(secondDigit);
            }
        } catch (NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
            return e.getMessage();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return e.getMessage();
        }

    }

}
