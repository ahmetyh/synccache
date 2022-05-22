package com.ayh.synccache;

import com.ayh.synccache.service.SampleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class SyncCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyncCacheApplication.class, args);
	}

	@Autowired
	SampleDataService sampleDataService;

	@Scheduled(fixedDelay = 1000, initialDelay = 500)
	public void serviceCaller() {


		ExecutorService executorService = Executors.newFixedThreadPool(5);

		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("Service called..");
				sampleDataService.getData();
			}
		};

		for(int i=0;i<5;i++)
			executorService.submit(r);

	}

}
