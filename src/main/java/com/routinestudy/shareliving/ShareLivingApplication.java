package com.routinestudy.shareliving;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShareLivingApplication {
  private static Logger logger = Logger.getAnonymousLogger();

  public static void main(String[] args) {
    SpringApplication.run(ShareLivingApplication.class, args);
    logger.log(Level.INFO, "Application main function called");

    StringBuilder sbargs = new StringBuilder();

    for (int i = 0; i < args.length; i++) {
      sbargs.append("arg[").append(i).append("] ").append(args[i]).append("\n");
    }

    logger.log(Level.CONFIG, sbargs.toString());

    StringBuilder sbProperties = new StringBuilder();
    Properties properties = System.getProperties();
    logger.log(Level.CONFIG, "Properties");
    sbProperties.append("stringPropertyNames: ").append(properties.stringPropertyNames()).append("\n");
    sbProperties.append("values: ").append(properties.values()).append("\n");
    logger.log(Level.CONFIG, sbProperties.toString());
  }
}
