package com.example.demo.job;

import com.example.demo.dto.StationJob;

import lombok.Data;

@Data
public abstract class Job {
  public abstract JobResult executeJob(StationJob stationJob);
}
