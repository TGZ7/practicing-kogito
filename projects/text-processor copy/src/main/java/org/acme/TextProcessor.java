package org.acme;

import javax.enterprise.context.ApplicationScoped;

/**
 * TextProcessor
 */

@ApplicationScoped
public class TextProcessor {

    public String toUpper(String text) {
        return text.toUpperCase();
    }
    
}
