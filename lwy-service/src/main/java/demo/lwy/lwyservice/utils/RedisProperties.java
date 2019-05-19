//package demo.lwy.lwyservice.utils;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//@Component
//public class RedisProperties {
//    @Value("${spring.redis.expireSeconds}")
//    private int expireSeconds;
//    @Value("${spring.redis.cluster.nodes}")
//    private String clusterNodes;
//    @Value("${spring.redis.password}")
//    private String password;
//    @Value("${spring.redis.commandTimeout}")
//    private int commandTimeout;
//
//    public int getExpireSeconds() {
//        return expireSeconds;
//    }
//
//    public void setExpireSeconds(int expireSeconds) {
//        this.expireSeconds = expireSeconds;
//    }
//
//    public String getClusterNodes() {
//        return clusterNodes;
//    }
//
//    public void setClusterNodes(String clusterNodes) {
//        this.clusterNodes = clusterNodes;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public int getCommandTimeout() {
//        return commandTimeout;
//    }
//
//    public void setCommandTimeout(int commandTimeout) {
//        this.commandTimeout = commandTimeout;
//    }
//}
