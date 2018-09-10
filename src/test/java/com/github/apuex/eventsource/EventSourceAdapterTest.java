package com.github.apuex.eventsource;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class EventSourceAdapterTest {
  @Test
  public void testNullAdapter() {
    EventSourceAdapter.NullAdapter eventSource = new EventSourceAdapter.NullAdapter();

    LinkedList<Object> events = new LinkedList<>();
    LinkedList<Object> expected = new LinkedList<>();

    eventSource.addObserver((o, arg) -> expected.add(arg));

    events.add("hello");
    events.add("world");

    events.forEach(e -> eventSource.publish(e));

    Assert.assertEquals(expected, events);
  }
}
