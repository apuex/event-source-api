package com.github.apuex.eventsource;

import java.net.URI;
import java.security.Principal;
import java.util.Observable;

/**
 * Event source interface, for publishing notifications.
 */
public interface EventSourceAdapter {
  public void publish(Object event);
  public void publish(Object event, Principal principal);
  public void publish(Object event, Principal principal, URI service);

  /**
   * black-hole event source.
   */
  class NullAdapter extends Observable implements EventSourceAdapter {

    @Override
    public void publish(Object event) {
      // ignored
      // notify observers
      setChanged();
      notifyObservers(event);
    }

    @Override
    public void publish(Object event, Principal principal) {
      publish(event);
    }

    @Override
    public void publish(Object event, Principal principal, URI service) {
      publish(event);
    }
  }
}
