package com.lfg.beans;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

/**
 * 文件监听器，监听系统外文件变更，避免服务器重启,动态监听
 * Created by lifengguang on 2017/7/31.
 */
public class WatchServiceFilterDemo implements Runnable {

    private String filePath;


    public WatchServiceFilterDemo(String filePath) {
        this.filePath = filePath;
    }


    @Override
    public void run() {
        try {
            register(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void configruationChanged(String filePath) {
        System.out.println("reflushing the configruation.");
        ConfigruationApplication.getInstance().initlize(filePath);
    }

    public void register(String filePath) throws IOException {
        final int lastIndex = filePath.lastIndexOf("/");
        String absFilePath = filePath.substring(0, lastIndex + 1);
        String fileName = filePath.substring(lastIndex + 1, filePath.length());
        configruationChanged(filePath);
        startWatcher(absFilePath, fileName);
    }

    private void startWatcher(String absFilePath, String fileName) throws IOException {
        final WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = Paths.get(absFilePath);
        path.register(watchService, ENTRY_MODIFY);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                watchService.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));

        WatchKey key = null;
        while (true) {
            try {
                key = watchService.take();

                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.context().toString().equals(fileName)) {
                        configruationChanged(absFilePath + fileName);
                    }
                }
                boolean reset = key.reset();
                if (!reset) {
                    System.out.println("could not reset the watch key");
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


}
