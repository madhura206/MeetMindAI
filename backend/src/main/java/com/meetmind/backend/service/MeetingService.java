package com.meetmind.backend.service;

import com.meetmind.backend.entity.Meeting;
import com.meetmind.backend.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    public Meeting createMeeting(Meeting meeting) {

        return meetingRepository.save(meeting);

    }

}