package com.example.demo.dto;

import com.example.demo.enums.JobEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StationJob {
  long stationJobId;
  String jobParams;
  JobEnum jobEnum;
}
