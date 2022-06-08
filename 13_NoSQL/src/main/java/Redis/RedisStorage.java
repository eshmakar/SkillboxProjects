package Redis;

import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;

import java.util.Date;

import static java.lang.System.err;
import static java.lang.System.out;

public class RedisStorage {
    // Объект для работы с Redis
    private RedissonClient redisson;

    // Объект для работы с ключами
    private RKeys rKeysSCAN;

    // Объект для работы с Sorted Set'ом ZADD
    private RScoredSortedSet<String> onlineUsersZADD;

    private final static String KEY = "ONLINE_USERS";

    private double getTs() {
        return new Date().getTime() / 1000;
    }

    // Пример вывода всех ключей
    public void listKeys() {
        Iterable<String> keys = rKeysSCAN.getKeys();
        for (String key : keys) {
            out.println("KEY: " + key + ", type:" + rKeysSCAN.getType(key));
        }
    }

    void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.0.105:6379");
        try {
            redisson = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            out.println("Не удалось подключиться к Redis");
            out.println(Exc.getMessage());
        }
        rKeysSCAN = redisson.getKeys();
        onlineUsersZADD = redisson.getScoredSortedSet(KEY);
        rKeysSCAN.delete(KEY);
    }

    void shutdown() {
        redisson.shutdown();
    }

    // Фиксирует посещение пользователем страницы
    void logPageVisit(int user_id) {
        //ZADD ONLINE_USERS
        onlineUsersZADD.add(getTs(), String.valueOf(user_id));
    }

    // Удаляет
    void deleteOldEntries(int secondsAgo) {
        //ZREVRANGEBYSCORE ONLINE_USERS 0 <time_5_seconds_ago>
        onlineUsersZADD.removeRangeByScore(0, true, getTs() - secondsAgo, true);
    }

    int calculateUsersNumber() {
        //ZCOUNT ONLINE_USERS
        return onlineUsersZADD.count(Double.NEGATIVE_INFINITY, true, Double.POSITIVE_INFINITY, true);
    }
}
