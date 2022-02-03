package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class Company {
    @XmlAttribute(name="ano")
    private String year;
    @XmlValue
    private String name;

    public Company(String company, String year) {
        name = company;
        this.year = year;
    }

    @Override
    public String toString() {
        return name +
                ", ano=" + year;
    }

    public String getYear() {
        return year;
    }

    public String getName() {
        return name;
    }
}
