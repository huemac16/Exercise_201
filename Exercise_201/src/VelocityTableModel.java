
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class VelocityTableModel extends AbstractTableModel {

    private ArrayList<Measurement> list = new ArrayList<>();

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
