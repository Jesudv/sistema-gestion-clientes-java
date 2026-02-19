package controller;

import javax.swing.*;
import java.util.regex.Pattern;

public class HelperController {
    // MENSAJES
    public static void mensaje(String texto) {
        JOptionPane.showMessageDialog(null, texto, "Sistema",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void error(String texto) {
        JOptionPane.showMessageDialog(null, texto, "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public static boolean confirmar(String texto) {
        int opcion = JOptionPane.showConfirmDialog(
                null,
                texto,
                "Confirmación",
                JOptionPane.YES_NO_OPTION
        );
        return opcion == JOptionPane.YES_OPTION;
    }
    // VALIDAR CLIENTE
    public static boolean validarCliente(
            JTextField txtNombre,
            JTextField txtEmail,
            JTextField txtTelefono,
            JTextField txtDireccion,
            JComboBox<String> cmbTipoCliente,
            JComboBox<String> cmbEstado
    ) {

        if (txtNombre.getText().trim().isEmpty()) {
            error("Ingrese nombre del cliente");
            txtNombre.requestFocus();
            return false;
        }

        if (!validarEmail(txtEmail.getText())) {
            error("Email inválido");
            txtEmail.requestFocus();
            return false;
        }

        if (txtTelefono.getText().trim().isEmpty()) {
            error("Ingrese teléfono");
            txtTelefono.requestFocus();
            return false;
        }

        if (txtDireccion.getText().trim().isEmpty()) {
            error("Ingrese dirección");
            txtDireccion.requestFocus();
            return false;
        }

        if (cmbTipoCliente.getSelectedIndex() == 0) {
            error("Seleccione tipo cliente");
            cmbTipoCliente.requestFocus();
            return false;
        }

        if (cmbEstado.getSelectedIndex() == 0) {
            error("Seleccione estado");
            cmbEstado.requestFocus();
            return false;
        }

        return true;
    }
    // VALIDAR EMAIL
    private static boolean validarEmail(String email) {

        String regex =
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        return Pattern.matches(regex, email);
    }
    // LIMPIAR FORMULARIO
    public static void limpiarCampos(
            JTextField txtNombre,
            JTextField txtEmail,
            JTextField txtTelefono,
            JTextField txtDireccion,
            JTextArea txtObservaciones,
            JComboBox<String> cmbTipoCliente,
            JComboBox<String> cmbEstado
    ) {

        txtNombre.setText("");
        txtEmail.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtObservaciones.setText("");

        cmbTipoCliente.setSelectedIndex(0);
        cmbEstado.setSelectedIndex(0);

        txtNombre.requestFocus();
    }
}

