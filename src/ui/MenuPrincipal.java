package ui;

import dao.ContactoDAO;
import model.Contacto;

import javax.swing.*;
import java.util.List;

public class MenuPrincipal extends JFrame {

    private JTextField txtId, txtNombre, txtCorreo;
    private JTextArea area;
    private ContactoDAO dao = new ContactoDAO();

    public MenuPrincipal() {
        setTitle("Gestión de Contactos");
        setSize(450, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("ID:");
        JLabel l2 = new JLabel("Nombre:");
        JLabel l3 = new JLabel("Correo:");

        txtId = new JTextField();
        txtNombre = new JTextField();
        txtCorreo = new JTextField();

        JButton btnGuardar = new JButton("Registrar");
        JButton btnListar = new JButton("Consultar");
        JButton btnActualizar  = new JButton("Actualizar");

        area = new JTextArea();
        
        l1.setBounds(20, 20, 80, 25);
        l2.setBounds(20, 50, 80, 25);
        l3.setBounds(20, 80, 80, 25);

        txtId.setBounds(100, 20, 100, 25);
        txtNombre.setBounds(100, 50, 200, 25);
        txtCorreo.setBounds(100, 80, 200, 25);

        btnGuardar.setBounds(20, 120, 120, 30);
        btnListar.setBounds(150, 120, 120, 30);
        btnActualizar.setBounds(280, 120, 120, 30);

        JScrollPane sp = new JScrollPane(area);
        sp.setBounds(20, 170, 380, 170);

        add(l1); add(l2); add(l3);
        add(txtId); add(txtNombre); add(txtCorreo);
        add(btnGuardar); add(btnListar); add(btnActualizar);
        add(sp);

        btnGuardar.addActionListener(e -> {
            dao.registrar(new Contacto(
                    0,
                    txtNombre.getText(),
                    txtCorreo.getText()
            ));
            JOptionPane.showMessageDialog(this, "Registro guardado");
        });

        btnListar.addActionListener(e -> {
            area.setText("");
            List<Contacto> lista = dao.listar();
            for (Contacto c : lista) {
                area.append(c.getId() + " | " +
                        c.getNombre() + " | " +
                        c.getCorreo() + "\n");
            }
        });

        btnActualizar.addActionListener(e -> {
            dao.actualizar(new Contacto(
                    Integer.parseInt(txtId.getText()),
                    txtNombre.getText(),
                    txtCorreo.getText()
            ));
            JOptionPane.showMessageDialog(this, "Registro actualizado");
        });
    }

    public static void main(String[] args) {
        new MenuPrincipal().setVisible(true);
    }
}
