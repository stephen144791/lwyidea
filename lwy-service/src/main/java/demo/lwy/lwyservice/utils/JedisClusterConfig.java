//package demo.lwy.lwyservice.utils;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import redis.clients.jedis.HostAndPort;
//import redis.clients.jedis.JedisCluster;
//import redis.clients.jedis.JedisPoolConfig;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Configuration
//public class JedisClusterConfig {
////    @Autowired
////    private RedisProperties redisProperties;
//
//    /**
//     * 注意：
//     * 这里返回的JedisCluster是单例的，并且可以直接注入到其他类中去使用
//     *
//     * @return
//     */
//    @Bean
//    public JedisCluster getJedisCluster() {
////        RedisProperties redisProperties = new RedisProperties();
//        String redisClusterNodes = "192.168.231.129:7001,192.168.231.129:7002,192.168.231.129:7003,192.168.231.129:7004,192.168.231.129:7005,192.168.231.129:7006,192.168.231.129:7007,192.168.231.129:7008,192.168.231.129:7009";
////        String[] serverArray = redisProperties.getClusterNodes().split(",");//获取服务器数组(这里要相信自己的输入，所以没有考虑空指针问题)
//        String[] serverArray = redisClusterNodes.split(",");//获取服务器数组(这里要相信自己的输入，所以没有考虑空指针问题)
//        System.out.println("[serverArray]"  +serverArray[0]);
//        Set<HostAndPort> nodes = new HashSet<>();
//
//        for (String ipPort : serverArray) {
//            String[] ipPortPair = ipPort.split(":");
//                nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
//        }
//        JedisPoolConfig poolConfig = new JedisPoolConfig();
//        // 最大连接数
//        poolConfig.setMaxTotal(1);
//        // 最大空闲数
//        poolConfig.setMaxIdle(1);
//        // 最大允许等待时间，如果超过这个时间还未获取到连接，则会报JedisException异常：
//        // Could not get a resource from the pool
//        poolConfig.setMaxWaitMillis(1000);
//        return new JedisCluster(nodes, 1000,
//                1000, 3, "passwd123",
//                poolConfig);//需要密码连接的创建对象方式
//
//    }
//
//}
