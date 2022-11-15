package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.StationJob;
import com.example.demo.job.JobResult;
import com.example.demo.job.Job;

import org.springframework.stereotype.Service;

@Service
public class JobService {
  public JobResult runtasks(List<StationJob> stationJobs) throws Exception {
    JobResult result = new JobResult();
    for (StationJob stationJob : stationJobs) {
      Job job = stationJob.getJobEnum().getInstanceWithJobEnum();
      job.executeJob(stationJob);
    }
    return result;
  }
}
