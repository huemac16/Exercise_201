
import java.time.LocalDate;
import java.time.LocalTime;

public class Measurement {
    private LocalDate date;
    private LocalTime time;
    private String license;
    private int vel;
    private int allowed;

    public Measurement(LocalDate date, LocalTime time, String license, int vel, int allowed) {
        this.date = date;
        this.time = time;
        this.license = license;
        this.vel = vel;
        this.allowed = allowed;
    }
    
    public int getVelocityDifference(){
        return vel - allowed;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getLicense() {
        return license;
    }

    public int getVel() {
        return vel;
    }

    public int getAllowed() {
        return allowed;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setVel(int vel) {
        this.vel = vel;
    }

    public void setAllowed(int allowed) {
        this.allowed = allowed;
    }
    
    
}