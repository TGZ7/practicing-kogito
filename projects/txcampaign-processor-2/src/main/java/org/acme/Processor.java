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

    public Boolean isLiked(Campain camp) {
        if (camp.getLikes()/camp.getDislikes() > 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean isPopular(Campain camp) {
        int numero = 20;
        if (camp.getInteracciones() > numero) {
            return true;
        }
        else {
            return false;
        }
    }
    
}
