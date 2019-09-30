import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
public class MainMenu extends JFrame{
    private JPanel gridMain, flowMain, imagePanel;
    private JLabel gameColor, nameLabel;
    private JButton startButton;
    private JTextField nameTextField;
    private AllTimeScore t;

    public MainMenu(){

        //gridMain = new JPanel(new GridLayout(2,1));
        flowMain = new JPanel();
        imagePanel = new JPanel();
        startButton = new JButton("Play!");
            startButton.addActionListener(new playListener());
        nameLabel = new JLabel("Input name:");
        nameTextField = new JTextField("",20);

        try{
        BufferedImage image = ImageIO.read(new File("C:/Users/demyu/Desktop/Desktop/CSFILES/GameColor2/GameColor2/edited.png"));
        gameColor = new JLabel(new ImageIcon(image));
        }catch(Exception ae){
            
        }

        add(imagePanel, "Center");
            imagePanel.add(gameColor);
        add(flowMain, "South");
            flowMain.add(nameLabel);
            flowMain.add(nameTextField);
            flowMain.add(startButton);
            super.setBackground(Color.BLACK);
            setSize(1024,768);
            setResizable(false);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            t = new AllTimeScore();
    }

        private class playListener implements ActionListener{
            public void actionPerformed(ActionEvent ae){
                if(!nameTextField.getText().isEmpty()){
                    GUI temp = new GUI(nameTextField.getText(), t.getDB());
                    setVisible(false);
                    dispose();
                    t.setVisible(false);
                    t.dispose();
                }else
                JOptionPane.showMessageDialog(null, "Invalid Name");
            }
        }
}