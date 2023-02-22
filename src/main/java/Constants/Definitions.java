/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constants;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author user1
 */
@Named("definitions")
@RequestScoped
public class Definitions {

    private final String title = "Time Conversion";
    private final String subTitle = "Please enter the clock time";
    private final String clockTimeRequired = "Clock time is required, cannot be empty";
    private final String clockTimeValidatorMessage = "Please enter the clock time in hh:mm format /\n"
            +"Hours between 0 to 23 /\n"
            +"Minutes between 0 to 59 /\n"
            +"Ex: 08:34";
    private final String clockTimePattern = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
    private final String requestTrue = "true";
    private final String submit = "Submit";
    private final String convert = "Convert";
    private final String cancel = "Cancel";
    private final String footer = "2023 © Time Conversion";

    public Definitions() {
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getClockTimeRequired() {
        return clockTimeRequired;
    }

    public String getRequestTrue() {
        return requestTrue;
    }

    public String getSubmit() {
        return submit;
    }

    public String getFooter() {
        return footer;
    }

    public String getClockTimeValidatorMessage() {
        return clockTimeValidatorMessage;
    }

    public String getClockTimePattern() {
        return clockTimePattern;
    }

    public String getConvert() {
        return convert;
    }

    public String getCancel() {
        return cancel;
    }

}
