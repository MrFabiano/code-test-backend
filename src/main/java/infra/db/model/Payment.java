package infra.db.model;


import java.time.LocalDate;

public class Payment {

    private String device;
    private boolean releaseforuse;
    private String clientname;
    private LocalDate releasedate;

    // Construtor
    public Payment(String device, boolean releaseforuse, String clientname, LocalDate releasedate) {
        this.device = device;
        this.releaseforuse = releaseforuse;
        this.clientname = clientname;
        this.releasedate = releasedate;
    }

    // Getters e Setters
    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public boolean isReleaseforuse() {
        return releaseforuse;
    }

    public void setReleaseforuse(boolean releaseforuse) {
        this.releaseforuse = releaseforuse;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public LocalDate getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(LocalDate releasedate) {
        this.releasedate = releasedate;
    }
}

