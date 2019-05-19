//package array;
//
//import redis.clients.jedis.HostAndPort;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class TestArray {
//    public static void main(String[] args) {
//        String node = "192.168.231.129:7001,192.168.231.129:7002,192.168.231.129:7003,192.168.231.129:7004,192.168.231.129:7005,192.168.231.129:7006,192.168.231.129:7007,192.168.231.129:7008,192.168.231.129:7009";
//        String[] serverArray = node.split(",");//获取服务器数组(这里要相信自己的输入，所以没有考虑空指针问题)
//        Set<HostAndPort> nodes = new HashSet<>();
//
//        for (String ipPort : serverArray) {
//            String[] ipPortPair = ipPort.split(":");
//            System.out.println(ipPortPair[0]);
//            System.out.println(ipPortPair[1]);
//            nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
//        }
//    }
//}
