package org.acme;

import javax.enterprise.context.ApplicationScoped;

/**
 * Processor
 */

@ApplicationScoped
public class Processor {

    public String toUpper(String text) {
        return text.toUpperCase();
    }

    public Boolean isEnded(Campain camp) {
        int fechaHoy = 2022;
        if (fechaHoy > camp.getFecha()) {
            return true;
        }
        else {
            return false;
        }
    }
    
}
