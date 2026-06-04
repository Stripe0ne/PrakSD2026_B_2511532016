package pekan8_2511532016;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class BubbleSort_GUI2511532016 extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private int[] array_2016;
	private JLabel[] labelArray_2016;
	private JButton stepButton_2016, resetButton_2016, setButton_2016;
	private JTextField inputField_2016;
	private JPanel panelArray_2016;
	private JTextArea stepArea_2016;
	private int i_2016 =1, j_2016;
	private boolean sorting_2016 = false;
	private int stepCount_2016 =1;
		
	public BubbleSort_GUI2511532016() {
		setTitle("Bubbble Sort Langkah per Langkah");
		setSize(750, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		//Panel Input
		JPanel inputPanel_2016 = new JPanel(new FlowLayout());
		inputField_2016 = new JTextField(30);
		setButton_2016 = new JButton("Set Array");
		inputPanel_2016.add(new JLabel("Masukkan angka (pisahkan dengan koma)"));
		inputPanel_2016.add(inputField_2016);
		inputPanel_2016.add(setButton_2016);
		
		//Panel Array visual
		panelArray_2016 = new JPanel();
		panelArray_2016.setLayout(new FlowLayout());
		
		//Panel Kontrol
		JPanel controlPanel_2016 =new JPanel();
		stepButton_2016 = new JButton("Langkah selanjutnya");
		resetButton_2016 = new JButton("Reset");
		stepButton_2016.setEnabled(false);
		controlPanel_2016.add(stepButton_2016);
		controlPanel_2016.add(resetButton_2016);
		
		//Area teks untuk log langkah-langkah
		stepArea_2016 = new JTextArea(8,60);
		stepArea_2016.setEditable(false);
		stepArea_2016.setFont(new Font("Monospaced", Font.PLAIN, 14));
		JScrollPane scrollPane_2016 = new JScrollPane(stepArea_2016);
		
		//Tambahkan panel ke frame
		add(inputPanel_2016, BorderLayout.NORTH);
		add(panelArray_2016, BorderLayout.CENTER);
		add(controlPanel_2016, BorderLayout.SOUTH);
		add(scrollPane_2016, BorderLayout.EAST);
		
		//Event set array
		setButton_2016.addActionListener( e-> setArrayFromInput_2016());

		//Event set array
		stepButton_2016.addActionListener( e-> performStep_2016());
		
		//Event set array
		resetButton_2016.addActionListener( e-> resetHighlights_2016());
	}
	
	
	
private void setArrayFromInput_2016() {
	String text_2016 = inputField_2016.getText().trim();
	if(text_2016.isEmpty()) return;
	String[] parts_2016 = text_2016.split(",");
	array_2016 = new int[parts_2016.length];
	try {
		for(int k_2016=0; k_2016< parts_2016.length; k_2016++) {
			array_2016[k_2016] = Integer.parseInt(parts_2016[k_2016].trim());}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Masukan hanya angka yang dipisahkan dengan koma!","Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		i_2016=0;
		j_2016 =0;
		stepCount_2016 = 1;
		sorting_2016 = true;
		stepButton_2016.setEnabled(true);
		stepArea_2016.setText("");
		panelArray_2016.removeAll();
		labelArray_2016 = new JLabel[array_2016.length];
		for(int k_2016=0; k_2016<array_2016.length; k_2016++) {
			labelArray_2016[k_2016] = new JLabel(String.valueOf(array_2016[k_2016]));
			labelArray_2016[k_2016].setFont(new Font("Arial", Font.BOLD, 24));
			labelArray_2016[k_2016].setOpaque(true);
			labelArray_2016[k_2016].setBackground(Color.white);
			labelArray_2016[k_2016].setBorder(BorderFactory.createLineBorder(Color.black));
			labelArray_2016[k_2016].setPreferredSize(new Dimension(50,50));	
			labelArray_2016[k_2016].setHorizontalAlignment(SwingConstants.CENTER);
			panelArray_2016.add(labelArray_2016[k_2016]);			                
	}
		panelArray_2016.revalidate();
		panelArray_2016.repaint();
}

private void performStep_2016() {
    if (!sorting_2016 || i_2016 >= array_2016.length - 1) {
        sorting_2016 = false;
        stepButton_2016.setEnabled(false);
        JOptionPane.showMessageDialog(this, "Sorting selesai!");
        return;
    }
    resetHighlights_2016();
    StringBuilder stepLog_2016 = new StringBuilder();
    labelArray_2016[j_2016].setBackground(Color.CYAN);
    labelArray_2016[j_2016 + 1].setBackground(Color.CYAN);
    if (array_2016[j_2016] > array_2016[j_2016 + 1]) {
        int temp_2016 = array_2016[j_2016];
        array_2016[j_2016] = array_2016[j_2016 + 1];
        array_2016[j_2016 + 1] = temp_2016;
        labelArray_2016[j_2016].setBackground(Color.RED);
        labelArray_2016[j_2016 + 1].setBackground(Color.RED);
        stepLog_2016.append("Langkah ").append(stepCount_2016).append(": Menukar elemen ke-")
               .append(j_2016).append(" (").append(array_2016[j_2016 + 1]).append(") dengan elemen ke-")
               .append(j_2016 + 1).append(" (").append(array_2016[j_2016]).append(")\n");
    } else {
        stepLog_2016.append("Langkah ").append(stepCount_2016).append(": Tidak ada pertukaran antara ke-")
               .append(j_2016).append(" dan ke-").append(j_2016 + 1).append("\n");
    }
    stepLog_2016.append("Hasil: ").append(arrayToString_2016(array_2016)).append("\n\n");
    stepArea_2016.append(stepLog_2016.toString());
    updateLabels_2016();
    j_2016++;
    if (j_2016 >= array_2016.length - i_2016 - 1) {
        j_2016 = 0;
        i_2016++;
    }
    stepCount_2016++;
    if (i_2016 >= array_2016.length - 1) {
        sorting_2016 = false;
        stepButton_2016.setEnabled(false);
        JOptionPane.showMessageDialog(this, "Sorting selesai!");
    }
}

	private void updateLabels_2016() {
		for(int k_2016=0; k_2016<array_2016.length; k_2016++) {
			labelArray_2016[k_2016].setText(String.valueOf(array_2016[k_2016]));
		}
	}
	
	private void resetHighlights_2016() {
		inputField_2016.setText("");
		panelArray_2016.removeAll();
		panelArray_2016.revalidate();
		panelArray_2016.repaint();
		stepArea_2016.setText("");
		stepButton_2016.setEnabled(false);
		sorting_2016 = false;
		i_2016=0;
		j_2016=0;
		stepCount_2016 = 1;
		}
	
	private String arrayToString_2016(int[] arr_2016) {
		StringBuilder sb_2016 = new StringBuilder();
		for(int k_2016=0; k_2016< array_2016.length; k_2016++) {
			sb_2016.append(arr_2016[k_2016]);
			if(k_2016<arr_2016.length -1) sb_2016.append(", ");
		}
		return sb_2016.toString();
		}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			BubbleSort_GUI2511532016 gui_2016 = new BubbleSort_GUI2511532016();
			gui_2016.setVisible(true);
		});
	}
}
	

