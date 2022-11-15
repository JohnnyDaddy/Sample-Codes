package com.example.demo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoggingScheduler2 {
  @Scheduled(fixedDelay = 10000)
  private void logging() {
    for (int i = 0; i < 10; i++) {
      log.trace("trace trace trace trace trace trace trace trace trace trace.");
      log.debug("debug debug debug debug debug debug debug debug debug debug.");
      log.info("info info info info info info info info info info info.");
      log.warn("warn warn warn warn warn warn warn warn warn warn warn.");
      log.error("error error error error error error error error error error.");
    }
  }
}
