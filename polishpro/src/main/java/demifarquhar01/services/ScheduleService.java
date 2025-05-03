package demifarquhar01.services;
import java.time.LocalDateTime;
import java.util.List;

import demifarquhar01.NailTechnician;
import demifarquhar01.Schedule;
import demifarquhar01.repositories.ScheduleRepository;


public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    // Nail Technician can only add their own schedule
    public void addSchedule(NailTechnician technician, Schedule schedule) {
        if (!ownsSchedule(technician, schedule)) {
            throw new SecurityException("Technicians can only add their own schedules.");
        }
        scheduleRepository.save(schedule);
        System.out.println("Schedule added: " + schedule.getScheduleId());
    }

    // Update only own schedule
    public void updateSchedule(NailTechnician technician, String scheduleId, List<LocalDateTime> newSlots) {
        Schedule existing = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("Schedule not found."));

        if (!ownsSchedule(technician, existing)) {
            throw new SecurityException("Technicians can only update their own schedules.");
        }

        existing.updateSchedule(newSlots);
        scheduleRepository.save(existing);
    }

    public void viewSchedule(String scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("Schedule not found."));
        schedule.viewAssignedAppointments();
    }

    public void removeSchedule(NailTechnician technician, String scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("Schedule not found."));

        if (!ownsSchedule(technician, schedule)) {
            throw new SecurityException("Technicians can only remove their own schedules.");
        }

        scheduleRepository.delete(scheduleId);
        System.out.println("Schedule removed: " + scheduleId);
    }

    private boolean ownsSchedule(NailTechnician technician, Schedule schedule) {
        return schedule.getScheduleId().equals(technician.getUserId());
    }
}
