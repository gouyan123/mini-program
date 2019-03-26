package com.net.pkg2;

import java.io.IOException;
import java.net.InetAddress;

public class InetAddressTest {

    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress.isReachable(3000));
        System.out.println(inetAddress.getHostAddress());

        InetAddress local = InetAddress.getByAddress(new byte[]{61, (byte) 135, (byte) 169, 121});
        System.out.println(local.isReachable(3000));
        System.out.println(local.getCanonicalHostName());

        System.out.println(local.getHostAddress());
    }

}
