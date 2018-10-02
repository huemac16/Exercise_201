
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    public void save(File f) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        for (Measurement s : list) {
            oos.writeObject(s);

        }

        oos.flush();
        oos.close();
    }

    public void load(File f) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        Object o;
        try {
            while ((o = ois.readObject()) != null) {
                list.add((Measurement) o);
            }

        } catch (Exception e) {
        }

        ois.close();

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
