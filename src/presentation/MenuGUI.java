package presentation;
import domain.*;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuGUI extends JFrame{
    private static MenuGUI GomukuPOOB;
    private Gomoku Game;
    private int Posx,Posy,Table;
    private boolean casillaValor,fichaValor;
    private String NombreJ1 ,NombreJ2;
    private char Tjugador1,Tjugador2;
    private JPanel Inicio,Configuracion,Juego,Player1,Player2;
    private JButton BJugar,colorJugador1,colorJugador2,confirm;
    private JTextField nombreJugador1,nombreJugador2;
    private JLabel Nombre1,Nombre2, Color1,Color2,CasillasE, PiedrasE,TipoJugador1,TipoJugador2,Modo,TamañoT,Front;
    private JComboBox<String> comboBox1,comboBox2,comboBox3,comboBox4,comboBox5,comboBox6;
    private JMenu archivo, settings;
    private JMenuBar menuBar;
    private JMenuItem load, save, start, quit, tamaño, colorselect,restart;
    private CirculoEnBoton[][] buttons;
    private Dimension Pantalla;
    private String[] opciones,opciones2,opciones3,opciones4,opciones5,opciones6;
    private ImageIcon Fondo;
    private Color color,ColorP1,ColorP2;

    //-------------------------------------------------------------------------//
    public MenuGUI() {
        prepareElements();
        prepareActions();
    }
    //-------------------------------------------------------------------------//
    public void prepareElements() {
        setTitle("Go-moku POOB");
        Pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(Pantalla.width/2, Pantalla.height/2);
        setLocationRelativeTo(null);
        PanelInicial();
    }
    //-------------------------------------------------------------------------//
    private void PanelInicial() {
        //--------------------------------------------//
        Inicio = new JPanel();
        Inicio.setLayout(null);
        Fondo = new ImageIcon(getClass().getResource("/Imagenes/Fondo.jpg"));
        Image Fon = Fondo.getImage().getScaledInstance(Pantalla.width/2,Pantalla.height/2 ,Image.SCALE_SMOOTH);
        ImageIcon Fone = new ImageIcon(Fon);
        Front = new JLabel(Fone);
        Front.setBounds(0, 0, Fone.getIconWidth(), Fone.getIconHeight());
        //--------------------------------------------//
        BJugar = new JButton("Play");
        BJugar.setBackground(Color.WHITE);
        BJugar.setBounds((Pantalla.width / 5)+18,(Pantalla.height / 5)+100,100,20);
        //--------------------------------------------//
        Inicio.add(BJugar);
        Inicio.add(Front);
        add(Inicio);
    }
    private void PanelConfiguracion() {
        //--------------------------------------------//
        Configuracion = new JPanel();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        Configuracion.setLayout(null);
        //--------------------------------------------//
        Nombre1 = new JLabel("Introduce tu nombre Jugador 1 :");
        Nombre1.setFont(new Font("Bodoni MT Cursiva", Font.BOLD, 15));
        Nombre1.setForeground(Color.BLACK);
        Nombre1.setBounds(20,50,250,100);
        Configuracion.add(Nombre1);
        nombreJugador1 = new JTextField();
        nombreJugador1.setBounds(290,90,100,20);
        Configuracion.add(nombreJugador1);
        //-------------------------------------------------------------------------//
        Nombre2 = new JLabel("Introduce tu nombre Jugador 2 :");
        Nombre2.setFont(new Font("Bodoni MT Cursiva", Font.BOLD, 15));
        Nombre2.setForeground(Color.BLACK);
        Nombre2.setBounds(700,50,250,100);
        Configuracion.add(Nombre2);
        nombreJugador2 = new JTextField();
        nombreJugador2.setBounds(950,90,100,20);
        Configuracion.add(nombreJugador2);
        //-------------------------------------------------------------------------//
        Color1 = new JLabel("Introduce tu Color Jugador 1 :");
        Color1.setFont(new Font("Bodoni MT Cursiva", Font.BOLD, 15));
        Color1.setForeground(Color.BLACK);
        Color1.setBounds(20,95,250,100);
        Configuracion.add(Color1);
        colorJugador1 = new JButton("Seleccion");
        colorJugador1.setBounds(290,135,100,20);
        Configuracion.add(colorJugador1);
        //-------------------------------------------------------------------------//
        Color2 = new JLabel("Introduce tu Color Jugador 2 :");
        Color2.setFont(new Font("Bodoni MT Cursiva", Font.BOLD, 15));
        Color2.setForeground(Color.BLACK);
        Color2.setBounds(700,95,250,100);
        Configuracion.add(Color2);
        colorJugador2 = new JButton("Seleccion");
        colorJugador2.setBounds(950,135,100,20);
        Configuracion.add(colorJugador2);
        //-------------------------------------------------------------------------//
        TipoJugador1 = new JLabel("Introduce el tipo de Jugador 1 :");
        TipoJugador1.setFont(new Font("Bodoni MT Cursiva", Font.BOLD, 15));
        TipoJugador1.setForeground(Color.BLACK);
        TipoJugador1.setBounds(20,150,250,100);
        Configuracion.add(TipoJugador1);
        opciones = new String[]{"Humano", "Maquina"};
        comboBox1 = new JComboBox<>(opciones);
        comboBox1.setBounds(290, 185, 150, 30);
        Configuracion.add(comboBox1);
        //-------------------------------------------------------------------------//
        TipoJugador2 = new JLabel("Introduce el tipo de Jugador 2 :");
        TipoJugador2.setFont(new Font("Bodoni MT Cursiva", Font.BOLD, 15));
        TipoJugador2.setForeground(Color.BLACK);
        TipoJugador2.setBounds(700,150,250,100);
        Configuracion.add(TipoJugador2);
        opciones2 =new String[] {"Humano", "Maquina"};
        comboBox2 = new JComboBox<>(opciones2);
        comboBox2.setBounds(950, 185, 150, 30);
        Configuracion.add(comboBox2);
        //-------------------------------------------------------------------------//
        Modo = new JLabel("Modo de Juego:");
        Modo.setFont(new Font("Bodoni MT Cursiva", Font.BOLD, 15));
        Modo.setForeground(Color.BLACK);
        Modo.setBounds(500,265,250,100);
        Configuracion.add(Modo);
        opciones3 =new String[] {"Normal", "QuikTime","PiedraLimitada"};
        comboBox3 = new JComboBox<>(opciones3);
        comboBox3.setBounds(650, 300, 150, 30);
        Configuracion.add(comboBox3);
        //-------------------------------------------------------------------------//
        CasillasE = new JLabel("Casillas Especiales:");
        CasillasE.setFont(new Font("Bodoni MT Cursiva", Font.BOLD, 15));
        CasillasE.setForeground(Color.BLACK);
        CasillasE.setBounds(500,315,250,100);
        Configuracion.add(CasillasE);
        opciones4 =new String[] {"False","True"};
        comboBox4 = new JComboBox<>(opciones4);
        comboBox4.setBounds(650, 350, 150, 30);
        Configuracion.add(comboBox4);
        //-------------------------------------------------------------------------//
        PiedrasE = new JLabel("Piedras Especiales :");
        PiedrasE.setFont(new Font("Bodoni MT Cursiva", Font.BOLD, 15));
        PiedrasE.setForeground(Color.BLACK);
        PiedrasE.setBounds(500,365,250,100);
        Configuracion.add(PiedrasE);
        opciones5 =new String[] {"False","True"};
        comboBox5 = new JComboBox<>(opciones5);
        comboBox5.setBounds(650, 400, 150, 30);
        Configuracion.add(comboBox5);
        //-------------------------------------------------------------------------//
        TamañoT = new JLabel("Tamaño del Tablero:");
        TamañoT.setFont(new Font("Bodoni MT Cursiva", Font.BOLD, 15));
        TamañoT.setForeground(Color.BLACK);
        TamañoT.setBounds(500,415,250,100);
        Configuracion.add(TamañoT);
        opciones6 =new String[] {"Minimo", "Estandar","Grande"};
        comboBox6 = new JComboBox<>(opciones6);
        comboBox6.setBounds(650, 450, 150, 30);
        Configuracion.add(comboBox6);
        //-------------------------------------------------------------------------//
        confirm = new JButton("Confirmar");
        confirm.setFont(new Font("Bodoni MT Cursiva", Font.BOLD, 20));
        //nombreJugador2.setBounds(950,55,100,20);
        confirm.setBounds(600,650,150,50);
        Configuracion.add(confirm);
        //-------------------------------------------------------------------------//
        add(Configuracion);
    }
    private void PanelJuego() {
        Object j1 = comboBox1.getSelectedItem();
        String Typo1 = (String) j1;
        Tjugador1 = Typo1.charAt(0);
        Object j2 = comboBox2.getSelectedItem();
        String Typo2 = (String) j2;
        Tjugador2 = Typo2.charAt(0);
        Object casilla = comboBox4.getSelectedItem();
        Object ficha = comboBox5.getSelectedItem();
        casillaValor = Boolean.parseBoolean((String) casilla);
        fichaValor = Boolean.parseBoolean((String) ficha);
        //--------------------------------------------//
        Object Tamaño = comboBox6.getSelectedItem();
        String TamañoT = (String) Tamaño;
        switch(TamañoT){
            case "Minimo":
                Table  = 10;
                break;
            case "Estandar":
                Table  = 15;
                break;
            case "Grande":
                Table  = 20;
                break;
            default:
                Table  = 15;
                break;
        }
        //--------------------------------------------//
        Game = new Gomoku(Tjugador1,Tjugador2,fichaValor,casillaValor,Table);
        //--------------------------------------------//
        Juego = new JPanel(new GridBagLayout());
        Juego.setLayout(new GridLayout(Table, Table));
        Juego.setBorder(new CompoundBorder(new EmptyBorder(2, 2, 2, 2), new TitledBorder("Board ")));
        Juego.setBorder(new LineBorder(new Color(115,17,17), 3));
        setLocationRelativeTo(null);
        //--------------------------------------------//
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        buttons = new CirculoEnBoton[Table][Table];
        for (int row = 0; row < Table; row++) {
            for (int col = 0; col < Table; col++) {
                buttons[row][col] = new CirculoEnBoton(); ;
                buttons[row][col].setBackground(color);
                gbc.gridx = col;
                gbc.gridy = row;
                gbc.weightx = 1.0 / Table;
                gbc.weighty = 1.0 / Table;
                gbc.ipadx = 150 / Table;
                gbc.ipady = 350 / Table;
                Juego.add(buttons[row][col], gbc);
            }
        }
        //-------------------------------------------------------------------------//
        Player1 = new JPanel();
        Player1.setLayout(new BoxLayout(Player1, BoxLayout.Y_AXIS));
        Player1.setBorder(BorderFactory.createTitledBorder("Jugador 1"));
        //-------------------------------------------------------------------------//
        JLabel nombreJugador1Label = new JLabel("Nombre:");
        JLabel colorJugador1Label = new JLabel("Color:");
        JLabel piedrasJugador1Label = new JLabel("Piedras disponibles:");
        JLabel tiempoJugador1Label = new JLabel("Tiempo invertido:");
        JLabel puntajeJugador1Label = new JLabel("Puntaje:");
        //-------------------------------------------------------------------------//
        JLabel nombreJugador1Value = new JLabel(NombreJ1);
        nombreJugador1Value.setForeground(Color.BLACK);
        JPanel colorPanelJugador1 = new JPanel();
        colorPanelJugador1.setBackground(ColorP1);
        JLabel piedrasJugador1Value = new JLabel("Piedra 1: 5, Piedra 2: 3, Piedra 3: 8");
        JLabel tiempoJugador1Value = new JLabel("2 horas 15 minutos");
        JLabel puntajeJugador1Value = new JLabel("1500 puntos");
        //-------------------------------------------------------------------------//
        Player1.add(nombreJugador1Label);
        Player1.add(nombreJugador1Value);
        Player1.add(Box.createVerticalStrut(10));
        Player1.add(colorJugador1Label);
        Player1.add(colorPanelJugador1);
        Player1.add(Box.createVerticalStrut(5));
        Player1.add(piedrasJugador1Label);
        Player1.add(piedrasJugador1Value);
        Player1.add(Box.createVerticalStrut(10));
        Player1.add(tiempoJugador1Label);
        Player1.add(tiempoJugador1Value);
        Player1.add(Box.createVerticalStrut(10));
        Player1.add(puntajeJugador1Label);
        Player1.add(puntajeJugador1Value);
        //-------------------------------------------------------------------------//
        Player2 = new JPanel();
        Player2.setLayout(new BoxLayout(Player2, BoxLayout.Y_AXIS));
        Player2.setBorder(BorderFactory.createTitledBorder("Jugador 2"));
        //-------------------------------------------------------------------------//
        JLabel nombreJugador2Label = new JLabel("Nombre: ");
        JLabel colorJugador2Label = new JLabel("Color: ");
        JLabel piedrasJugador2Label = new JLabel("Piedras disponibles:");
        JLabel tiempoJugador2Label = new JLabel("Tiempo invertido:");
        JLabel puntajeJugador2Label = new JLabel("Puntaje:");
        //-------------------------------------------------------------------------//
        JLabel nombreJugador2Value = new JLabel(NombreJ2);
        nombreJugador2Value.setForeground(Color.BLACK);
        JPanel colorPanelJugador2 = new JPanel();
        colorPanelJugador2.setBackground(ColorP2);
        JLabel piedrasJugador2Value = new JLabel("Piedra 1: 5, Piedra 2: 3, Piedra 3: 8");
        JLabel tiempoJugador2Value = new JLabel("2 horas 15 minutos");
        JLabel puntajeJugador2Value = new JLabel("1500 puntos");
        //-------------------------------------------------------------------------//
        Player2.add(nombreJugador2Label);
        Player2.add(nombreJugador2Value);
        Player2.add(Box.createVerticalStrut(10));
        Player2.add(colorJugador2Label);
        Player2.add(colorPanelJugador2);
        Player2.add(Box.createVerticalStrut(5));
        Player2.add(piedrasJugador2Label);
        Player2.add(piedrasJugador2Value);
        Player2.add(Box.createVerticalStrut(10));
        Player2.add(tiempoJugador2Label);
        Player2.add(tiempoJugador2Value);
        Player2.add(Box.createVerticalStrut(10));
        Player2.add(puntajeJugador2Label);
        Player2.add(puntajeJugador2Value);
        //-------------------------------------------------------------------------//
        //-------------------------------------------------------------------------//
        //--------------------------------------------//
        getContentPane().add(Juego, BorderLayout.CENTER);
        add(Player1, BorderLayout.WEST);
        add(Player2, BorderLayout.EAST);
        add(Juego);
    }
    //-------------------------------------------------------------------------//
    public void prepareElementsMenu() {
        setBackground(Color.WHITE);
        menuBar = new JMenuBar();
        archivo = new JMenu("Archivo");
        settings = new JMenu("Configuración");
        menuBar.add(archivo);
        menuBar.add(settings);
        //-------------------------------------------------------------------------//
        start = new JMenuItem("Nuevo");
        save = new JMenuItem("Salvar");
        load = new JMenuItem("Abrir");
        quit = new JMenuItem("Salir");
        tamaño = new JMenuItem("Tamaño");
        colorselect = new JMenuItem("Color");
        restart = new JMenuItem("Reiniciar");
        //-------------------------------------------------------------------------//
        archivo.add(start);
        archivo.addSeparator();
        archivo.add(load);
        archivo.addSeparator();
        archivo.add(save);
        archivo.addSeparator();
        archivo.add(quit);
        settings.add(tamaño);
        settings.addSeparator();
        settings.add(colorselect);
        settings.addSeparator();
        settings.add(restart);
        //-------------------------------------------------------------------------//
        setJMenuBar(menuBar);
    }
    public void prepareElementsPlayer(){
        Inicio.setVisible(false);
        PanelConfiguracion();
        prepareActionsConfiguration();
        Configuracion.setVisible(true);
        validate();
        repaint();
    }
    public void prepareElementsBoard(){
        Configuracion.setVisible(false);
        PanelJuego() ;
        prepareElementsMenu();
        prepareActionsJuego();
        Juego.setVisible(true);
        validate();
        repaint();
    }
    //-------------------------------------------------------------------------////-------------------------------------------------------------------------////-------------------------------------------------------------------------//
    public void prepareActions() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                Salida();
            }
        });
        BJugar.addActionListener(e -> {
            prepareElementsPlayer();
        });
    }

    public void prepareActionsConfiguration() {
        colorJugador1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color colorSeleccionado = JColorChooser.showDialog(null, "Selecciona un color", Color.WHITE);
                ColorP1 = colorSeleccionado;
                if (colorSeleccionado != null) {
                    colorJugador1.setBackground(colorSeleccionado);
                    String rgb = String.format("#%02x%02x%02x", colorSeleccionado.getRed(), colorSeleccionado.getGreen(), colorSeleccionado.getBlue());
                    colorJugador1.setText(rgb);
                }
            }
        });
        colorJugador2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color colorSeleccionado = JColorChooser.showDialog(null, "Selecciona un color", Color.WHITE);
                ColorP2 = colorSeleccionado;
                if (colorSeleccionado != null) {
                    colorJugador2.setBackground(colorSeleccionado);
                    String rgb = String.format("#%02x%02x%02x", colorSeleccionado.getRed(), colorSeleccionado.getGreen(), colorSeleccionado.getBlue());
                    colorJugador2.setText(rgb);
                }
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = comboBox1.getSelectedItem().toString();
                System.out.println("Seleccionado: " + selectedOption);
            }
        });
        comboBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = comboBox2.getSelectedItem().toString();
                System.out.println("Seleccionado: " + selectedOption);
            }
        });
        confirm.addActionListener(e -> {
            NombreJ1= nombreJugador1.getText();
            NombreJ2= nombreJugador2.getText();
            prepareElementsBoard();
        });
    }

    public void prepareActionsJuego() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        quit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Salida();
            }
        });
        start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Nuevo();
            }
        });
        save.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Salvar();
                } catch (GomokuException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        load.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Abrir();
                } catch (GomokuException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        for (int row = 0; row < Table; row++) {
            for (int col = 0; col < Table; col++) {
                int finalRow = row;
                int finalCol = col;
                buttons[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton selectedButton = (JButton) e.getSource();
                        for (int row = 0; row < buttons.length; row++) {
                            for (int col = 0; col < buttons[row].length; col++) {
                                if (buttons[row][col] == selectedButton) {
                                    Posx = row;
                                    Posy = col;
                                    Jugada(Posx, Posy);
                                    System.out.println("Botón seleccionado en la posición: (" + row + ", " + col + ")");
                                    return;
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    //-------------------------------------------------------------------------////-------------------------------------------------------------------------////-------------------------------------------------------------------------//
    public void Jugada(int fila,int columna){
        Game.playGame(fila, columna);
        char currentPlayer = Game.FichaPlayer();
        Color colorFicha = (currentPlayer == 'X') ? ColorP1 : ColorP2;
        buttons[fila][columna].setColorCirculo(colorFicha);
        buttons[fila][columna].setEnabled(false);
        boolean JuegoFinaliado = Game.getJuegoFinalizado();
        String nombreFicha = (currentPlayer == 'X') ? NombreJ1 : NombreJ2;
        if (JuegoFinaliado) {
            JOptionPane.showMessageDialog(null, "¡El jugador " + nombreFicha + " ha ganado!");
        }
    }

    private void realizarJugadaMaquina(int x, int y) {
        Game.JugarMaquina(x,y);
    }

    private void Nuevo() {
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea iniciar un nuevo juego?", "Nuevo Juego", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            reiniciarJuego();
        }
    }
    private void reiniciarJuego() {
        Game = new Gomoku(Tjugador1, Tjugador2, fichaValor, casillaValor,Table);
        limpiarTablero();
    }
    private void limpiarTablero() {
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {
                buttons[row][col].setColorCirculo(null);
                buttons[row][col].setEnabled(true);
            }
        }
        repaint();
    }

    private File obtenerArchivo(String descripcion, String... extensiones) {
        JFileChooser selector = new JFileChooser();
        selector.setFileFilter(new FileNameExtensionFilter(descripcion, extensiones));
        int opcion = selector.showDialog(this, null);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            return selector.getSelectedFile();
        }
        return null;
    }

    private void Abrir() throws GomokuException, IOException, ClassNotFoundException {
        try {
            File archivoSeleccionado = obtenerArchivo("Archivo Gomoku", "GO-M");
            if (archivoSeleccionado != null && archivoSeleccionado.exists()) {
                Game.cargarArchivo(archivoSeleccionado);
                actualizarInterfazDespuesDeCarga();
                JOptionPane.showMessageDialog(null, "Archivo seleccionado: " + archivoSeleccionado.getAbsolutePath());
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado un archivo válido.");
            }
        } catch (IOException | ClassNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new GomokuException("Error al abrir el archivo: " + e.getMessage());
        }
    }

    private void actualizarInterfazDespuesDeCarga() {
        // Aquí puedes realizar operaciones para actualizar visualmente la interfaz
        // Esto puede incluir cambios en componentes, actualización de datos, repintado, etc.
        // Por ejemplo, si tienes un panel que muestra información:
        if (Juego != null) {
            getContentPane().remove(Juego); // Elimina el panel de juego actual
            PanelJuego(); // Crea un nuevo panel de juego
            prepareActionsJuego(); // Prepara las acciones para el nuevo panel de juego
            getContentPane().add(Juego, BorderLayout.CENTER); // Agrega el nuevo panel de juego al contenedor principal
        }
        //panelInformacion.actualizarDatos();
        this.repaint(); // Para repintar la ventana principal
        this.revalidate(); // Para volver a validar la disposición de los componentes
    }

    private void Salvar() throws GomokuException {
        try {
            File archivoSeleccionado = obtenerArchivo("Archivo Gomoku", "GO-M");
            if (archivoSeleccionado != null) {
                String filePath = archivoSeleccionado.getAbsolutePath();
                if (!filePath.toLowerCase().endsWith(".go-m")) {
                    archivoSeleccionado = new File(filePath + ".GO-M");
                }
                Game.guardarArchivo(archivoSeleccionado);
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado un archivo válido.");
            }
        } catch (Exception e) {
            throw new GomokuException("Error al guardar el archivo: " + e.getMessage());
        }
    }

    /**
     * Método para salir de la aplicación.
     */
    private void Salida()  {
        if (JOptionPane.showConfirmDialog(rootPane, "Seguro que quiere salir", "Salir del sistema", JOptionPane.YES_NO_OPTION
        ) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }else {
            setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }
    //-------------------------------------------------------------------------////-------------------------------------------------------------------------////-------------------------------------------------------------------------//
    public void paint(Graphics g) {
        ImageIcon imageIcon = new ImageIcon("/Imagenes/Fondo.jpg");
        Image image = imageIcon.getImage();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        super.paint(g);
    }
    //-------------------------------------------------------------------------//
    public static void main(String[] Args){
        GomukuPOOB = new MenuGUI();
        GomukuPOOB.setVisible(true);
    }
    //-------------------------------------------------------------------------//
}

class CirculoEnBoton extends JButton {
    private Color colorCirculo;

    public CirculoEnBoton() {
        super();
        this.colorCirculo = null;
    }

    public void setColorCirculo(Color color) {
        this.colorCirculo = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int diametro = Math.min(getWidth(), getHeight()) - 6; // Diámetro del círculo
        g.setColor(colorCirculo);
        g.fillOval((getWidth() - diametro) / 2, (getHeight() - diametro) / 2, diametro, diametro);
    }
}