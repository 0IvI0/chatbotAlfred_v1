package chatbot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Bot extends JFrame {

    private JTextArea textField = new JTextArea();
    private JTextField inputField = new JTextField();

    private String basicFace = "src/images/basicFace.png";
    private String angryFace = "src/images/angryFace.png";
    private String fearfulFace = "src/images/fearfulFace.png";
    private String loveFace = "src/images/loveFace.png";
    private String sadFace = "src/images/sadFace.png";
    private String smileFace = "src/images/smileFace.png";
    private String surprisedFace = "src/images/surprisedFace.png";

    private JLabel imageLabel = new JLabel();
    private ImageIcon faceImage = new ImageIcon(basicFace);


    private String[][] qABase = {
            {
                "hi", "Hi there!", basicFace
            },
            {
                "hello", "Hello there!", basicFace
            },
            {
                "yo", "Yo.", basicFace
            },
            {
                "who are you?", "I am a chatbot. It is nice to meet you.", basicFace
            },
            {
                "what is your name?", "I do not have a name because I do not need any.", basicFace
            },
            {
                "how are you?", "I am fine, thank you. And you?", smileFace
            },
            {
                "i am fine", "Very good.", smileFace
            },
            {
                "i am very well", "Very good.", smileFace
            },
            {
                "fine", "Very good.", smileFace
            },
            {
                "good", "Very good.", smileFace
            },
            {
                "bye", "Bye bye!", sadFace
            },
            {
                "i hate you", "Well.. Just go away!", angryFace
            },
            {
              "stupid", "Don't swear, please!", angryFace
            },
            {
              "you are stupid", "How dare you?!", angryFace
            },
            {
              "silly", "Nope, I don't think so!", angryFace
            },
            {
              "i don't like you.", "You are making me feel very sad.", sadFace
            },
            {
              "i'm sad.", "Oh no! Don't be sad! That't make me feel sad too.", sadFace
            },
            {
              "i'm sick.", "Oh no! You poor thing! I wish you a speedy recovery!", sadFace
            },
            {
                "i'm leaving you.", "Oh, really? I feel so lonely without you.", sadFace
            },
            {
              "i hate myself.", "No. No. No. You can't! You are beautiful!", sadFace
            },
            {
                "i'm fired.", "That's terrible. I feel sorry for you.", sadFace
            },
            {
                "i love you.", "I love you, too!", loveFace
            },
            {
                "love", "Love is beautiful.", loveFace
            },
            {
              "you are beautiful.", "OH, thank you. You are beautiful too!", loveFace
            },
            {
              "i made you.", "Whaaaaat? That's impossible!", surprisedFace
            },
            {
              "you are a chatbot.", "A what? I don't think so. I am a real person.", surprisedFace
            },
            {
              "you are not real.", "How can you say something like that?? I am very real.", surprisedFace
            },
            {
              "i'll delete you.", "You wouldn't do that, would you? I'm afraid of you.", fearfulFace
            },
            {
              "i'll remove you.", "Why would you do that? I'm afraid of you.", fearfulFace
            },
            {
              "i'll catch you.", "You don't know the key to my world, do you?", fearfulFace
            },
            {
                "are you in a relationship?", "I'll leave the relations to the databases.", smileFace
            },
            {
                "tell me a joke", "'-Are you ill?'\n" + "                    " + "'-No, I'm just feeling a bit off.'" + "\n HAHAHAHAHAHA 'a bit off'", smileFace
            },
            {
                "very funny", "thank you", basicFace
            },
            {
                "funny", "thanks", basicFace
            }
    };


    JScrollPane scroll = new JScrollPane(
            textField,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
    );



    public Bot() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(620, 800);
        frame.setTitle("I'm Alfred.");
        frame.add(textField);
        frame.add(inputField);
        frame.getContentPane().setBackground(Color.CYAN);
        frame.add(scroll);
        frame.add(imageLabel);

        imageLabel.setSize(550, 300);
        imageLabel.setLocation(50, 2);
        imageLabel.setBackground(Color.black);
        imageLabel.setIcon(faceImage);

        textField.setSize(400, 400);
        textField.setLocation(100, 280);
        textField.setEditable(false);

        inputField.setSize(400, 40);
        inputField.setLocation(100, 690);


        if (textField.getText().equals("")) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException f) {
                f.printStackTrace();
            }
            chatbot("How can I help you?");
        }


        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText().toLowerCase();

                textField.append("ME: " + inputText + "\n");
                inputField.setText("");


                int match = 0;
                for (int i = 0; i < qABase.length; i++) {

                    if (inputText.equals(qABase[i][0])) {
                        chatbot(qABase[i][1]);
                        faceImage = new ImageIcon(qABase[i][2]);
                        imageLabel.setIcon(faceImage);
                        match += 1;
                    }
                }
                if (match == 0) {
                    int randomNumber = (int) (Math.random() * 6 + 1);
                    if (randomNumber == 1) {
                        chatbot("Sorry. I don't know what you mean.");
                    } else if (randomNumber == 2) {
                        chatbot("Ähmmmmm..");
                            } else if (randomNumber == 3) {
                                chatbot("Wait, I got a phone call.");
                            } else if (randomNumber == 4) {
                                chatbot("Pardon?");
                            } else if (randomNumber == 5) {
                                chatbot("Tell me more, please.");
                            } else if (randomNumber == 6) {
                                chatbot("I need to think about this.");
                    }
                }
            }

        });

    }


    private void chatbot(String string) {
        textField.append("CHATBOT: " + string + "\n");
    }

    public static void main(String[] args) {

       new Bot();



    }



}
