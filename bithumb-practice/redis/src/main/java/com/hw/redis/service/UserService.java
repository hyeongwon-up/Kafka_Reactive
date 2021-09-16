package com.hw.redis.service;

import com.hw.redis.converter.ByteToUserConverter;
import com.hw.redis.converter.UserToByteConverter;
import com.hw.redis.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;


@Service
@RequiredArgsConstructor
public class UserService {
    private final ByteToUserConverter byteToUserConverter;
    private final UserToByteConverter userToByteConverter;
    private final RedisTemplate redisTemplate;

    public ResponseEntity<User> save(User user) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("user", user.getId(), userToByteConverter.convert(user));
        return null;
    }

    public User findById(String id) {
        HashOperations operations = redisTemplate.opsForHash();
        return byteToUserConverter.convert((byte[]) operations.get("user", id));
    }

}
