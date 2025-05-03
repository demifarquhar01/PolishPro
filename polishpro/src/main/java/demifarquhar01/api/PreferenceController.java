package demifarquhar01.api;



    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PutMapping;
    import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demifarquhar01.ClientPreference;
import demifarquhar01.User;
import demifarquhar01.services.PreferenceService;
    
    @RestController
    @RequestMapping("/api/preferences")
    public class PreferenceController {
    
        private final PreferenceService preferenceService;
    
        public PreferenceController(PreferenceService preferenceService) {
            this.preferenceService = preferenceService;
        }
    
        // PUT /api/preferences/{clientId} - Update client preferences
        @PutMapping("/{clientId}")
        public String updatePreference(@PathVariable String clientId,
                                       @RequestParam String preferences,
                                       @RequestParam String notes,
                                       @RequestAttribute User user) {
            ClientPreference preference = new ClientPreference(clientId, preferences, notes);
            try {
                preferenceService.updatePreferences(user, clientId, preference);
                return "Client preferences updated successfully.";
            } catch (SecurityException e) {
                return "Unauthorized: " + e.getMessage();
            }
        }
    
        // GET /api/preferences/{clientId} - View client preferences
        @GetMapping("/{clientId}")
        public Object viewPreference(@PathVariable String clientId,
                                     @RequestAttribute User user) {
            try {
                return preferenceService.viewPreferences(user, clientId);
            } catch (SecurityException e) {
                return "Unauthorized: " + e.getMessage();
            } catch (IllegalStateException e) {
                return "Error: " + e.getMessage();
            }
        }
    }
       
