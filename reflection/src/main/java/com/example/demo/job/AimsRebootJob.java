package com.example.demo.job;

import com.example.demo.annotations.JobType;
import com.example.demo.dto.StationJob;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@JobType(value = "AIMS_REBOOT")
public class AimsRebootJob extends Job {

  @Override
  public JobResult executeJob(StationJob stationJob) {
    log.info(stationJob.toString());
    log.info("AIMS reboot");
    return new JobResult("00", "Success");
  }
}
