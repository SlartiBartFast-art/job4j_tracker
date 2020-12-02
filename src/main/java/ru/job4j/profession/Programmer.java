package ru.job4j.profession;

public class Programmer extends Engineer {
    private String language;
    private String developmentEnvironment;

    public Programmer(String name, String surname, String education, String birthday, int level, String language, String developmentEnvironment) {
        super(name, surname, education, birthday, level);
        this.language = language;
        this.developmentEnvironment = developmentEnvironment;
    }

    public String getLanguage() {
        return language;
    }

    public String getDevelopmentEnvironment() {
        return developmentEnvironment;
    }
}
