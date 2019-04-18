package org.randrade.emailschedulerdemo.controller;

import org.randrade.emailschedulerdemo.model.ScheduleEmailRequest;
import org.randrade.emailschedulerdemo.model.ScheduleEmailResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.ZonedDateTime;

@RestController
public class EmailJobSchedulerController {

    private static final Logger logger = LoggerFactory.getLogger(EmailJobSchedulerController.class);

    @PostMapping("/scheduleEmail")
    public ResponseEntity<ScheduleEmailResponse> scheduleEmail(@Valid @RequestBody ScheduleEmailRequest scheduleEmailRequest) {

        ZonedDateTime dateTime = ZonedDateTime.of(scheduleEmailRequest.getDateTime(), scheduleEmailRequest.getTimeZone());

        if(dateTime.isBefore(ZonedDateTime.now())) {
            ScheduleEmailResponse scheduleEmailResponse = new ScheduleEmailResponse(false,
                    "dateTime must be after current time");
            return ResponseEntity.badRequest().body(scheduleEmailResponse);
        }

        return ResponseEntity.ok(new ScheduleEmailResponse(true, "Ok"));

    }
}
