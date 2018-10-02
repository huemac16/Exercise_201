
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class VelocityTableRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        Measurement m = (Measurement) o;
        JLabel label = new JLabel();
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        label.setForeground(Color.BLACK);

        switch (i1) {
            case 0:
                label.setText(m.getDate().toString());
                break;
            case 1:
                label.setText(m.getTime().toString());
                break;
            case 2:
                label.setText(m.getLicense());
                break;
            case 3:
                label.setText("" + m.getVel() + " km/h");
                break;
            case 4:
                label.setText("" + m.getAllowed() + " km/h");
                break;
            case 5:
                if (m.getVelocityDifference() < 0) {
                    label.setText("0");
                } else {
                    label.setText("" + m.getVelocityDifference());
                }

                if (m.getVelocityDifference() > 30) {
                    label.setBackground(Color.RED);
                } else if (m.getVelocityDifference() < 30 && m.getVelocityDifference() >= 20) {
                    label.setBackground(Color.ORANGE);
                } else if (m.getVelocityDifference() < 20 && m.getVelocityDifference() >= 10) {
                    label.setBackground(Color.YELLOW);
                } else if (m.getVelocityDifference() < 10 && m.getVelocityDifference() > 0) {
                    label.setBackground(Color.BLUE);
                }
                break;
        }

        return label;
    }

}
