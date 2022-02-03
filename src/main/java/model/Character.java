package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="personaje")
public class Character {
    @XmlAttribute(name="id")
    private String id;
    @XmlAttribute(name="nombre")
    private String name;
    @XmlAttribute(name="juego")
    private String game;
    @XmlElement(name="company")
    private Company comp;
    public Character(){

    }
    public Character(String id, String name, String game, Company com) {
        this.id = id;
        this.name = name;
        this.game = game;
        this.comp = com;
    }

    @Override
    public String toString() {
        return "Personaje [" +
                "id=" + id +
                ", nombre=" + name +
                ", juego=" + game +
                ", company=" + comp +
                ']';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGame() {
        return game;
    }

    public Company getCompany() {
        return comp;
    }
}
