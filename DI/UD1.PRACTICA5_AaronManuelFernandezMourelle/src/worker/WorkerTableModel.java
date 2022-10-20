package worker;

import javax.swing.table.DefaultTableModel;

/**
 * Experimenting. Implementaré aquí los métodos convenientes para la manejar la
 * lista del JFrame.
 *
 * @author AaronFM
 */
public class WorkerTableModel extends DefaultTableModel {

    public WorkerTableModel() {
        super(new Object[][]{}, new String[]{"Nombre y apellidos", "Provincia", "Profesión"});
    }

    /**
     * Comprueba que el trabajador existe en la tabla.
     * @param candidate
     * @return
     */
    public boolean existsWorker(Worker candidate) {
        int rowCount = this.getRowCount();
        Object value;
        for (int i = 0; i < rowCount; i++) {
            value = this.getValueAt(i, 0);
            if (value instanceof Worker worker) {
                if (worker.getId().equals(candidate.getId())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Introduce el trabajador en la tabla. Ease of use.
     * @param worker 
     */
    public void addWorker(Worker worker) {
        super.addRow(new Object[]{worker, worker.getProvince(), worker.getProfession()});
    }
    /**
     * Recoge el trabajador de la tabla.
     * @param index
     * @return 
     */
    public Worker getWorkerAt(int index){
        return (Worker) super.getValueAt(index, 0);
    }
    /**
     * Cuenta los trabajadores con provincia similar al objetivo.
     * @param worker
     * @return 
     */
    public int countBySimilarProvince(Worker worker) {
        int count = 0;
        int rowCount = super.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            Worker check = getWorkerAt(i);
            if(!check.getId().equals(worker.getId())){
                if(check.getProvince().equals(worker.getProvince())){
                    count++;
                }
            }
            
        }
        return count;
    }
    
}
