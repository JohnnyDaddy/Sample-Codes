package com.example.demo;

import com.example.demo.dto.StationJob;
import com.example.demo.enums.JobEnum;
import com.example.demo.service.JobService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

  @Autowired
  JobService service;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @PostConstruct
  void test() throws Exception {
    List<StationJob> stationJobs = new ArrayList<StationJob>();
    stationJobs.add(new StationJob(1, "params", JobEnum.AIMS_REBOOT));
    stationJobs.add(new StationJob(2, "params", JobEnum.GATEWAY_REBOOT));
    stationJobs.add(new StationJob(2, "params", JobEnum.ARTICLE_UPDATE));

    service.runtasks(stationJobs);
  }
}
