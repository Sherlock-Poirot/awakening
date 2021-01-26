package com.detective.stone.message.config;

import com.rabbitmq.client.Channel;
import java.io.IOException;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageHandleService {

  @RabbitListener(bindings = @QueueBinding(value = @Queue("member"), exchange = @Exchange(name = "mercantilism", type = ExchangeTypes.FANOUT)))
  public void memberMessageHandle(String content, Message message, Channel channel) throws IOException {
    System.out.println("member消息:" + content);
    long deliveryTag = message.getMessageProperties().getDeliveryTag();
    channel.basicAck(deliveryTag, false);
  }

  @RabbitListener(bindings = @QueueBinding(value = @Queue("tourists"), exchange = @Exchange(name = "mercantilism", type = ExchangeTypes.FANOUT)))
  public void touristsMessageHandle(String content, Message message, Channel channel) throws IOException {
    System.out.println("tourists消息:" + content);
    long deliveryTag = message.getMessageProperties().getDeliveryTag();
    channel.basicAck(deliveryTag, false);
  }
}
