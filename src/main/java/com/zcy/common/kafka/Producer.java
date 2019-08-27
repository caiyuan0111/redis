package com.zcy.common.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @Description kafka 生产者API
 * @author:caiyuan
 * @date:2019/8/27 0027
 * @ver:1.0
 **/
public class Producer {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "129.28.180.167:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        org.apache.kafka.clients.producer.Producer<String,String> producer = new KafkaProducer<>(props);
        for (int i=0; i< 10 ; i++) {
            producer.send(new ProducerRecord<String, String>("test", Integer.toString(i), Integer.toString(i)));
        }
        producer.close();
    }
}
