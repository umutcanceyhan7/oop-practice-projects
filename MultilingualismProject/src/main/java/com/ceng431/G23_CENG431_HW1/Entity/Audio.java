package main.java.com.ceng431.G23_CENG431_HW1.Entity;


public  class Audio {
    private int seconds;

    public Audio(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "seconds=" + seconds +
                '}';
    }
}
