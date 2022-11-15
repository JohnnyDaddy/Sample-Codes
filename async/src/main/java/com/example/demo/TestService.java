package com.example.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TestService {
  @Autowired
  private Executor executor;

  public CompletableFuture<String> getTask(int i) {
    log.info("get Task" + i);
    return CompletableFuture.supplyAsync(() -> {
      log.info("task" + i + " start");
      try {
        // Do Something
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        log.error(e.getMessage());
      }
      log.info("task" + i + "  end");
      return "task" + i + "  done";
    }, executor);
  }
}
