package pekan9_2511532016;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import java.util.List;


public class PetaBandara_GUI2511532016 extends JFrame {

    // ========================
    // INNER CLASS: Graph
    // ========================
    static class Graph_2016 {
        private final Map<String, List<String>> adjList_2016 = new LinkedHashMap<>();
        private final Map<String, int[]> positions_2016 = new LinkedHashMap<>();

        void addVertex_2016(String name_2016, int x_2016, int y_2016) {
            adjList_2016.putIfAbsent(name_2016, new ArrayList<>());
            positions_2016.put(name_2016, new int[]{x_2016, y_2016});
        }

        void addEdge_2016(String a_2016, String b_2016) {
            adjList_2016.get(a_2016).add(b_2016);
            adjList_2016.get(b_2016).add(a_2016);
        }

        Set<String> getVertices_2016() {
            return adjList_2016.keySet();
        }

        List<String> getNeighbors_2016(String node_2016) {
            return adjList_2016.getOrDefault(node_2016, Collections.emptyList());
        }

        int[] getPosition_2016(String node_2016) {
            return positions_2016.get(node_2016);
        }

        List<String[]> getAllEdges_2016() {
            List<String[]> edges_2016 = new ArrayList<>();
            Set<String> seen_2016 = new HashSet<>();
            for (String u_2016 : adjList_2016.keySet()) {
                for (String v_2016 : adjList_2016.get(u_2016)) {
                    String key_2016 = u_2016.compareTo(v_2016) < 0
                            ? u_2016 + "|" + v_2016
                            : v_2016 + "|" + u_2016;
                    if (seen_2016.add(key_2016)) {
                        edges_2016.add(new String[]{u_2016, v_2016});
                    }
                }
            }
            return edges_2016;
        }
    }

    // ========================
    // INNER CLASS: GraphPanel
    // ========================
    class GraphPanel_2016 extends JPanel {
        private Map<String, Color> nodeColors_2016 = new HashMap<>();
        private List<String> pathNodes_2016 = new ArrayList<>();

        GraphPanel_2016() {
            setBackground(new Color(15, 20, 40));
            setPreferredSize(new Dimension(820, 420));
        }

        void setNodeColors_2016(Map<String, Color> colors_2016) {
            this.nodeColors_2016 = colors_2016;
            repaint();
        }

        void setPath_2016(List<String> path_2016) {
            this.pathNodes_2016 = path_2016;
            repaint();
        }

        void reset_2016() {
            nodeColors_2016.clear();
            pathNodes_2016.clear();
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g_2016) {
            super.paintComponent(g_2016);
            Graphics2D g2_2016 = (Graphics2D) g_2016;
            g2_2016.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2_2016.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            // Draw grid background
            g2_2016.setColor(new Color(30, 40, 70, 60));
            for (int xi = 0; xi < getWidth(); xi += 40) {
                g2_2016.drawLine(xi, 0, xi, getHeight());
            }
            for (int yi = 0; yi < getHeight(); yi += 40) {
                g2_2016.drawLine(0, yi, getWidth(), yi);
            }

            // Draw title
            g2_2016.setColor(new Color(100, 180, 255, 120));
            g2_2016.setFont(new Font("Arial", Font.BOLD, 11));
            g2_2016.drawString("PETA BANDARA INTERNASIONAL", 10, 18);

            // Draw edges
            List<String[]> edges_2016 = graph_2016.getAllEdges_2016();
            for (String[] edge_2016 : edges_2016) {
                int[] posA = graph_2016.getPosition_2016(edge_2016[0]);
                int[] posB = graph_2016.getPosition_2016(edge_2016[1]);
                if (posA == null || posB == null) continue;

                boolean isPathEdge = isPathEdge_2016(edge_2016[0], edge_2016[1]);
                if (isPathEdge) {
                    g2_2016.setColor(new Color(255, 220, 50));
                    g2_2016.setStroke(new BasicStroke(3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                } else {
                    g2_2016.setColor(new Color(80, 130, 200, 180));
                    g2_2016.setStroke(new BasicStroke(1.5f));
                }
                g2_2016.drawLine(posA[0], posA[1], posB[0], posB[1]);
            }

            // Draw nodes
            int radius_2016 = 28;
            for (String node_2016 : graph_2016.getVertices_2016()) {
                int[] pos_2016 = graph_2016.getPosition_2016(node_2016);
                if (pos_2016 == null) continue;

                int x_2016 = pos_2016[0] - radius_2016;
                int y_2016 = pos_2016[1] - radius_2016;

                // Determine color
                Color fillColor_2016 = new Color(30, 60, 120);
                Color borderColor_2016 = new Color(80, 140, 220);
                Color textColor_2016 = Color.WHITE;

                if (nodeColors_2016.containsKey(node_2016)) {
                    fillColor_2016 = nodeColors_2016.get(node_2016);
                    borderColor_2016 = fillColor_2016.brighter();
                    textColor_2016 = Color.WHITE;
                }

                // Shadow
                g2_2016.setColor(new Color(0, 0, 0, 80));
                g2_2016.fillOval(x_2016 + 3, y_2016 + 3, radius_2016 * 2, radius_2016 * 2);

                // Fill
                g2_2016.setColor(fillColor_2016);
                g2_2016.fillOval(x_2016, y_2016, radius_2016 * 2, radius_2016 * 2);

                // Border
                g2_2016.setColor(borderColor_2016);
                g2_2016.setStroke(new BasicStroke(2f));
                g2_2016.drawOval(x_2016, y_2016, radius_2016 * 2, radius_2016 * 2);

                // Label
                g2_2016.setFont(new Font("Arial", Font.BOLD, 8));
                g2_2016.setColor(textColor_2016);
                FontMetrics fm_2016 = g2_2016.getFontMetrics();

                // Wrap label if needed
                String[] words_2016 = node_2016.split(" ");
                if (words_2016.length == 1) {
                    int tw_2016 = fm_2016.stringWidth(node_2016);
                    g2_2016.drawString(node_2016, pos_2016[0] - tw_2016 / 2, pos_2016[1] + 4);
                } else {
                    String line1 = words_2016[0];
                    String line2 = String.join(" ", Arrays.copyOfRange(words_2016, 1, words_2016.length));
                    int tw1 = fm_2016.stringWidth(line1);
                    int tw2 = fm_2016.stringWidth(line2);
                    g2_2016.drawString(line1, pos_2016[0] - tw1 / 2, pos_2016[1] - 2);
                    g2_2016.drawString(line2, pos_2016[0] - tw2 / 2, pos_2016[1] + 9);
                }
            }
        }

        private boolean isPathEdge_2016(String a_2016, String b_2016) {
            if (pathNodes_2016.size() < 2) return false;
            for (int i = 0; i < pathNodes_2016.size() - 1; i++) {
                if ((pathNodes_2016.get(i).equals(a_2016) && pathNodes_2016.get(i + 1).equals(b_2016)) ||
                    (pathNodes_2016.get(i).equals(b_2016) && pathNodes_2016.get(i + 1).equals(a_2016))) {
                    return true;
                }
            }
            return false;
        }
    }

    // ========================
    // FIELDS
    // ========================
    private final Graph_2016 graph_2016 = new Graph_2016();
    private GraphPanel_2016 graphPanel_2016;
    private JComboBox<String> comboStart_2016;
    private JComboBox<String> comboGoal_2016;
    private JTextArea resultArea_2016;

    // Color palette
    private static final Color COLOR_START_2016   = new Color(34, 197, 94);
    private static final Color COLOR_GOAL_2016    = new Color(239, 68, 68);
    private static final Color COLOR_VISITED_2016 = new Color(251, 146, 60);
    private static final Color COLOR_PATH_2016    = new Color(250, 204, 21);

    // ========================
    // CONSTRUCTOR
    // ========================
    public PetaBandara_GUI2511532016() {
        super("Pencarian Jalur BFS & DFS - Peta Bandara | NIM: 2511532016");
        buildGraph_2016();
        initUI_2016();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // ========================
    // BUILD GRAPH
    // ========================
    private void buildGraph_2016() {
        // 10 nodes: airport locations
        // Positions tuned for a 820x420 canvas
        graph_2016.addVertex_2016("Pintu Masuk",   120, 210);
        graph_2016.addVertex_2016("Check-in",      240, 120);
        graph_2016.addVertex_2016("Imigrasi",      240, 300);
        graph_2016.addVertex_2016("Security",      380, 120);
        graph_2016.addVertex_2016("Duty Free",     380, 300);
        graph_2016.addVertex_2016("Gate A",        520, 80)	;
        graph_2016.addVertex_2016("Gate B",        520, 210);
        graph_2016.addVertex_2016("Gate C",        520, 340);
        graph_2016.addVertex_2016("Lounge",        660, 150);
        graph_2016.addVertex_2016("Runway",        700, 300);
        // 17 edges (>= 15 required)
        graph_2016.addEdge_2016("Pintu Masuk", "Check-in");
        graph_2016.addEdge_2016("Pintu Masuk", "Imigrasi");
        graph_2016.addEdge_2016("Check-in",    "Security");
        graph_2016.addEdge_2016("Check-in",    "Imigrasi");
        graph_2016.addEdge_2016("Imigrasi",    "Duty Free");
        graph_2016.addEdge_2016("Security",    "Gate A");
        graph_2016.addEdge_2016("Security",    "Gate B");
        graph_2016.addEdge_2016("Security",    "Duty Free");
        graph_2016.addEdge_2016("Duty Free",   "Gate B");
        graph_2016.addEdge_2016("Duty Free",   "Gate C");
        graph_2016.addEdge_2016("Gate A",      "Lounge");
        graph_2016.addEdge_2016("Gate A",      "Gate B");
        graph_2016.addEdge_2016("Gate B",      "Lounge");
        graph_2016.addEdge_2016("Gate B",      "Gate C");
        graph_2016.addEdge_2016("Gate C",      "Runway");
        graph_2016.addEdge_2016("Lounge",      "Runway");
        graph_2016.addEdge_2016("Gate A",      "Runway");
    }

    // ========================
    // INIT UI
    // ========================
    private void initUI_2016() {
        getContentPane().setBackground(new Color(10, 15, 35));
        getContentPane().setLayout(new BorderLayout(8, 8));

        // ---- Top Panel ----
        JPanel topPanel_2016 = new JPanel(new FlowLayout(FlowLayout.LEFT, 16, 10));
        topPanel_2016.setBackground(new Color(20, 30, 60));
        topPanel_2016.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(50, 80, 150)));

        JLabel titleLabel_2016 = new JLabel("✈  PENCARIAN JALUR BANDARA  —  BFS & DFS");
        titleLabel_2016.setForeground(new Color(150, 200, 255));
        titleLabel_2016.setFont(new Font("Arial", Font.BOLD, 14));
        topPanel_2016.add(titleLabel_2016);

        getContentPane().add(topPanel_2016, BorderLayout.NORTH);

        // ---- Center: Graph ----
        graphPanel_2016 = new GraphPanel_2016();
        graphPanel_2016.setBorder(BorderFactory.createLineBorder(new Color(50, 80, 150), 1));
        getContentPane().add(graphPanel_2016, BorderLayout.CENTER);

        // ---- Bottom Panel ----
        JPanel bottomPanel_2016 = new JPanel(new BorderLayout(8, 8));
        bottomPanel_2016.setBackground(new Color(15, 22, 45));
        bottomPanel_2016.setBorder(new EmptyBorder(8, 10, 10, 10));

        // Controls row
        JPanel controlRow_2016 = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 4));
        controlRow_2016.setBackground(new Color(20, 30, 60));
        controlRow_2016.setBorder(BorderFactory.createLineBorder(new Color(40, 70, 130), 1));

        String[] nodes_2016 = graph_2016.getVertices_2016().toArray(new String[0]);

        controlRow_2016.add(makeLabel_2016("Lokasi Awal :"));
        comboStart_2016 = makeCombo_2016(nodes_2016);
        controlRow_2016.add(comboStart_2016);

        controlRow_2016.add(makeLabel_2016("   Lokasi Tujuan :"));
        comboGoal_2016 = makeCombo_2016(nodes_2016);
        comboGoal_2016.setSelectedIndex(nodes_2016.length - 1);
        controlRow_2016.add(comboGoal_2016);

        controlRow_2016.add(Box.createHorizontalStrut(20));

        JButton btnBFS_2016 = makeButton_2016("BFS", new Color(34, 197, 94));
        JButton btnDFS_2016 = makeButton_2016("DFS", new Color(59, 130, 246));
        JButton btnReset_2016 = makeButton_2016("RESET", new Color(239, 68, 68));

        btnBFS_2016.addActionListener(e -> BFS_2016());
        btnDFS_2016.addActionListener(e -> DFS_2016());
        btnReset_2016.addActionListener(e -> resetGraph_2016());

        controlRow_2016.add(btnBFS_2016);
        controlRow_2016.add(btnDFS_2016);
        controlRow_2016.add(btnReset_2016);

        // Legend
        JPanel legendPanel_2016 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 2));
        legendPanel_2016.setBackground(new Color(20, 30, 60));
        legendPanel_2016.add(legendDot_2016(COLOR_START_2016,   "Start"));
        legendPanel_2016.add(legendDot_2016(COLOR_GOAL_2016,    "Goal"));
        legendPanel_2016.add(legendDot_2016(COLOR_VISITED_2016, "Dikunjungi"));
        legendPanel_2016.add(legendDot_2016(COLOR_PATH_2016,    "Jalur"));

        JPanel controlWrapper_2016 = new JPanel(new BorderLayout());
        controlWrapper_2016.setBackground(new Color(20, 30, 60));
        controlWrapper_2016.add(controlRow_2016, BorderLayout.CENTER);
        controlWrapper_2016.add(legendPanel_2016, BorderLayout.EAST);

        // Result area
        resultArea_2016 = new JTextArea(6, 80);
        resultArea_2016.setEditable(false);
        resultArea_2016.setFont(new Font("Consolas", Font.PLAIN, 12));
        resultArea_2016.setBackground(new Color(10, 15, 30));
        resultArea_2016.setForeground(new Color(160, 220, 160));
        resultArea_2016.setBorder(new EmptyBorder(6, 8, 6, 8));
        resultArea_2016.setText("Hasil Pencarian :\nJalur          : -\nNode Dikunjungi: -\nJumlah Node    : 0");

        JScrollPane scroll_2016 = new JScrollPane(resultArea_2016);
        scroll_2016.setBorder(BorderFactory.createLineBorder(new Color(40, 70, 130), 1));

        bottomPanel_2016.add(controlWrapper_2016, BorderLayout.NORTH);
        bottomPanel_2016.add(scroll_2016, BorderLayout.CENTER);

        getContentPane().add(bottomPanel_2016, BorderLayout.SOUTH);
    }

    // ========================
    // BFS
    // ========================
    private void BFS_2016() {
        String start_2016 = (String) comboStart_2016.getSelectedItem();
        String goal_2016  = (String) comboGoal_2016.getSelectedItem();
        if (start_2016 == null || goal_2016 == null) return;

        Map<String, String> parent_2016 = new LinkedHashMap<>();
        Queue<String> queue_2016 = new LinkedList<>();
        List<String> visitOrder_2016 = new ArrayList<>();
        Set<String> visited_2016 = new LinkedHashSet<>();
        Map<String, Color> colors_2016 = new HashMap<>();

        queue_2016.add(start_2016);
        visited_2016.add(start_2016);
        parent_2016.put(start_2016, null);

        while (!queue_2016.isEmpty()) {
            String curr_2016 = queue_2016.poll();
            visitOrder_2016.add(curr_2016);

            if (curr_2016.equals(goal_2016)) break;

            for (String neighbor_2016 : graph_2016.getNeighbors_2016(curr_2016)) {
                if (!visited_2016.contains(neighbor_2016)) {
                    visited_2016.add(neighbor_2016);
                    parent_2016.put(neighbor_2016, curr_2016);
                    queue_2016.add(neighbor_2016);
                }
            }
        }

        displayResult_2016("BFS", start_2016, goal_2016, parent_2016, visitOrder_2016, colors_2016);
    }

    // ========================
    // DFS
    // ========================
    private void DFS_2016() {
        String start_2016 = (String) comboStart_2016.getSelectedItem();
        String goal_2016  = (String) comboGoal_2016.getSelectedItem();
        if (start_2016 == null || goal_2016 == null) return;

        Map<String, String> parent_2016 = new LinkedHashMap<>();
        List<String> visitOrder_2016 = new ArrayList<>();
        Set<String> visited_2016 = new LinkedHashSet<>();
        Map<String, Color> colors_2016 = new HashMap<>();

        Stack<String> stack_2016 = new Stack<>();
        stack_2016.push(start_2016);
        parent_2016.put(start_2016, null);

        while (!stack_2016.isEmpty()) {
            String curr_2016 = stack_2016.pop();
            if (visited_2016.contains(curr_2016)) continue;
            visited_2016.add(curr_2016);
            visitOrder_2016.add(curr_2016);

            if (curr_2016.equals(goal_2016)) break;

            // Push neighbors in reverse so alphabetically first is visited first
            List<String> neighbors_2016 = new ArrayList<>(graph_2016.getNeighbors_2016(curr_2016));
            Collections.reverse(neighbors_2016);
            for (String neighbor_2016 : neighbors_2016) {
                if (!visited_2016.contains(neighbor_2016)) {
                    stack_2016.push(neighbor_2016);
                    if (!parent_2016.containsKey(neighbor_2016)) {
                        parent_2016.put(neighbor_2016, curr_2016);
                    }
                }
            }
        }

        displayResult_2016("DFS", start_2016, goal_2016, parent_2016, visitOrder_2016, colors_2016);
    }

    // ========================
    // DISPLAY PATH
    // ========================
    private void displayPath_2016(List<String> path_2016, Map<String, Color> colors_2016,
                                   String start_2016, String goal_2016) {
        for (String node_2016 : path_2016) {
            if (node_2016.equals(start_2016)) {
                colors_2016.put(node_2016, COLOR_START_2016);
            } else if (node_2016.equals(goal_2016)) {
                colors_2016.put(node_2016, COLOR_GOAL_2016);
            } else {
                colors_2016.put(node_2016, COLOR_PATH_2016);
            }
        }
        graphPanel_2016.setNodeColors_2016(colors_2016);
        graphPanel_2016.setPath_2016(path_2016);
    }

    private void displayResult_2016(String algo_2016, String start_2016, String goal_2016,
                                     Map<String, String> parent_2016,
                                     List<String> visitOrder_2016,
                                     Map<String, Color> colors_2016) {

        // Mark visited nodes
        for (String v_2016 : visitOrder_2016) {
            colors_2016.put(v_2016, COLOR_VISITED_2016);
        }
        colors_2016.put(start_2016, COLOR_START_2016);

        // Reconstruct path
        List<String> path_2016 = new ArrayList<>();
        if (parent_2016.containsKey(goal_2016)) {
            String curr_2016 = goal_2016;
            while (curr_2016 != null) {
                path_2016.add(0, curr_2016);
                curr_2016 = parent_2016.get(curr_2016);
            }
        }

        displayPath_2016(path_2016, colors_2016, start_2016, goal_2016);
        graphPanel_2016.setNodeColors_2016(colors_2016);

        // Build text result
        StringBuilder sb_2016 = new StringBuilder();
        sb_2016.append("[ ").append(algo_2016).append(" ] Hasil Pencarian\n");
        sb_2016.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        sb_2016.append("Start          : ").append(start_2016).append("\n");
        sb_2016.append("Goal           : ").append(goal_2016).append("\n");

        if (path_2016.isEmpty()) {
            sb_2016.append("Jalur          : Tidak ditemukan!\n");
        } else {
            sb_2016.append("Jalur          : ").append(String.join(" → ", path_2016)).append("\n");
        }

        sb_2016.append("Node Dikunjungi: ").append(String.join(" → ", visitOrder_2016)).append("\n");
        sb_2016.append("Jumlah Node    : ").append(visitOrder_2016.size());

        resultArea_2016.setText(sb_2016.toString());
    }

    // ========================
    // RESET GRAPH
    // ========================
    private void resetGraph_2016() {
        graphPanel_2016.reset_2016();
        resultArea_2016.setText("Hasil Pencarian :\nJalur          : -\nNode Dikunjungi: -\nJumlah Node    : 0");
    }

    // ========================
    // DISPLAY GRAPH (called on init via paintComponent)
    // ========================
    @SuppressWarnings("unused")
    private void displayGraph_2016() {
        graphPanel_2016.repaint();
    }

    // ========================
    // UI HELPERS
    // ========================
    private JLabel makeLabel_2016(String text_2016) {
        JLabel lbl_2016 = new JLabel(text_2016);
        lbl_2016.setForeground(new Color(180, 210, 255));
        lbl_2016.setFont(new Font("Arial", Font.BOLD, 12));
        return lbl_2016;
    }

    private JComboBox<String> makeCombo_2016(String[] items_2016) {
        JComboBox<String> cb_2016 = new JComboBox<>(items_2016);
        cb_2016.setBackground(new Color(25, 40, 80));
        cb_2016.setForeground(new Color(0, 0, 0));
        cb_2016.setFont(new Font("Arial", Font.PLAIN, 12));
        cb_2016.setPreferredSize(new Dimension(140, 28));
        return cb_2016;
    }

    private JButton makeButton_2016(String text_2016, Color color_2016) {
        JButton btn_2016 = new JButton(text_2016);
        btn_2016.setBackground(color_2016);
        btn_2016.setForeground(new Color(0, 0, 0));
        btn_2016.setFont(new Font("Arial", Font.BOLD, 12));
        btn_2016.setFocusPainted(false);
        btn_2016.setBorder(BorderFactory.createEmptyBorder(6, 18, 6, 18));
        btn_2016.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_2016.addMouseListener(new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e_2016) {
                btn_2016.setBackground(color_2016.brighter());
            }
            @Override public void mouseExited(MouseEvent e_2016) {
                btn_2016.setBackground(color_2016);
            }
        });
        return btn_2016;
    }

    private JPanel legendDot_2016(Color color_2016, String label_2016) {
        JPanel p_2016 = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
        p_2016.setBackground(new Color(20, 30, 60));
        JLabel dot_2016 = new JLabel("●");
        dot_2016.setForeground(color_2016);
        dot_2016.setFont(new Font("Arial", Font.PLAIN, 14));
        JLabel lbl_2016 = new JLabel(label_2016);
        lbl_2016.setForeground(new Color(160, 190, 230));
        lbl_2016.setFont(new Font("Arial", Font.PLAIN, 11));
        p_2016.add(dot_2016);
        p_2016.add(lbl_2016);
        return p_2016;
    }

    // ========================
    // MAIN
    // ========================
    public static void main(String[] args_2016) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored_2016) {}
        SwingUtilities.invokeLater(PetaBandara_GUI2511532016::new);
    }
}
