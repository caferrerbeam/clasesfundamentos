package edu.eam.ingesoft.fundamentos.gestionacademica.gui;

import edu.eam.ingesoft.fundamentos.gestionacademica.logica.Asignatura;
import edu.eam.ingesoft.fundamentos.gestionacademica.logica.Estudiante;
import edu.eam.ingesoft.fundamentos.gestionacademica.logica.Nota;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interfaz gráfica del Sistema de Gestión Académica.
 * Permite crear estudiantes, agregar asignaturas con sus notas,
 * y visualizar el reporte académico completo.
 */
public class EstudianteGUI extends JFrame {

    // Colores corporativos
    private static final Color COLOR_PRIMARY = new Color(102, 126, 234);
    private static final Color COLOR_SECONDARY = new Color(118, 75, 162);
    private static final Color COLOR_BACKGROUND = new Color(245, 247, 250);
    private static final Color COLOR_SUCCESS = new Color(76, 175, 80);
    private static final Color COLOR_WARNING = new Color(255, 152, 0);
    private static final Color COLOR_DANGER = new Color(244, 67, 54);

    // Componentes de la interfaz
    private JTextField txtNombre, txtCodigo, txtSemestre;
    private JTextField txtNombreAsignatura;
    private JTextField txtNombreNota, txtValorNota, txtPorcentajeNota;
    private JComboBox<String> comboAsignaturas;
    private JTextArea txtResultados;
    private JButton btnCrearEstudiante, btnAgregarAsignatura, btnAgregarNota, btnMostrarReporte;

    private Estudiante estudianteActual;
    private DefaultComboBoxModel<String> modeloAsignaturas;

    /**
     * Constructor de la GUI.
     */
    public EstudianteGUI() {
        inicializarComponentes();
        configurarVentana();
    }

    /**
     * Configura la ventana principal.
     */
    private void configurarVentana() {
        setTitle("Sistema de Gestión Académica - Universidad Excelencia Académica");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * Inicializa todos los componentes de la interfaz.
     */
    private void inicializarComponentes() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(10, 10));
        panelPrincipal.setBackground(COLOR_BACKGROUND);
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Panel superior: Título
        JPanel panelTitulo = crearPanelTitulo();
        panelPrincipal.add(panelTitulo, BorderLayout.NORTH);

        // Panel central: Formularios
        JPanel panelCentro = new JPanel(new GridLayout(1, 2, 15, 0));
        panelCentro.setOpaque(false);

        JPanel panelFormularios = crearPanelFormularios();
        JPanel panelResultados = crearPanelResultados();

        panelCentro.add(panelFormularios);
        panelCentro.add(panelResultados);

        panelPrincipal.add(panelCentro, BorderLayout.CENTER);

        add(panelPrincipal);
    }

    /**
     * Crea el panel del título.
     */
    private JPanel crearPanelTitulo() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(COLOR_PRIMARY, 2),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        JLabel lblTitulo = new JLabel("Sistema de Gestión Académica");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitulo.setForeground(COLOR_PRIMARY);

        JLabel lblSubtitulo = new JLabel("Universidad Excelencia Académica");
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblSubtitulo.setForeground(COLOR_SECONDARY);

        panel.setLayout(new GridLayout(2, 1, 0, 5));
        panel.add(lblTitulo);
        panel.add(lblSubtitulo);

        return panel;
    }

    /**
     * Crea el panel de formularios.
     */
    private JPanel crearPanelFormularios() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);

        // Panel 1: Datos del estudiante
        panel.add(crearPanelEstudiante());
        panel.add(Box.createVerticalStrut(15));

        // Panel 2: Agregar asignatura
        panel.add(crearPanelAsignatura());
        panel.add(Box.createVerticalStrut(15));

        // Panel 3: Agregar nota
        panel.add(crearPanelNota());

        return panel;
    }

    /**
     * Crea el panel de datos del estudiante.
     */
    private JPanel crearPanelEstudiante() {
        JPanel panel = crearPanelConBorde("Datos del Estudiante");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Nombre
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Nombre Completo:"), gbc);
        gbc.gridx = 1;
        txtNombre = new JTextField(15);
        panel.add(txtNombre, gbc);

        // Código
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Código:"), gbc);
        gbc.gridx = 1;
        txtCodigo = new JTextField(15);
        panel.add(txtCodigo, gbc);

        // Semestre
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Semestre:"), gbc);
        gbc.gridx = 1;
        txtSemestre = new JTextField(15);
        panel.add(txtSemestre, gbc);

        // Botón
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        btnCrearEstudiante = crearBoton("Crear Estudiante", COLOR_SUCCESS);
        btnCrearEstudiante.addActionListener(e -> crearEstudiante());
        panel.add(btnCrearEstudiante, gbc);

        return panel;
    }

    /**
     * Crea el panel para agregar asignaturas.
     */
    private JPanel crearPanelAsignatura() {
        JPanel panel = crearPanelConBorde("Agregar Asignatura");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Nombre de la asignatura
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        txtNombreAsignatura = new JTextField(15);
        panel.add(txtNombreAsignatura, gbc);

        // Botón
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        btnAgregarAsignatura = crearBoton("Agregar Asignatura", COLOR_PRIMARY);
        btnAgregarAsignatura.addActionListener(e -> agregarAsignatura());
        btnAgregarAsignatura.setEnabled(false);
        panel.add(btnAgregarAsignatura, gbc);

        return panel;
    }

    /**
     * Crea el panel para agregar notas.
     */
    private JPanel crearPanelNota() {
        JPanel panel = crearPanelConBorde("Agregar Nota a Asignatura");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // ComboBox de asignaturas
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Asignatura:"), gbc);
        gbc.gridx = 1;
        modeloAsignaturas = new DefaultComboBoxModel<>();
        comboAsignaturas = new JComboBox<>(modeloAsignaturas);
        panel.add(comboAsignaturas, gbc);

        // Nombre de la nota
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1;
        txtNombreNota = new JTextField(15);
        panel.add(txtNombreNota, gbc);

        // Valor
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Valor (0.0-5.0):"), gbc);
        gbc.gridx = 1;
        txtValorNota = new JTextField(15);
        panel.add(txtValorNota, gbc);

        // Porcentaje
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Porcentaje (%):"), gbc);
        gbc.gridx = 1;
        txtPorcentajeNota = new JTextField(15);
        panel.add(txtPorcentajeNota, gbc);

        // Botón
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        btnAgregarNota = crearBoton("Agregar Nota", COLOR_WARNING);
        btnAgregarNota.addActionListener(e -> agregarNota());
        btnAgregarNota.setEnabled(false);
        panel.add(btnAgregarNota, gbc);

        return panel;
    }

    /**
     * Crea el panel de resultados.
     */
    private JPanel crearPanelResultados() {
        JPanel panel = crearPanelConBorde("Reporte Académico");

        panel.setLayout(new BorderLayout(10, 10));

        txtResultados = new JTextArea();
        txtResultados.setEditable(false);
        txtResultados.setFont(new Font("Consolas", Font.PLAIN, 12));
        txtResultados.setLineWrap(false);
        txtResultados.setWrapStyleWord(false);

        JScrollPane scroll = new JScrollPane(txtResultados);
        scroll.setPreferredSize(new Dimension(400, 450));

        btnMostrarReporte = crearBoton("Mostrar Reporte Completo", COLOR_SECONDARY);
        btnMostrarReporte.addActionListener(e -> mostrarReporte());
        btnMostrarReporte.setEnabled(false);

        panel.add(scroll, BorderLayout.CENTER);
        panel.add(btnMostrarReporte, BorderLayout.SOUTH);

        return panel;
    }

    /**
     * Crea un panel con borde y título.
     */
    private JPanel crearPanelConBorde(String titulo) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(COLOR_PRIMARY, 1),
                        titulo,
                        0,
                        0,
                        new Font("Segoe UI", Font.BOLD, 14),
                        COLOR_PRIMARY
                ),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        return panel;
    }

    /**
     * Crea un botón estilizado.
     */
    private JButton crearBoton(String texto, Color color) {
        JButton boton = new JButton(texto);
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setPreferredSize(new Dimension(200, 35));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return boton;
    }

    // ========================== ACCIONES ==========================

    /**
     * Crea un nuevo estudiante con los datos ingresados.
     */
    private void crearEstudiante() {
        try {
            String nombre = txtNombre.getText().trim();
            String codigo = txtCodigo.getText().trim();
            int semestre = Integer.parseInt(txtSemestre.getText().trim());

            if (nombre.isEmpty() || codigo.isEmpty()) {
                mostrarError("Por favor complete todos los campos");
                return;
            }

            if (semestre <= 0) {
                mostrarError("El semestre debe ser un número positivo");
                return;
            }

            estudianteActual = new Estudiante(nombre, codigo, semestre);
            btnAgregarAsignatura.setEnabled(true);
            btnAgregarNota.setEnabled(true);
            btnMostrarReporte.setEnabled(true);

            txtResultados.setText("Estudiante creado exitosamente:\n" +
                    "Nombre: " + nombre + "\n" +
                    "Código: " + codigo + "\n" +
                    "Semestre: " + semestre + "\n\n" +
                    "Ahora puede agregar asignaturas y notas.");

            mostrarExito("Estudiante creado exitosamente");
        } catch (NumberFormatException e) {
            mostrarError("El semestre debe ser un número válido");
        }
    }

    /**
     * Agrega una asignatura al estudiante actual.
     */
    private void agregarAsignatura() {
        if (estudianteActual == null) {
            mostrarError("Primero debe crear un estudiante");
            return;
        }

        String nombreAsignatura = txtNombreAsignatura.getText().trim();
        if (nombreAsignatura.isEmpty()) {
            mostrarError("Por favor ingrese el nombre de la asignatura");
            return;
        }

        Asignatura asignatura = new Asignatura(nombreAsignatura);
        boolean agregada = estudianteActual.agregarAsignatura(asignatura);

        if (agregada) {
            modeloAsignaturas.addElement(nombreAsignatura);
            txtNombreAsignatura.setText("");
            mostrarExito("Asignatura agregada: " + nombreAsignatura);
        } else {
            mostrarError("No se pudo agregar la asignatura. Límite alcanzado (8 máximo)");
        }
    }

    /**
     * Agrega una nota a la asignatura seleccionada.
     */
    private void agregarNota() {
        if (estudianteActual == null) {
            mostrarError("Primero debe crear un estudiante");
            return;
        }

        if (comboAsignaturas.getSelectedIndex() == -1) {
            mostrarError("Primero debe agregar al menos una asignatura");
            return;
        }

        try {
            String nombreNota = txtNombreNota.getText().trim();
            double valor = Double.parseDouble(txtValorNota.getText().trim());
            double porcentaje = Double.parseDouble(txtPorcentajeNota.getText().trim());

            if (nombreNota.isEmpty()) {
                mostrarError("Por favor ingrese el nombre de la nota");
                return;
            }

            if (valor < 0.0 || valor > 5.0) {
                mostrarError("El valor debe estar entre 0.0 y 5.0");
                return;
            }

            if (porcentaje <= 0 || porcentaje > 100) {
                mostrarError("El porcentaje debe estar entre 0 y 100");
                return;
            }

            int indiceAsignatura = comboAsignaturas.getSelectedIndex();
            Asignatura asignatura = estudianteActual.getAsignaturas()[indiceAsignatura];

            Nota nota = new Nota(nombreNota, valor, porcentaje);
            boolean agregada = asignatura.agregarNota(nota);

            if (agregada) {
                txtNombreNota.setText("");
                txtValorNota.setText("");
                txtPorcentajeNota.setText("");
                mostrarExito("Nota agregada: " + nombreNota + " = " + valor);
            } else {
                mostrarError("No se pudo agregar la nota. Verifique validaciones o límite (10 máximo)");
            }
        } catch (NumberFormatException e) {
            mostrarError("Los valores numéricos no son válidos");
        }
    }

    /**
     * Muestra el reporte completo del estudiante.
     */
    private void mostrarReporte() {
        if (estudianteActual == null) {
            mostrarError("Primero debe crear un estudiante");
            return;
        }

        String reporte = estudianteActual.mostrarReporteCompleto();

        if (reporte.isEmpty()) {
            txtResultados.setText("El estudiante aún no tiene información suficiente para generar el reporte.\n" +
                    "Agregue asignaturas y notas para visualizar el reporte completo.");
        } else {
            txtResultados.setText(reporte);
        }
    }

    /**
     * Muestra un mensaje de error.
     */
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Muestra un mensaje de éxito.
     */
    private void mostrarExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    // ========================== MAIN ==========================

    /**
     * Método principal para ejecutar la aplicación.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            EstudianteGUI gui = new EstudianteGUI();
            gui.setVisible(true);
        });
    }
}
