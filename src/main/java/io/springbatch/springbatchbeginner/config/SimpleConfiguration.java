package io.springbatch.springbatchbeginner.config;

import io.springbatch.springbatchbeginner.dto.NpTbUserPointDto;
import io.springbatch.springbatchbeginner.model.NpTbUserPoint;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Configuration
public class SimpleConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final EntityManagerFactory entityManagerFactory;
    private final DataSource dataSource;

    @Bean
    public Job simpleJob(Step step1) throws Exception {
        log.info("<<<<<<<<<<<<<<<< simpleJob >>>>>>>>>>>>>>>>>>");
        return jobBuilderFactory.get("simpleJob")
                .incrementer(new RunIdIncrementer())
                .start(step1)
                .build();
    }

    @Bean
    @JobScope
    public Step step1(ItemReader<String> reader, ItemProcessor<String, NpTbUserPointDto> processor, ItemWriter<NpTbUserPointDto> writer) throws Exception {
        log.info("<<<<<<<<<<<<<<<< stepOne >>>>>>>>>>>>>>>>>>");
        return stepBuilderFactory.get("step1")
                .<String, NpTbUserPointDto>chunk(5)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public ListItemReader<String> reader() {
        List<String> items = new ArrayList<>();
        for(int i = 0; i < 30; i++) {
            log.info("리더 타냐?????");
            items.add(String.valueOf(i));
        }
        return new ListItemReader<>(items);
    }

    @Bean
    public ItemProcessor<String, NpTbUserPointDto> processor(){
        log.info("** process **");
        return item -> {
            log.info("process = {}", item);
            return new NpTbUserPointDto(Integer.parseInt(item) , Integer.parseInt(item)+100);
        };
    }

    @Bean
    public ItemWriter<NpTbUserPointDto> writer() {
        return items -> {
            for (NpTbUserPointDto item : items) {
                log.info("Item = {}", item.toString());
            }
        };
    }


}
