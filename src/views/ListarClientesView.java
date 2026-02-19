package views;

import controller.ClienteController;
import model.Cliente;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class ListarClientesView extends javax.swing.JFrame {

    ClienteController controller = new ClienteController();

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(ListarClientesView.class.getName());
;
    
   

    public ListarClientesView() {
    initComponents();
    setLocationRelativeTo(null);
    setTitle("Listado de Clientes");
    cargarTabla();
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        TableClientes = new javax.swing.JTable();
        btnEditarCliente = new javax.swing.JButton();
        btnRefrescarLista = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        btnBuscadorClientes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NOMBRE", "EMAIL", "TELÉFONO", "DIRECCIÓN", "TIPO CLIENTE", "ESTADO", "OBSERVACIONES", "FECHA REGISTRO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TableClientes);

        btnEditarCliente.setText("Editar cliente");
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });

        btnRefrescarLista.setText("Refrescar lista");
        btnRefrescarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarListaActionPerformed(evt);
            }
        });

        btnEliminarCliente.setText("Eliminar cliente");
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        btnBuscadorClientes.setText("Buscador clientes");
        btnBuscadorClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscadorClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 968, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnEliminarCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                            .addComponent(btnEditarCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscadorClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefrescarLista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarCliente)
                    .addComponent(btnBuscadorClientes))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarCliente)
                    .addComponent(btnRefrescarLista))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefrescarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarListaActionPerformed
cargarTabla();
    }//GEN-LAST:event_btnRefrescarListaActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
int fila = TableClientes.getSelectedRow();

if (fila == -1) {
    JOptionPane.showMessageDialog(this, "Seleccione un cliente");
    return;
}

int id = Integer.parseInt(TableClientes.getValueAt(fila, 0).toString());

int confirm = JOptionPane.showConfirmDialog(
        this,
        "¿Seguro que desea eliminar este cliente?",
        "Confirmar",
        JOptionPane.YES_NO_OPTION
);

if (confirm == JOptionPane.YES_OPTION) {
    controller.eliminarCliente(id);
    JOptionPane.showMessageDialog(this, "Cliente eliminado");
    cargarTabla();
}
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
int fila = TableClientes.getSelectedRow();

if (fila == -1) {
    JOptionPane.showMessageDialog(this, "Seleccione un cliente");
    return;
}

int id = Integer.parseInt(TableClientes.getValueAt(fila, 0).toString());
String nombreActual = TableClientes.getValueAt(fila, 1).toString();
String emailActual = TableClientes.getValueAt(fila, 2).toString();

String nuevoNombre = JOptionPane.showInputDialog(this, "Nuevo nombre:", nombreActual);
String nuevoEmail = JOptionPane.showInputDialog(this, "Nuevo email:", emailActual);

if (nuevoNombre != null && nuevoEmail != null) {

    Cliente cliente = new Cliente(
            nuevoNombre,
            nuevoEmail,
            TableClientes.getValueAt(fila, 3).toString(),
            TableClientes.getValueAt(fila, 4).toString(),
            TableClientes.getValueAt(fila, 5).toString(),
            TableClientes.getValueAt(fila, 6).toString(),
            TableClientes.getValueAt(fila, 7).toString(),
            TableClientes.getValueAt(fila, 8).toString()
    );

    cliente.setId(id);

    controller.actualizarCliente(cliente);

    JOptionPane.showMessageDialog(this, "Cliente actualizado");
    cargarTabla();
}
    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void btnBuscadorClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscadorClientesActionPerformed
String buscar = JOptionPane.showInputDialog(this, "Ingrese nombre a buscar:");

if (buscar == null || buscar.trim().isEmpty()) {
        return;
    }

    DefaultTableModel modelo =
            (DefaultTableModel) TableClientes.getModel();

    modelo.setRowCount(0);

    List<Cliente> lista = controller.buscarPorNombre(buscar);

    for (Cliente c : lista) {

        modelo.addRow(new Object[]{
            c.getId(),
            c.getNombre(),
            c.getEmail(),
            c.getTelefono(),
            c.getDireccion(),
            c.getTipoCliente(),
            c.getEstado(),
            c.getObservaciones(),
            c.getFechaRegistro()
        });
    }
    }//GEN-LAST:event_btnBuscadorClientesActionPerformed
   
private void cargarTabla() {
    DefaultTableModel modelo =
            (DefaultTableModel) TableClientes.getModel();

    modelo.setRowCount(0);
    List<Cliente> lista = controller.listarClientes();

    for (Cliente c : lista) {
        modelo.addRow(new Object[]{
            c.getId(),
            c.getNombre(),
            c.getEmail(),
            c.getTelefono(),
            c.getDireccion(),
            c.getTipoCliente(),
            c.getEstado(),
            c.getObservaciones(),
            c.getFechaRegistro()
        });
    }
}
    public static void main(String args[]) {
        
   

        java.awt.EventQueue.invokeLater(() -> new ListarClientesView().setVisible(true));
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableClientes;
    private javax.swing.JButton btnBuscadorClientes;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnRefrescarLista;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
