package org.example.DownloadManager;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class DownloadManager {
    private ExecutorService executorService;

    public DownloadManager(int threadPoolSize) {
        // TODO: Initialize the ExecutorService with a fixed-size thread pool.
    }

    public void downloadFiles(List<String> fileUrls) {
        // TODO: Implement a method to submit download tasks for each file URL.
    }

    // TODO: Implement a method to track and display the progress of each download task.

    public void shutdown() {
        // TODO: Shutdown the ExecutorService when the download manager is done.
    }
}