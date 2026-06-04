package pekan8_2511532016;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension; 
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class MergeSort_GUI2511532016 extends JFrame {
    private static final long serialVersionUID = 1L;
    private int[] array_2016;
    private JLabel[] labelArray_2016;
    private JButton stepButton_2016, resetButton_2016, setButton_2016;
    private JTextField inputField_2016;
    private JPanel panelArray_2016;
    private JTextArea stepArea_2016;
    

    private boolean isMerging_2016;
    private boolean copying_2016;
    private int[] temp_2016;
    private int left_2016, mid_2016, right_2016;
    private int i_2016, j_2016, k_2016;
    private int stepCount_2016 = 1;
    
   
    private Queue<int[]> mergeQueue_2016 = new LinkedList<>();

    public MergeSort_GUI2511532016() {
        setTitle("Merge Sort Langkah per Langkah");
        setSize(750, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel input
        JPanel inputPanel_2016 = new JPanel(new FlowLayout());
        inputField_2016 = new JTextField(30);
        setButton_2016 = new JButton("Set Array");
        inputPanel_2016.add(new JLabel("Masukkan angka (pisahkan dengan koma) :"));
        inputPanel_2016.add(inputField_2016);
        inputPanel_2016.add(setButton_2016);

        // Panel array visual
        panelArray_2016 = new JPanel();
        panelArray_2016.setLayout(new FlowLayout());

        // Panel kontrol
        JPanel controlPanel_2016 = new JPanel();
        stepButton_2016 = new JButton("Langkah Selanjutnya");
        resetButton_2016 = new JButton("reset");
        stepButton_2016.setEnabled(false);
        controlPanel_2016.add(stepButton_2016);
        controlPanel_2016.add(resetButton_2016);

        // Area teks untuk log langkah
        stepArea_2016 = new JTextArea(0, 30);
        stepArea_2016.setEditable(false);
        stepArea_2016.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane_2016 = new JScrollPane(stepArea_2016);

        // Tambahkan panel ke frame
        add(inputPanel_2016, BorderLayout.NORTH);
        add(panelArray_2016, BorderLayout.CENTER);
        add(controlPanel_2016, BorderLayout.SOUTH);
        add(scrollPane_2016, BorderLayout.EAST);

        // Event Set Array
        setButton_2016.addActionListener(e -> setArrayFromInput_2016());

        // Event Langkah Selanjutnya
        stepButton_2016.addActionListener(e -> performStep_2016()); 

        // Event reset
        resetButton_2016.addActionListener(e -> reset_2016());
    }

    private void setArrayFromInput_2016() {
        String text_2016 = inputField_2016.getText().trim();
        if (text_2016.isEmpty()) return;
        String[] parts_2016 = text_2016.split(",");
        array_2016 = new int[parts_2016.length];
        try {
            for (int i_2016 = 0; i_2016 < parts_2016.length; i_2016++) {
                array_2016[i_2016] = Integer.parseInt(parts_2016[i_2016].trim());
            }
        } catch (NumberFormatException e_2016) {
            JOptionPane.showMessageDialog(this, "Masukkan hanya angka!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        labelArray_2016 = new JLabel[array_2016.length];
        panelArray_2016.removeAll();
        for (int i_2016 = 0; i_2016 < array_2016.length; i_2016++) {
            labelArray_2016[i_2016] = new JLabel(String.valueOf(array_2016[i_2016]));
            labelArray_2016[i_2016].setFont(new Font("Arial", Font.BOLD, 24));
            labelArray_2016[i_2016].setOpaque(true);
            labelArray_2016[i_2016].setBackground(Color.WHITE);
            labelArray_2016[i_2016].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelArray_2016[i_2016].setPreferredSize(new Dimension(50, 50));
            labelArray_2016[i_2016].setHorizontalAlignment(SwingConstants.CENTER);
            panelArray_2016.add(labelArray_2016[i_2016]);
        }
        
        mergeQueue_2016.clear();
        generateMergeSteps_2016(0, array_2016.length - 1);
        stepButton_2016.setEnabled(true);
        stepArea_2016.setText("");
        stepCount_2016 = 1;
        isMerging_2016 = false;
        copying_2016 = false;
        panelArray_2016.revalidate();
        panelArray_2016.repaint();
    }


    private void generateMergeSteps_2016(int l_2016, int r_2016) {
        if (l_2016 < r_2016) {
            int m_2016 = l_2016 + (r_2016 - l_2016) / 2;
            generateMergeSteps_2016(l_2016, m_2016);
            generateMergeSteps_2016(m_2016 + 1, r_2016);
            mergeQueue_2016.add(new int[]{l_2016, m_2016, r_2016});
        }
    }

    private void performStep_2016() {
        resetHighlights_2016();
        
        if (copying_2016 && k_2016 < temp_2016.length) {
            array_2016[left_2016 + k_2016] = temp_2016[k_2016];
            labelArray_2016[left_2016 + k_2016].setText(String.valueOf(temp_2016[k_2016]));
            labelArray_2016[left_2016 + k_2016].setBackground(Color.GREEN);
            k_2016++;
            stepArea_2016.append("Langkah " + stepCount_2016++ + ": Tempelkan ke array utama\n");
            return;
        }
        
        if (copying_2016 && k_2016 == temp_2016.length) {
            isMerging_2016 = false;
            copying_2016 = false;
        }
        
        if (mergeQueue_2016.isEmpty() && !isMerging_2016) {
            stepArea_2016.append("Selesai.\n");
            stepButton_2016.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Merge Sort selesai!");
            return;
        }
        
        if (!isMerging_2016 && !mergeQueue_2016.isEmpty()) {
            int[] range_2016 = mergeQueue_2016.poll();
            left_2016 = range_2016[0];
            mid_2016 = range_2016[1];
            right_2016 = range_2016[2];
            temp_2016 = new int[right_2016 - left_2016 + 1];
            i_2016 = left_2016;
            j_2016 = mid_2016 + 1;
            k_2016 = 0;
            copying_2016 = false;
            isMerging_2016 = true;
            stepArea_2016.append("Langkah " + stepCount_2016++ + 
                    ": Mulai merge dari " + left_2016 + " ke " + right_2016 + "\n");
            return;
        }
        
        if (isMerging_2016 && !copying_2016) {
            if (i_2016 <= mid_2016 && j_2016 <= right_2016) {
                labelArray_2016[i_2016].setBackground(Color.CYAN);
                labelArray_2016[j_2016].setBackground(Color.CYAN);
                if (array_2016[i_2016] <= array_2016[j_2016]) {
                    temp_2016[k_2016++] = array_2016[i_2016++];
                } else {
                    temp_2016[k_2016++] = array_2016[j_2016++];
                }
                stepArea_2016.append("Langkah " + stepCount_2016++ + ": Bandingkan dan salin elemen\n");
                return;
            } else if (i_2016 <= mid_2016) {
                temp_2016[k_2016++] = array_2016[i_2016++];
                stepArea_2016.append("Langkah " + stepCount_2016++ + ": Salin sisa kiri\n");
                return;
            } else if (j_2016 <= right_2016) {
                temp_2016[k_2016++] = array_2016[j_2016++];
                stepArea_2016.append("Langkah " + stepCount_2016++ + ": Salin sisa kanan\n");
                return;
            } else {
                copying_2016 = true;
                k_2016 = 0;
                return;
            }
        }
    }

    private void resetHighlights_2016() {
        if (labelArray_2016 == null) return;
        for (JLabel label_2016 : labelArray_2016) {
            label_2016.setBackground(Color.WHITE);
        }
    }

    private void reset_2016() {
        inputField_2016.setText("");
        panelArray_2016.removeAll();
        panelArray_2016.revalidate();
        panelArray_2016.repaint();
        stepArea_2016.setText("");
        stepButton_2016.setEnabled(false);
        mergeQueue_2016.clear();
        isMerging_2016 = false;
        copying_2016 = false;
        stepCount_2016 = 1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            
        	MergeSort_GUI2511532016 gui_2016 = new MergeSort_GUI2511532016();
            gui_2016.setVisible(true);
        });
    }
}