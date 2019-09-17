package com.zcy.common.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * @Description kafka 消费者API
 * @author:caiyuan
 * @date:2019/8/28 0028
 * @ver:1.0
 **/
@Slf4j
public class Consumer {

    public static void main(String[] args) {
        autoOffset();
    }

    /**
     * 自动提交偏移量
     *
     * @return void
     * @methodName autoOffset
     * @author caiyuan
     * @date 2019/8/28 0028
     */
    public static void autoOffset(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "129.28.180.167:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList("foo", "bar"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            }
        }
    }
}
