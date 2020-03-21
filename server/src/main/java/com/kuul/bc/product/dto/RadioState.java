package com.kuul.bc.product.dto;

/**
 * Transfer object that encapsulates the radio's state
 */
public class RadioState {
    private boolean active;

    public RadioState() {
        // empty constructor is necessary for automatic jax-rs type transformations
    }

    public RadioState(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
