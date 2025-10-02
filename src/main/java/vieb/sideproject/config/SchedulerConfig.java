package vieb.sideproject.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@EnableScheduling
@Log4j2
public class SchedulerConfig {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${external.url}")
    private String externalUrlHealthCheck;

    @Scheduled(cron = "${scheduler.cron}")
    public void heathCheck() {
        try {
            restTemplate.getForObject(externalUrlHealthCheck, String.class);
            log.info(">>> Health checked");
        } catch (Exception e) {
            log.error(">>> Health checked failed: {}", e.getMessage());
        }
    }
}
