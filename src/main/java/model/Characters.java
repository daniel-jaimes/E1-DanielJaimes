package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name="personajes")
public class Characters {
    public Characters(){

    }
    @XmlElement(name="personaje")
    private ArrayList<Character> characters;
    public Characters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }
}
