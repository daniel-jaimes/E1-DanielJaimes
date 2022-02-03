package dao;

import model.Character;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;


public class MarshallPlayers {
    private model.Characters characters;
    public MarshallPlayers(ArrayList<Character> characters){
        model.Characters p = new model.Characters(characters);
        this.characters = p;
    }

    public void init() {
        try {
            JAXBContext context = JAXBContext.newInstance(model.Characters.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(characters, new File("files/salida3.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
