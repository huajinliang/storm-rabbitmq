package io.latent.storm.rabbitmq;

import backtype.storm.spout.Scheme;
import backtype.storm.task.TopologyContext;
import backtype.storm.tuple.Fields;

import java.util.List;
import java.util.Map;

public interface MessageScheme extends Scheme {
  void open(Map config,
            TopologyContext context);

  void close();

  public static class Builder {
    public static MessageScheme from(final Scheme scheme) {
      return new MessageScheme() {
        @Override
        public void open(Map config,
                         TopologyContext context) { }

        @Override
        public void close() { }

        @Override
        public List<Object> deserialize(byte[] bytes) {
          return scheme.deserialize(bytes);
        }

        @Override
        public Fields getOutputFields() {
          return scheme.getOutputFields();
        }
      };
    }
  }
}
