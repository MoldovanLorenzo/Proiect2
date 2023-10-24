import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GradinaZoo extends JFrame {
    private JButton adaugaAnimalButton;
    private JButton adaugaHranaButton;
    private JButton afiseazaAnimalButton;
    private JButton adaugaLaFavoriteButton;
    private JButton afiseazaFavoriteButton;
    private ArrayList<Animal> listaAnimale;
    private ArrayList<Animal> listaFavorite;
    private JTextField tipTextField;
    private JTextField numeTextField;
    private JTextField varstaTextField;
    private JTextField taraOrigineTextField;
    private JCheckBox mamiferCheckBox;
    private JTextField hranesteNumeTextField;
    private JTextField adaugaLaFavoriteTextField;
    private JTextArea textArea;

    public GradinaZoo() {
        super("Gradina Zoo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLayout(null);
        listaAnimale = new ArrayList<>();
        listaFavorite = new ArrayList<>();

        JLabel tipLabel = new JLabel("Tip animal:");
        tipLabel.setBounds(50, 100, 150, 30);
        add(tipLabel);

        tipTextField = new JTextField();
        tipTextField.setBounds(200, 100, 150, 30);
        add(tipTextField);

        JLabel numeLabel = new JLabel("Nume animal:");
        numeLabel.setBounds(50, 150, 150, 30);
        add(numeLabel);

        numeTextField = new JTextField();
        numeTextField.setBounds(200, 150, 150, 30);
        add(numeTextField);

        JLabel varstaLabel = new JLabel("Varsta animal:");
        varstaLabel.setBounds(50, 200, 150, 30);
        add(varstaLabel);

        varstaTextField = new JTextField();
        varstaTextField.setBounds(200, 200, 150, 30);
        add(varstaTextField);

        JLabel taraOrigineLabel = new JLabel("Tara de origine:");
        taraOrigineLabel.setBounds(50, 250, 150, 30);
        add(taraOrigineLabel);

        taraOrigineTextField = new JTextField();
        taraOrigineTextField.setBounds(200, 250, 150, 30);
        add(taraOrigineTextField);

        mamiferCheckBox = new JCheckBox("Este mamifer?");
        mamiferCheckBox.setBounds(50, 300, 150, 30);
        add(mamiferCheckBox);

        adaugaAnimalButton = new JButton("Adauga animal");
        adaugaAnimalButton.setBounds(400, 150, 150, 30);
        add(adaugaAnimalButton);

        JLabel hranesteLabel = new JLabel("Numele animalului pe care vrei sa-l hranesti:");
        hranesteLabel.setBounds(50, 400, 250, 30);
        add(hranesteLabel);

        hranesteNumeTextField = new JTextField();
        hranesteNumeTextField.setBounds(300, 400, 150, 30);
        add(hranesteNumeTextField);

        adaugaHranaButton = new JButton("Hraneste animal");
        adaugaHranaButton.setBounds(450, 400, 150, 30);
        add(adaugaHranaButton);

        JLabel adaugaLaFavoriteLabel = new JLabel("Adauga animal la favorite:");
        adaugaLaFavoriteLabel.setBounds(50, 450, 200, 30);
        add(adaugaLaFavoriteLabel);

        adaugaLaFavoriteTextField = new JTextField();
        adaugaLaFavoriteTextField.setBounds(250, 450, 150, 30);
        add(adaugaLaFavoriteTextField);

        adaugaLaFavoriteButton = new JButton("Adauga la favorite");
        adaugaLaFavoriteButton.setBounds(400, 450, 150, 30);
        add(adaugaLaFavoriteButton);

        afiseazaAnimalButton = new JButton("Afiseaza animale");
        afiseazaAnimalButton.setBounds(400, 200, 150, 30);
        add(afiseazaAnimalButton);

        afiseazaFavoriteButton = new JButton("Afiseaza favorite");
        afiseazaFavoriteButton.setBounds(250, 500, 150, 30);
        add(afiseazaFavoriteButton);

        textArea = new JTextArea();
        textArea.setBounds(600, 100, 500, 380);
        add(textArea);

        adaugaAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adaugaAnimal();
            }
        });

        adaugaHranaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hranesteAnimal();
            }
        });

        adaugaLaFavoriteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adaugaLaFavorite();
            }
        });

        afiseazaAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afiseazaAnimale();
            }
        });

        afiseazaFavoriteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afiseazaFavorite();
            }
        });

        setVisible(true);
    }

    private void adaugaAnimal() {
        String tip = tipTextField.getText();
        String nume = numeTextField.getText();
        int varsta = Integer.parseInt(varstaTextField.getText());
        String taraOrigine = taraOrigineTextField.getText();
        boolean mamifer = mamiferCheckBox.isSelected();

        Animal animal = new Animal(tip, nume, varsta, taraOrigine, mamifer);
        listaAnimale.add(animal);
        tipTextField.setText("");
        numeTextField.setText("");
        varstaTextField.setText("");
        taraOrigineTextField.setText("");
        mamiferCheckBox.setSelected(false);
    }

    private void hranesteAnimal() {
        String nume = hranesteNumeTextField.getText();
        for (Animal animal : listaAnimale) {
            if (animal.getNume().equals(nume)) {
                textArea.setText(animal.hranesteAnimal());
                return;
            }
        }
        textArea.setText("Animalul cu numele " + nume + " nu a fost gasit.");
    }

    private void adaugaLaFavorite() {
        String nume = adaugaLaFavoriteTextField.getText();
        for (Animal animal : listaAnimale) {
            if (animal.getNume().equals(nume)) {
                listaFavorite.add(animal);
                textArea.setText("Animalul cu numele " + nume + " a fost adaugat la favorite.");
                return;
            }
        }
        textArea.setText("Animalul cu numele " + nume + " nu a fost gasit.");
    }

    private void afiseazaAnimale() {
        StringBuffer animalList = new StringBuffer();
        for (Animal animal : listaAnimale) {
            animalList.append(animal.toString()).append("\n");
        }
        textArea.setText(animalList.toString());
    }

    private void afiseazaFavorite() {
        StringBuffer favoriteList = new StringBuffer("Animalele tale favorite sunt: ");
        for (Animal animal : listaFavorite) {
            favoriteList.append(animal.getNume()).append(", ");
        }
        textArea.setText(favoriteList.toString());
    }
}
