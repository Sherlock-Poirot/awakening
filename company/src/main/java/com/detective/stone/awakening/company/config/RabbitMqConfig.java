package com.detective.stone.awakening.company.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

  @Bean
  public FanoutExchange mercantilismExchange() {
    return new FanoutExchange("mercantilism");
  }

  @Bean
  public Queue memberQueue() {
    return new Queue("member");
  }

  @Bean
  public Binding memberBinding() {
    return BindingBuilder.bind(memberQueue()).to(mercantilismExchange());
  }

  @Bean
  public Queue touristsQueue() {
    return new Queue("tourists");
  }

  @Bean
  public Binding touristsBinding() {
    return BindingBuilder.bind(touristsQueue()).to(mercantilismExchange());
  }

}
