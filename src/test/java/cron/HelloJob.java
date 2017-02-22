package cron;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static java.lang.Thread.sleep;

public class HelloJob implements Job {
    private  static int index = 0;

    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        System.out.println("Hello Quartz! " + index++);

    }

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