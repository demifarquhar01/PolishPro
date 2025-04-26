package demifarquhar01.repositories.inmemory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import demifarquhar01.Schedule;
import demifarquhar01.repositories.ScheduleRepository;

    public class InMemoryScheduleRepository implements ScheduleRepository {
        private final Map<String, Schedule> scheduleStore = new HashMap<>();
    
        @Override
        public void save(Schedule schedule) {
            scheduleStore.put(schedule.getScheduleId(), schedule);
        }
    
       @Override
        public Optional<Schedule> findById(String id) {
        return Optional.ofNullable(scheduleStore.get(id));  

        }
        @Override
        public void delete(String scheduleId) {
            scheduleStore.remove(scheduleId);
        }
    
        @Override
        public List<Schedule> findAll() {
            return new ArrayList<>(scheduleStore.values());
        }
    }
    
