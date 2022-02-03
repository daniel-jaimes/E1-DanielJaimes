package manager;

import dao.InputReader;
import dao.MarshallPlayers;
import dao.OutputDOM;
import dao.OutputWriter;
import model.Character;
import model.Company;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    ArrayList<model.Character> characters;
    public Controller(){
        characters = new ArrayList<>();
    }
    public void init() {
        readPlayers();
        writeOutput();
        writeDOMOutput();
        writeJAXBOutput();
    }

    private void writeJAXBOutput() {
        List<Character> chars = new ArrayList<>();
        chars = characters.stream()
                .filter(g -> g.getCompany().getName().equals("Sony") ||
                        g.getCompany().getName().equals("Sega") ||
                        g.getCompany().getName().equals("Bandai"))
                .collect(Collectors.toList());
        MarshallPlayers MP = new MarshallPlayers((ArrayList<Character>) chars);
        MP.init();
    }

    private void writeDOMOutput() {
        OutputDOM OD = new OutputDOM();
        Document doc = OD.getDocument();
        Element characters = doc.createElement("personajes");
        doc.appendChild(characters);
        this.characters.forEach(guy -> {
            String comp = guy.getCompany().getName();
            boolean can = comp.equals("Microsoft") ||
                    comp.equals("Ubisoft") ||
                    comp.equals("Square");
            if(can){
                Element charac = doc.createElement("personaje");
                Element game = doc.createElement("juego");
                game.setAttribute("protagonista", guy.getName());
                game.appendChild(doc.createTextNode(guy.getGame()));
                charac.appendChild(game);
                Element company = doc.createElement("company");
                company.setAttribute("nombre", guy.getCompany().getName());
                company.appendChild(doc.createTextNode(guy.getCompany().getYear()));
                charac.appendChild(company);
                characters.appendChild(charac);
            }
        });
        OD.generateXml();
    }

    private void writeOutput() {
        OutputWriter OW = new OutputWriter();
        this.characters.forEach(guy -> {
            if(guy.getCompany().getName().equals("Nintendo")){
                OW.writeLine(guy.toString());
            }
        });
        OW.close();
    }

    private void readPlayers() {
        InputReader IR = new InputReader();
        String str;
        while((str = IR.readLine()) != null){
            model.Character ch = createPlayer(str);
            characters.add(ch);
        }
        IR.close();
    }

    private Character createPlayer(String str) {
        str = str.replace("\"", "");
        str = str.replace("\'", "");
        str = str.trim();
        String[] player = str.split(" - ");
        System.out.println(str);
        String id = player[0];
        String name = player[1];
        String game = player[2];
        String company = player[3];
        String year = player[4];
        return new model.Character(id, name, game, new Company(company, year));
    }
}
