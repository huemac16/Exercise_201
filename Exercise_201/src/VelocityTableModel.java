
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class VelocityTableModel extends AbstractTableModel {

    private ArrayList<Measurement> list = new ArrayList<>();

    public void add(Measurement m) {
        list.add(m);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
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

}
