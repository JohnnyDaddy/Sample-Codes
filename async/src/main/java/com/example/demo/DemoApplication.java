package com.example.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class DemoApplication {
  @Autowired
  TestService service;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @PostConstruct
  public void testAsyncAnnotationForMethodsWithReturnType() throws InterruptedException, ExecutionException {
    log.info("test init");
    for (int i = 0; i < 10; i++) {
      CompletableFuture<String> future = service.getTask(i);
      future.thenAccept(result -> log.info("task result : " + result));
      log.info("this msg shoud be shown before task" + i + " has been completed");
    }
    log.info("test end");
  }

}
