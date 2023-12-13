package presentation;
import domain.*;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Timer;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuGUI extends JFrame{
    private static MenuGUI GomukuPOOB;
    private Gomoku Game;
    private int Posx,Posy;
    boolean casillaValor,fichaValor;
    private String NombreJ1 ,NombreJ2,ColorJ1,ColorJ2;
    private char Tjugador1,Tjugador2;
    private JPanel Inicio,Configuracion,Juego,Player1,Player2;
    private JLabel Front;
    private JButton BJugar,colorJugador1,colorJugador2,confirm;
    private JButton[][] buttons;
    private Dimension Pantalla;
    private JMenu archivo, settings;
    private JMenuBar menuBar;
    private JMenuItem load, save, start, quit, tamaño, colorselect,restart;
    private String[] opciones,opciones2,opciones3,opciones4,opciones5;
    private ImageIcon Fondo;
    private Color color;
    private JTextField nombreJugador1,nombreJugador2;
    private JLabel Nombre1,Nombre2, Color1,Color2,CasillasE, PiedrasE,TipoJugador1,TipoJugador2,Modo;
    private JComboBox<String> comboBox1,comboBox2,comboBox3,comboBox4,comboBox5;

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
        //setSize(Pantalla.width, Pantalla.height);
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
        // Crear un array de elementos para el JComboBox
        opciones = new String[]{"Humano", "Maquina"};
        // Crear un JComboBox y agregarle los elementos
        comboBox1 = new JComboBox<>(opciones);
        comboBox1.setBounds(290, 185, 150, 30);
        Configuracion.add(comboBox1);
        //-------------------------------------------------------------------------//
        TipoJugador2 = new JLabel("Introduce el tipo de Jugador 2 :");
        TipoJugador2.setFont(new Font("Bodoni MT Cursiva", Font.BOLD, 15));
        TipoJugador2.setForeground(Color.BLACK);
        TipoJugador2.setBounds(700,150,250,100);
        Configuracion.add(TipoJugador2);
        // Crear un array de elementos para el JComboBox
        opciones2 =new String[] {"Humano", "Maquina"};
        // Crear un JComboBox y agregarle los elementos
        comboBox2 = new JComboBox<>(opciones2);
        comboBox2.setBounds(950, 185, 150, 30);
        Configuracion.add(comboBox2);
        //-------------------------------------------------------------------------//
        Modo = new JLabel("Modo de Juego:");
        Modo.setFont(new Font("Bodoni MT Cursiva", Font.BOLD, 15));
        Modo.setForeground(Color.BLACK);
        Modo.setBounds(500,265,250,100);
        Configuracion.add(Modo);
        // Crear un array de elementos para el JComboBox
        opciones3 =new String[] {"Normal", "QuikTime","PiedraLimitada"};
        // Crear un JComboBox y agregarle los elementos
        comboBox3 = new JComboBox<>(opciones3);
        comboBox3.setBounds(650, 300, 150, 30);
        Configuracion.add(comboBox3);
        //-------------------------------------------------------------------------//
        CasillasE = new JLabel("Casillas Especiales:");
        CasillasE.setFont(new Font("Bodoni MT Cursiva", Font.BOLD, 15));
        CasillasE.setForeground(Color.BLACK);
        CasillasE.setBounds(500,315,250,100);
        Configuracion.add(CasillasE);
        // Crear un array de elementos para el JComboBox
        opciones4 =new String[] {"True", "False"};
        // Crear un JComboBox y agregarle los elementos
        comboBox4 = new JComboBox<>(opciones4);
        comboBox4.setBounds(650, 350, 150, 30);
        Configuracion.add(comboBox4);
        //-------------------------------------------------------------------------//
        PiedrasE = new JLabel("Piedras Especiales :");
        PiedrasE.setFont(new Font("Bodoni MT Cursiva", Font.BOLD, 15));
        PiedrasE.setForeground(Color.BLACK);
        PiedrasE.setBounds(500,365,250,100);
        Configuracion.add(PiedrasE);
        // Crear un array de elementos para el JComboBox
        opciones5 =new String[] {"True", "False"};
        // Crear un JComboBox y agregarle los elementos
        comboBox5 = new JComboBox<>(opciones5);
        comboBox5.setBounds(650, 400, 150, 30);
        Configuracion.add(comboBox5);
        //-------------------------------------------------------------------------//
        //-------------------------------------------------------------------------//
        //-------------------------------------------------------------------------//
        confirm = new JButton("Confirmar");
        confirm.setFont(new Font("Bodoni MT Cursiva", Font.BOLD, 20));
        //nombreJugador2.setBounds(950,55,100,20);
        confirm.setBounds(600,650,150,50);
        Configuracion.add(confirm);
        //-------------------------------------------------------------------------//
        //--------------------------------------------//
        add(Configuracion);
    }

    private void PanelJuego() {
        Object j1 = comboBox1.getSelectedItem();
        String Typo1 = (String) j1;
        Tjugador1 = Typo1.charAt(1);
        Object j2 = comboBox2.getSelectedItem();
        String Typo2 = (String) j2;
        Tjugador2 = Typo2.charAt(1);
        Object casilla = comboBox4.getSelectedItem();
        Object ficha = comboBox5.getSelectedItem();
        casillaValor = Boolean.parseBoolean((String) casilla);
        fichaValor = Boolean.parseBoolean((String) ficha);
        //--------------------------------------------//
        Game = new Gomoku(Tjugador1,Tjugador2,fichaValor,casillaValor);
        //System.out.println(letra1.charAt(1)+ letra2.charAt(1) + ficha.toString()+casilla.toString());
        //Game.start();
        //--------------------------------------------//
        Juego = new JPanel(new GridBagLayout());
        Juego.setLayout(new GridLayout(15, 15));
        Juego.setBorder(new CompoundBorder(new EmptyBorder(2, 2, 2, 2), new TitledBorder("Board ")));
        Juego.setBorder(new LineBorder(new Color(115,17,17), 3));
        setLocationRelativeTo(null);
        //--------------------------------------------//
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        buttons = new JButton[15][15];
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].setBackground(color);
                gbc.gridx = col;
                gbc.gridy = row;
                gbc.weightx = 1.0 / 15;
                gbc.weighty = 1.0 / 15;
                gbc.ipadx = 150 / 15;
                gbc.ipady = 350 / 15;
                Juego.add(buttons[row][col], gbc);
            }
        }
        //-------------------------------------------------------------------------//
        Player1 = new JPanel();
        Player1.setLayout(new FlowLayout());
        //JugadorInfo jugador1Info = obtenerInformacionJugador(Tjugador1);
        //JugadorInfo jugador2Info = obtenerInformacionJugador(Tjugador2);
        // Crear etiquetas para mostrar la información del jugador 1
        JLabel nombreJugador1 = new JLabel("Nombre: " + NombreJ1);
        JLabel colorJugador1 = new JLabel("Color: " + ColorJ1);
        //JLabel fichaJugador1 = new JLabel("Ficha: " + jugador1Info.getFicha());
        //JLabel puntajeJugador1 = new JLabel("Puntaje: " + jugador1Info.getPuntaje());
        // Establecer ubicaciones y tamaños de las etiquetas del jugador 1
        nombreJugador1.setBounds(10, 20, 150, 30);
        colorJugador1.setBounds(10, 60, 150, 30);
        //fichaJugador1.setBounds(10, 100, 150, 30);
        //puntajeJugador1.setBounds(10, 140, 150, 30);
        // Agregar etiquetas del jugador 1 al panel Player1
        Player1.add(nombreJugador1);
        Player1.add(colorJugador1);
        // Player1.add(fichaJugador1);
        // Player1.add(puntajeJugador1);
        //-------------------------------------------------------------------------//
        Player2 = new JPanel();
        Player2.setLayout(new FlowLayout());
        // Crear etiquetas para mostrar la información del jugador 2 (siguiendo un proceso similar al del jugador 1)
        JLabel nombreJugador2 = new JLabel("Nombre: " + NombreJ2);
        JLabel colorJugador2 = new JLabel("Color: " + ColorJ2 );
        // JLabel fichaJugador2 = new JLabel("Ficha: " + jugador2Info.getFicha());
        //JLabel puntajeJugador2 = new JLabel("Puntaje: " + jugador2Info.getPuntaje());
        nombreJugador2.setBounds(10, 20, 150, 30);
        colorJugador2.setBounds(10, 60, 150, 30);
        //fichaJugador2.setBounds(10, 100, 150, 30);
        //puntajeJugador2.setBounds(10, 140, 150, 30);
        Player2.add(nombreJugador2);
        Player2.add(colorJugador2);
        //Player2.add(fichaJugador2);
        //Player2.add(puntajeJugador2);
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

    private void salida() {
        if (JOptionPane.showConfirmDialog(rootPane, "Seguro que quiere salir", "Salir del sistema", JOptionPane.YES_NO_OPTION
        ) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }else {
            setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }
    //-------------------------------------------------------------------------//
    public void prepareActions() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                salida();
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
                if (colorSeleccionado != null) {
                    colorJugador1.setBackground(colorSeleccionado);
                    // Puedes obtener el código RGB del color seleccionado y asignarlo al JTextField
                    String rgb = String.format("#%02x%02x%02x", colorSeleccionado.getRed(), colorSeleccionado.getGreen(), colorSeleccionado.getBlue());
                    colorJugador1.setText(rgb);
                }
            }
        });
        colorJugador2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color colorSeleccionado = JColorChooser.showDialog(null, "Selecciona un color", Color.WHITE);
                if (colorSeleccionado != null) {
                    colorJugador2.setBackground(colorSeleccionado); // Corregir el nombre del JTextField aquí
                    // Puedes obtener el código RGB del color seleccionado y asignarlo al JTextField
                    String rgb = String.format("#%02x%02x%02x", colorSeleccionado.getRed(), colorSeleccionado.getGreen(), colorSeleccionado.getBlue());
                    colorJugador2.setText(rgb); // Corregir el nombre del JTextField aquí
                }
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el elemento seleccionado del JComboBox
                String selectedOption = comboBox1.getSelectedItem().toString();
                System.out.println("Seleccionado: " + selectedOption);
            }
        });
        comboBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el elemento seleccionado del JComboBox
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
                Salvar();
            }
        });
        load.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Abrir();
            }
        });
        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {
                int finalRow = row;
                int finalCol = col;
                buttons[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int cont = 0;
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

    public void Jugada(int fila,int columna){
        Game.playgame(fila, columna);
        char currentPlayer = Game.FichaPlayer();
        boolean jugadaValida = Game.Verificacion(fila, columna, currentPlayer);
        boolean JuegoFinaliado = Game.getJuegoFinalizado();
        if (!JuegoFinaliado) {
            Color colorFicha = (currentPlayer == 'X') ? Color.RED : Color.BLUE;
            buttons[fila][columna].setBackground(colorFicha);
            buttons[fila][columna].setEnabled(false);
            // Verificar si hay un ganador después de la jugada
            boolean hayGanador = Game.getJuegoFinalizado();
            if (hayGanador) {
                JOptionPane.showMessageDialog(null, "¡El jugador " + currentPlayer + " ha ganado!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Jugada inválida. Intenta en otra casilla.");
        }
    }

    private void Nuevo() {
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea iniciar una nueva simulación?", "Nueva simulación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            Game = new Gomoku(Tjugador1,Tjugador2,fichaValor,casillaValor);
            repaint();
        }
    }
    /**
     * Método para abrir una simulación guardada desde un archivo.
     */
    private void Abrir() {
        try {
            JFileChooser Seleccion = new JFileChooser();
            Seleccion.setFileFilter(new FileNameExtensionFilter("Archivo DAT", "DAT"));
            int opcion = Seleccion.showOpenDialog(this);
            if (opcion == JFileChooser.APPROVE_OPTION) {
                File archivoSeleccionado = Seleccion.getSelectedFile();
                if (archivoSeleccionado != null && archivoSeleccionado.exists()) {
                    //colony.cargarArchivo(archivoSeleccionado);
                    //photo.repaint();
                    JOptionPane.showMessageDialog(null, "Archivo seleccionado: " + archivoSeleccionado.getAbsolutePath());
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado un archivo válido.");
                }
            } else {
                throw new GomokuException("No se ha seleccionado ningún archivo.");
            }
        } catch (GomokuException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void Salvar() {
        JFileChooser Seleccion = new JFileChooser();
        Seleccion.setFileFilter(new FileNameExtensionFilter("Archivo DAT", "DAT"));
        int opcion = Seleccion.showSaveDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = Seleccion.getSelectedFile();
            if (archivoSeleccionado != null) {
                String filePath = archivoSeleccionado.getAbsolutePath();
                if (!filePath.toLowerCase().endsWith(".DAT")) {
                    archivoSeleccionado = new File(filePath + ".DAT");
                }
                //colony.guardarArchivo(archivoSeleccionado);
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado un archivo válido.");
            }
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
    //-------------------------------------------------------------------------//
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
