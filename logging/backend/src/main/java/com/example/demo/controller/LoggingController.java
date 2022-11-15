package com.example.demo.controller;

import java.util.Arrays;

import com.example.demo.dto.LoggingChangeInput;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LoggingController {
  private final String[] VALID_LEVELS = { "TRACE", "DEBUG", "INFO", "WARN", "ERROR" };

  @Operation(summary = "Log Level 및 package 변경", description = "Log Level 및 package를 변경한다. package 정보가 생략된 경우 ROOT logger에 적용된다.")
  @PostMapping(value = "/changeLogLevel")
  public @ResponseBody String changeLogLevel(@RequestBody LoggingChangeInput input) {
    String returnCode = "";

    String level = input.getLevel();
    String pkgToChange = input.getPkg();

    if (pkgToChange == null) {
      pkgToChange = Logger.ROOT_LOGGER_NAME;
    }

    Logger logger = (Logger) LoggerFactory.getLogger(pkgToChange);

    if (Arrays.stream(VALID_LEVELS).anyMatch(level.toUpperCase()::equals)) {
      Level oldLevel = logger.getLevel();
      logger.setLevel(Level.toLevel(level));
      log.info(
          "Log level has been changed in package " + pkgToChange + " from " + oldLevel + " to " + logger.getLevel());
      returnCode = "00";
    } else {
      log.warn("Unsupported log level : " + level);
      returnCode = "01";
    }
    return returnCode;
  }
}
