package com.batch.example.boot_batch_example.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.batch.example.boot_batch_example.model.Person;

@Configuration
public class BatchConfig {

    @Bean
    public Job jobBean(JobRepository jobRepository, 
                        JobCompletionNotificationImpl listener,
                        Step steps){
        return new JobBuilder("job", jobRepository)
            .listener(listener)
            .start(steps)
            .build();
    }

    @Bean
    public Step steps(
        JobRepository jobRepository,
        DataSourceTransactionManager transactionManager,
        FlatFileItemReader<Person> reader,
        ItemProcessor<Person, Person> processor,
        ItemWriter<Person> writer
    ){
        return new StepBuilder("JobStep", jobRepository)
            .<Person, Person>chunk(5, transactionManager)
            .reader(reader)
            .processor(processor)
            .writer(writer)
            .build();
    }

    // reader 
    @Bean
    public FlatFileItemReader<Person> reader(){
        return new FlatFileItemReaderBuilder<Person>()
            .name("itemReader")
            .resource(new ClassPathResource("data.csv"))
            .delimited()
            .names("personId", "firstName", "lastName","contact", "email")
            .targetType(Person.class)
            .build();
    }

    // processor

    @Bean
    public ItemProcessor<Person, Person> itemProcessor(){
        return new CustomItemProcessor();
    }

    // writer 
    @Bean
    public ItemWriter<Person> itemWriter(DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<Person>()
            .sql("insert into person(personId, firstName, lastName, contact, email) values(:personId, :firstName, :lastName, :contact, :email)")
            .dataSource(dataSource)
            .beanMapped()
            .build();
    }
}
 