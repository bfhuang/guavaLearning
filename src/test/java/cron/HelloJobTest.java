package cron;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static java.lang.Thread.sleep;

/**
 * Created by twer on 3/14/15.
 */
public class HelloJobTest {

    public static void main(String[] args) throws SchedulerException, InterruptedException {

        JobDetail job = JobBuilder.newJob(HelloJob.class)
                .withIdentity("dummyJobName", "group1").build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("dummyTriggerName", "group1")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                .build();


        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
    }
}
