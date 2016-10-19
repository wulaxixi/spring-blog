package me.woemler.springblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@ComponentScan(basePackages = "me.woemler")
@EnableAsync
public class AsyncConfig {

private int poolSize=10;

private int queueCapacity=10;

    @Bean(name = "taskExecutor")
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(10);
        taskExecutor.setMaxPoolSize(this.poolSize);
        taskExecutor.setQueueCapacity(this.queueCapacity);
        taskExecutor.afterPropertiesSet();
        taskExecutor.setThreadNamePrefix("testExecutor");
        return taskExecutor;
    }
}
