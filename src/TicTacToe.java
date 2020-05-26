
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TicTacToe extends JFrame{
	
	ImageIcon iconCircle = new ImageIcon(getClass().getResource("circleMark.png"));
	ImageIcon iconMarket = new ImageIcon(getClass().getResource("xMarket.png"));

	JPanel panelDisplay = new JPanel(new GridLayout(3, 3, 10, 10));
	
	Cell[] cells = new Cell[9];
	
	int rounds = 0;
	
	final int PLAYER01 = 1;
	final int PLAYER02 = 2;
	
	int actualPlayer = PLAYER01;
	
	JLabel playerInfo = new JLabel("Player 0"+PLAYER01);
	
	public TicTacToe() {
		HandleWindow();
		configurarTela();
	}
	
	public void configurarTela() {
		add(BorderLayout.CENTER,panelDisplay);
		add(BorderLayout.NORTH,playerInfo);
		panelDisplay.setBackground(Color.LIGHT_GRAY);
		playerInfo.setFont(new Font("Arial",Font.BOLD,35));
		playerInfo.setForeground(Color.LIGHT_GRAY);
		playerInfo.setHorizontalAlignment(SwingConstants.CENTER);
		
		for(int i=0;i<9;i++) {
			Cell Cell = new Cell();
			cells[i] = Cell;
			panelDisplay.add(Cell);
		}
	}
	
	public void mudarVez(){
		if(actualPlayer==1) {
			actualPlayer=2;
			playerInfo.setText("Player 02");
			playerInfo.setForeground(Color.LIGHT_GRAY);
		} else {
			actualPlayer=1;
			playerInfo.setText("Player 01");
			playerInfo.setForeground(Color.LIGHT_GRAY);
		}
	}
	
	public boolean testarVitoria(int jog) {
		if(cells[0].who==jog && cells[1].who==jog && cells[2].who==jog) {
			return true;
		}
		if(cells[3].who==jog && cells[4].who==jog && cells[5].who==jog) {
			return true;
		}
		if(cells[6].who==jog && cells[7].who==jog && cells[8].who==jog) {
			return true;
		}
		if(cells[0].who==jog && cells[3].who==jog && cells[6].who==jog) {
			return true;
		}
		if(cells[1].who==jog && cells[4].who==jog && cells[7].who==jog) {
			return true;
		}
		if(cells[2].who==jog && cells[5].who==jog && cells[8].who==jog) {
			return true;
		}
		if(cells[0].who==jog && cells[4].who==jog && cells[8].who==jog) {
			return true;
		}
		if(cells[2].who==jog && cells[4].who==jog && cells[6].who==jog) {
			return true;
		}
		return false;
	}

	public void HandleWindow() {
		//setTitle("TicTacToe");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TicTacToe();
	}
	
	public class Cell extends JButton{
		int who = 0;
		public Cell() {
			setBackground(Color.WHITE);
			addActionListener(e -> {
				if(who==0) {
					if(actualPlayer==PLAYER01) {
						setIcon(iconCircle);
						who = PLAYER01;
					} else {
						setIcon(iconMarket);
						who = PLAYER02;
					}
					if(testarVitoria(who)) {
						JOptionPane.showMessageDialog(null,"Player 0"+who+" Win!");
						System.exit(0);
					}
					rounds++;
					if(rounds==9) {
						JOptionPane.showMessageDialog(null,"Draw!");
						System.exit(0);
					}
					mudarVez();
				}
			});
		}
	}
	
}