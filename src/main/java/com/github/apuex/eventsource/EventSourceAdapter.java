package com.github.apuex.eventsource;

import java.util.Observable;

/**
 * Event source interface, for publishing notifications.
 */
public interface EventSourceAdapter {
  public void publish(Object event);

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
  }
}
