package com.example.demo.enums;

import java.util.Set;

import com.example.demo.annotations.JobType;
import com.example.demo.job.Job;

import org.reflections.Reflections;

public enum JobEnum {
  AIMS_REBOOT("AIMS Reboot"), GATEWAY_REBOOT("Gateway Reboot"), ARTICLE_UPDATE("Article Update"),
  TEMPLATE_UPDATE("Template Update");

  private final String text;

  JobEnum(final String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return text;
  }

  public Job getInstanceWithJobEnum() throws Exception {
    Job job = null;

    Reflections reflections = new Reflections("com.example.demo");

    Set<Class<? extends Job>> subTypes = reflections.getSubTypesOf(Job.class);
    for (Class<? extends Job> sub : subTypes) {
      JobType jobType = sub.getAnnotation(JobType.class);
      if (jobType != null && jobType.value().equals(this.name())) {
        try {
          job = (Job) sub.getConstructor().newInstance();
        } catch (Exception e) {
          throw e;
        }
      }
    }

    return job;
  }
}
