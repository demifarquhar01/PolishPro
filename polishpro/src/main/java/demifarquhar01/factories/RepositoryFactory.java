package demifarquhar01.factories;

import demifarquhar01.repositories.AppointmentRepository;
import demifarquhar01.repositories.CancelRepository;
import demifarquhar01.repositories.ClientPreferenceRepository;
import demifarquhar01.repositories.ClientRepository;
import demifarquhar01.repositories.EmailNotificationRepository;
import demifarquhar01.repositories.ITAdministratorRepository;
import demifarquhar01.repositories.NailTechnicianRepository;
import demifarquhar01.repositories.RescheduleRepository;
import demifarquhar01.repositories.SalonOwnerRepository;
import demifarquhar01.repositories.ScheduleRepository;
import demifarquhar01.repositories.ServiceRepository;
import demifarquhar01.repositories.UserRepository;
import demifarquhar01.repositories.inmemory.InMemoryAppointmentRepository;
import demifarquhar01.repositories.inmemory.InMemoryCancelRepository;
import demifarquhar01.repositories.inmemory.InMemoryClientPreferenceRepository;
import demifarquhar01.repositories.inmemory.InMemoryClientRepository;
import demifarquhar01.repositories.inmemory.InMemoryEmailNotificationRepository;
import demifarquhar01.repositories.inmemory.InMemoryITAdministratorRepository;
import demifarquhar01.repositories.inmemory.InMemoryNailTechnicianRepository;
import demifarquhar01.repositories.inmemory.InMemoryRescheduleRepository;
import demifarquhar01.repositories.inmemory.InMemorySalonOwnerRepository;
import demifarquhar01.repositories.inmemory.InMemoryScheduleRepository;
import demifarquhar01.repositories.inmemory.InMemoryServiceRepository;
import demifarquhar01.repositories.inmemory.InMemoryUserRepository;


public class RepositoryFactory {
    public static AppointmentRepository getAppointmentRepo(String type) {
        switch (type.toUpperCase()) {
            case "MEMORY" -> {
                return new InMemoryAppointmentRepository();
            }
            default -> throw new IllegalArgumentException("Invalid type");
        }
    }

    public static ClientRepository getClientRepo(String type) {
        switch (type.toUpperCase()) {
            case "MEMORY" -> {
                return new InMemoryClientRepository();
            }
            default -> throw new IllegalArgumentException("Invalid type");
        }
    }
public static CancelRepository getCancelRepository(String type){
    switch (type.toUpperCase()){
        case "MEMORY" -> {
            return new InMemoryCancelRepository();
            }
        default -> throw new IllegalArgumentException("Invalid type");
    }
}
   
public static ClientPreferenceRepository getPreferenceRepository(String type){
    switch (type.toUpperCase()){
        case "MEMORY" -> {
            return new InMemoryClientPreferenceRepository();
            }
        default -> throw new IllegalArgumentException("Invalid type");
    } 
}

public static EmailNotificationRepository getEmailRepository(String type){
    switch (type.toUpperCase()){
        case "MEMORY" -> {
            return new InMemoryEmailNotificationRepository();
            }
        default -> throw new IllegalArgumentException("Invalid type");
    }
}

public static ITAdministratorRepository getITAdminRepository(String type){
    switch (type.toUpperCase()){
        case "MEMORY" -> {
            return new InMemoryITAdministratorRepository();
            }
        default -> throw new IllegalArgumentException("Invalid type");
    }
}

public static NailTechnicianRepository getNailTechRepository(String type){
    switch (type.toUpperCase()){
        case "MEMORY" -> {
            return new InMemoryNailTechnicianRepository();
            }
        default -> throw new IllegalArgumentException("Invalid type");
    }
}

public static RescheduleRepository getRescheduleRepository(String type){
    switch (type.toUpperCase()){
        case "MEMORY" -> {
            return new InMemoryRescheduleRepository();
            }
        default -> throw new IllegalArgumentException("Invalid type");
    }
}

public static SalonOwnerRepository getSalonOwnerRepository(String type){
    switch (type.toUpperCase()){
        case "MEMORY" -> {
            return new InMemorySalonOwnerRepository();
            }
        default -> throw new IllegalArgumentException("Invalid type");
    }
}

public static ServiceRepository getServiceRepository(String type){
    switch (type.toUpperCase()){
        case "MEMORY" -> {
            return new InMemoryServiceRepository();
            }
        default -> throw new IllegalArgumentException("Invalid type");
    }
}

public static UserRepository getUserRepository(String type){
    switch (type.toUpperCase()){
        case "MEMORY" -> {
            return new InMemoryUserRepository();
            }
        default -> throw new IllegalArgumentException("Invalid type");
    }
}

public static ScheduleRepository getScheduleRepository(String type){
    switch (type.toUpperCase()){
        case "MEMORY" -> {
            return new InMemoryScheduleRepository();
            }
        default -> throw new IllegalArgumentException("Invalid type");
    }
}
}