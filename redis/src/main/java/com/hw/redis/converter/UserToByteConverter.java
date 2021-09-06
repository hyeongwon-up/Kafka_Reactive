package com.hw.redis.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;
import com.hw.redis.domain.User;

@Component
@WritingConverter
public class UserToByteConverter implements Converter<User, byte[]> {

    private final Jackson2JsonRedisSerializer<User> serializer;

    public UserToByteConverter() {
        this.serializer = new Jackson2JsonRedisSerializer<User>(User.class);
        serializer.setObjectMapper(new ObjectMapper());
    }

    @Override
    public byte[] convert(User source) {
        return serializer.serialize(source);
    }
}
