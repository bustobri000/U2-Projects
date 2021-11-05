import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RPGCharacterGUI {

    //gui
    public static JFrame frame;
    public static JPanel panel;
    public static JTextField stat1Input = new JTextField(3);
    public static JTextField stat2Input = new JTextField(3);
    public static JTextField stat3Input = new JTextField(3);
    public static JTextField stat4Input = new JTextField(3);
    public static JTextField stat5Input = new JTextField(2);
    public static JTextField stat6Input = new JTextField(3);

    //stats
    public static int dexterity;
    public static int health;
    public static int strength;
    public static int love;
    public static int fingersX;
    public static int intelligence;

    //labels
    public static JLabel HP = new JLabel("You stats would go here, IF YOU HAD ANY FILL IN THE BLANKS AND PRESS THE BUTTON");
    public static JLabel str = new JLabel();
    public static JLabel spd = new JLabel();
    public static JLabel fingers = new JLabel();
    public static JLabel aim = new JLabel();
    public static JLabel luck = new JLabel();
    public static JLabel intl = new JLabel();
    public static JLabel mgc = new JLabel();

    //gui making
    public RPGCharacterGUI(){
        frame = new JFrame("Creative Name");
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();

        //Raw Stat 1 - Dex
        JLabel stat1Label = new JLabel("The World Spins and Spins, but how many degrees will you spin?");
        //Raw Stat 2 - Health
        JLabel stat2Label = new JLabel("The Fear Inside Your Heart Runs Rampant, but how many times does your heart beat?");
        //Raw Stat 3 - Strength
        JLabel stat3Label = new JLabel("Hate is what Controls the World, but how much do you want to obliterate small animals?");
        //Raw Stat 4 - Love
        JLabel stat4Label = new JLabel("Green is not a Creative Color, but how much do you like the color pink?");
        //Raw Stat 5 - Fingers
        JLabel stat5Label = new JLabel("All Good Friends Will Sacrifice Parts of Themselves for You, but how many fingers will you sacrifice for them?");
        //Raw Stat 6 - Intelligence
        JLabel stat6Label = new JLabel("A Puppet is Held by Strings, so how many hold you?");

        JButton magicButton = new JButton("Magically Create Non-Random Numbers");
        magicButton.addActionListener(new magicListener());

        //inputs and labels
        panel.add(stat1Label);
        panel.add(stat1Input);
        panel.add(stat2Label);
        panel.add(stat2Input);
        panel.add(stat3Label);
        panel.add(stat3Input);
        panel.add(stat4Label);
        panel.add(stat4Input);
        panel.add(stat5Label);
        panel.add(stat5Input);
        panel.add(stat6Label);
        panel.add(stat6Input);

        panel.add(magicButton);

        panel.add(HP);
        panel.add(str);
        panel.add(spd);
        panel.add(fingers);
        panel.add(aim);
        panel.add(luck);
        panel.add(intl);
        panel.add(mgc);

        frame.add(panel);
        frame.setVisible(true);
    }

    //Magic Button
    private static class magicListener implements ActionListener{

        public void actionPerformed(ActionEvent e){
            panel.setBackground(Color.GREEN);
            useMe();
            statCalc();

            HP.setText("Your HP is " + health);
            str.setText("Your Strength is " + strength);
            spd.setText("Your Speed is " + dexterity * 3);

            if (fingersX < 0 ){
                fingers.setText("You are in finger debt: (" + fingersX + ") please get that checked out!");
            } else{
                fingers.setText("You have " + fingersX + " fingers remaining.");
            }
            aim.setText("Your aim is " + (fingersX * 8 + intelligence) + "%");
            luck.setText("Your luck is " + love + "%");
            intl.setText("Your Intelligence is " + intelligence);
            mgc.setText("Your Magic power is " + (intelligence * 5 + love - (strength*15)));
        }
    }

    //Taking inputs and converting them to a usable form for
    public static void useMe(){
        dexterity = Integer.parseInt(stat1Input.getText());
        health = Integer.parseInt(stat2Input.getText());
        strength = Integer.parseInt(stat3Input.getText());
        love = Integer.parseInt(stat4Input.getText());
        fingersX = Integer.parseInt(stat5Input.getText());
        intelligence = Integer.parseInt(stat6Input.getText());

    }

    //the Math
    public static void statCalc(){
        dexterity = dexterity + strength;
        if (health <= 25) {
            health = 25;
        } else {
            health = health * 2 + strength;
        }
        strength = (strength + health) - (fingersX * 15) + dexterity;
        fingersX = 10 - fingersX;
        love = 100 - (love - health) - (fingersX * 15);
        intelligence = (intelligence * 5) + (health * 2) + (fingersX * 3) - love;
    }
}
