package com.xicheng.springcloud.rpc;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xichengxml
 * @date 2019/1/11 14:52
 */
public class RpcFramework {

    private static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100));

    /**
     * 暴露服务
     * @param service 服务
     * @param port 端口号
     * @throws Exception
     */
    public void provide(final Object service, int port) throws Exception {
        if (service == null) {
            throw new IllegalArgumentException("Service instance is null");
        }
        if (port <= 0 || port > 65535) {
            throw new IllegalArgumentException("Invalid port: " + port);
        }
        System.out.println("Export service: " + service.getClass().getName() + " on port " + port);
        ServerSocket serverSocket = new ServerSocket(port);
        for(;;) {
            final Socket accept = serverSocket.accept();
            EXECUTOR.execute(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
    }

    /**
     * 引用服务
     * @param interfaces
     * @param host
     * @param port
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T consume(final Class<T> interfaces, final String host, final int port) throws Exception {
        return null;
    }
}
