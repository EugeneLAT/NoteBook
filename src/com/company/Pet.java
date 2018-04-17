package com.company;

import java.time.LocalDate;

public class Pet extends Record implements WithBirthday{

    private String name;
    private String species;
    private LocalDate birthday;

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }



    public void askUserData() {
        String name = Main.askString("Nickname: ");
        String species = Main.askString("Species: ");
        LocalDate birthday = Main.askDate("Birthday: ");

        setName(name);
        setSpecies(species);
        setBirthday(birthday);
    }

    @Override
    public String toString() {
        String strBirthday = Main.DATE_FORMATTER.format(getBirthday());
        return "Pet{" +
                "ID='" + getId() + '\'' +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", birthday='" + strBirthday + '\'' +
                '}';
    }

    @Override
    public boolean contains(String part) {
        String strBirthday = Main.DATE_FORMATTER.format(getBirthday());
        return name.contains(part)
                || species.contains(part)
                || strBirthday.contains(part);
    }
}
