package com.meetmind.backend.controller;

import com.meetmind.backend.entity.Meeting;
import com.meetmind.backend.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/meetings")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @PostMapping("/create")
    public Meeting createMeeting(@RequestBody Meeting meeting) {

        return meetingService.createMeeting(meeting);

    }
}