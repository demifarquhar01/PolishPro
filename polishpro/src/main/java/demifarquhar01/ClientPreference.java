package demifarquhar01;

public class ClientPreference {
    private String preferenceId;
    private String preferences;
    private String notes;

    // Constructor to initialize ClientPreference object
    public ClientPreference(String preferenceId, String preferences, String notes) {
        this.preferenceId = preferenceId;
        this.preferences = preferences;
        this.notes = notes;
    }

    // Method to check the current preferences and notes
    public void checkPreferences() {
        System.out.println("Preference ID: " + preferenceId);
        System.out.println("Preferences: " + preferences);
        System.out.println("Notes: " + notes);
    }

    // Method to update preferences and notes
    public void updatePreferences(String preferences, String notes) {
        this.preferences = preferences;
        this.notes = notes;
        System.out.println("Preferences and notes updated.");
    }

    // Getter and Setter for preferenceId
    public String getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(String preferenceId) {
        this.preferenceId = preferenceId;
    }

    // Getter and Setter for notes
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    // Getter and Setter for preferences
    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }
}
