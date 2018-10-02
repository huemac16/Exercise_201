
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class VelocityTableModel extends AbstractTableModel {

    private ArrayList<Measurement> list = new ArrayList<>();

    private static String[] colNames = {"Datum", "Uhrzeit", "Kennzeichen", "Gemessen", "Erlaubt", "Übertretung"};

    public void add(Measurement m) {
        list.add(m);

        fireTableRowsInserted(list.size() - 1, list.size() - 1);
    }

    public void remove(int idx) {
        list.remove(idx);

        fireTableRowsUpdated(0, list.size());
    }

    public double getAverage() {
        int sum = 0;
        int times = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getVelocityDifference();
            times++;
        }

        return sum / times;

    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Measurement s = list.get(i);
        return s;
    }

    @Override
    public String getColumnName(int i) {
        return colNames[i];
    }

}
