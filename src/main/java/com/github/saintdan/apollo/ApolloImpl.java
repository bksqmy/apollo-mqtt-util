package com.github.saintdan.apollo;

import com.github.saintdan.apollo.topic.Publisher;
import com.github.saintdan.bo.ConfigBO;
import com.github.saintdan.bo.TopicBO;
import com.github.saintdan.enums.ApiType;
import org.fusesource.mqtt.client.QoS;

/**
 * Implements the Apollo interface
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 6/1/15
 * @since JDK1.8
 */
public class ApolloImpl implements Apollo {

    @Override
    public boolean publish(TopicBO topic, ConfigBO config) {
        Publisher publisher = new Publisher(config);

        return publisher.pub(topic);
    }

    @Override
    public boolean subscribe(TopicBO topic, ConfigBO config) {
        return false;
    }



}
