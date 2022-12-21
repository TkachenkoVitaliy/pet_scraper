package ru.vtkachenko.pet_scraper.scheduler;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.Date;

@Configuration
@EnableScheduling
public class SchedulerConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        Trigger trigger = new Trigger() {
//            @Override
//            public Date nextExecutionTime(TriggerContext triggerContext) {
//                Date date = triggerContext.lastScheduledExecutionTime();
//            }
//        }
    }
}
