

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Calculator implements ActionListener{
    

    JFrame f = new JFrame();
    JPanel button_panel = new JPanel();
    JPanel screen_panel = new JPanel();
    JButton buttons[] = new JButton[16];
    JLabel output = new JLabel();

    String number = " ";
    boolean dot = false;
    boolean multiplyon = false;
    boolean divideon = false;
    boolean pluson = true;
    boolean minuson = false;

    boolean start = true;

    double result = 0.0;
    DArray record = new DArray();



    Calculator(){
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000,1000);
        f.getContentPane().setBackground(new Color(50,50,50));
        f.setLayout(new BorderLayout());
        f.setVisible(true);

        output.setBackground(new Color(25,25,25));
        output.setForeground(new Color(25,255,0));
        output.setFont(new Font("Ink free",Font.BOLD,100));
        output.setHorizontalAlignment(JLabel.RIGHT);
        output.setText("Calculator        ");
        output.setOpaque(true);


        for(int i = 0; i < 16; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Ink free", Font.BOLD, 50));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        buttons[0].setText("7");
        buttons[1].setText("8");
        buttons[2].setText("9");
        buttons[4].setText("4");
        buttons[5].setText("5");
        buttons[6].setText("6");
        buttons[8].setText("1");
        buttons[9].setText("2");
        buttons[10].setText("3");
        buttons[12].setText("0");
        buttons[13].setText(".");
        buttons[14].setText("=");
        buttons[15].setText("+");
        buttons[11].setText("-");
        buttons[7].setText("x");
        buttons[3].setText("÷");

        screen_panel.setLayout(new BorderLayout());
        button_panel.setLayout(new GridLayout(4,4));
        button_panel.setBackground(new Color(150,150,150));

        screen_panel.add(output);

        f.add(screen_panel, "North");
        f.add(button_panel);

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e);
        }
        output.setText("0");


    }   

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == buttons[0]){
            number = number + "7";
            output.setText(number);
        }
        else if(e.getSource() == buttons[1]){
            number = number + "8";
            output.setText(number);
        }
        else if(e.getSource() == buttons[2]){
            number = number + "9";
            output.setText(number);
        }
        else if(e.getSource() == buttons[4]){
            number = number + "4";
            output.setText(number);
        }
        else if(e.getSource() == buttons[5]){
            number = number + "5";
            output.setText(number);
        }
        else if(e.getSource() == buttons[6]){
            number = number + "6";
            output.setText(number);
        }
        else if(e.getSource() == buttons[8]){
            number = number + "1";
            output.setText(number);
        }
        else if(e.getSource() == buttons[9]){
            number = number + "2";
            output.setText(number);
        }
        else if(e.getSource() == buttons[10]){
            number = number + "3";
            output.setText(number);
        }
        else if(e.getSource() == buttons[12]){
            number = number + "0";
            output.setText(number);
        }
        else if(e.getSource() == buttons[13] && dot == false){
            number = number + ".";
            output.setText(number);
            dot = true;
        }
        else{
        
            if(e.getSource() == buttons[15]){
                output.setText("+");
                pluson = true;

            }
            else if(e.getSource() == buttons[11]){
                output.setText("-");
                minuson = true;
            }

            else if(e.getSource() == buttons[7]){
                output.setText("x");
                multiplyon = true;          
            }
            else if(e.getSource() == buttons[3]){
                output.setText("÷");
                divideon = true;
            }


            if(multiplyon == true){
                if((e.getSource() == buttons[3] || e.getSource() == buttons[7]) && start == true){
                    result = Double.parseDouble(number);
                    start = false;
                }
                else{
                    result *= Double.parseDouble(number);
                    multiplyon = false;
                    record.append(result);
                }
            }
            else if(divideon == true){
                if((e.getSource() == buttons[3] || e.getSource() == buttons[7]) && start == true){
                    result = Double.parseDouble(number);
                    start = false;
                }
                else{
                    result /= Double.parseDouble(number);
                    divideon = false;
                    record.append(result);
                }
                
            }
            else if(pluson == true){
                record.append(Double.parseDouble(number));
                pluson = false;
            }
            else if(minuson == true){
                record.append(-Double.parseDouble(number));
                minuson = false;
            }
            if(e.getSource() == buttons[14]){
                output.setText(String.valueOf(record.sum()));
                record.clear();
            }
            number = "";
            

        }
        
    }
}


