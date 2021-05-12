package com.tha.nguyenminhchi.model;

public class Weather {
    private String DateTime;
    private float EpochDateTime;
    private int WeatherIcon;
    private String IconPhrase;
    private boolean HasPrecipitation;
    private boolean IsDaylight;
    Temperature Temperature;
    private float PrecipitationProbability;
    private String MobileLink;
    private String Link;

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public float getEpochDateTime() {
        return EpochDateTime;
    }

    public void setEpochDateTime(float epochDateTime) {
        EpochDateTime = epochDateTime;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        WeatherIcon = weatherIcon;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
    }

    public boolean isHasPrecipitation() {
        return HasPrecipitation;
    }

    public void setHasPrecipitation(boolean hasPrecipitation) {
        HasPrecipitation = hasPrecipitation;
    }

    public boolean isDaylight() {
        return IsDaylight;
    }

    public void setDaylight(boolean daylight) {
        IsDaylight = daylight;
    }

    public com.tha.nguyenminhchi.model.Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(com.tha.nguyenminhchi.model.Temperature temperature) {
        Temperature = temperature;
    }

    public float getPrecipitationProbability() {
        return PrecipitationProbability;
    }

    public void setPrecipitationProbability(float precipitationProbability) {
        PrecipitationProbability = precipitationProbability;
    }

    public String getMobileLink() {
        return MobileLink;
    }

    public void setMobileLink(String mobileLink) {
        MobileLink = mobileLink;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
}
