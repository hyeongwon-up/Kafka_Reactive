package com.hw.redis.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;
import com.hw.redis.domain.User;

@Component
@ReadingConverter
public class ByteToUserConverter implements Converter<byte[], User>{

    private final Jackson2JsonRedisSerializer<User> serializer;

    public ByteToUserConverter() {
        this.serializer = new Jackson2JsonRedisSerializer<User>(User.class);
        serializer.setObjectMapper(new ObjectMapper());
    }

    @Override
    public User convert(byte[] source) {
        return serializer.deserialize(source);
    }

}
