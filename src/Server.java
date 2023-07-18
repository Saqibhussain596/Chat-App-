import java.net.*;
import java.io.*;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Server extends JFrame {
    ServerSocket server;
    Socket socket;
    BufferedReader br;
    PrintWriter out;

    // Declaring components
    private JLabel heading = new JLabel("SERVER AREA");
    private JTextArea messageArea = new JTextArea();
    private JTextField messageInput = new JTextField();
    private Font font = new Font("Roboto", Font.PLAIN, 20);

    public Server() {
        try {
            server = new ServerSocket(7777);
            System.out.println("Waiting for connection...");
            socket = server.accept();
            System.out.println("Connection established");
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
            createGUI();
            handleEvents();
            startReading();
            // startWriting();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createGUI() {
        this.setTitle("Server Side Messenger");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // component code
        heading.setFont(font);
        messageArea.setFont(font);
        messageInput.setFont(font);

        heading.setHorizontalTextPosition(SwingConstants.CENTER);
        heading.setVerticalTextPosition(SwingConstants.BOTTOM);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        messageArea.setEditable(false);
        messageInput.setHorizontalAlignment(SwingConstants.CENTER);
        // setting layout of frame
        this.setLayout(new BorderLayout());

        // adding components to frame
        this.add(heading, BorderLayout.NORTH);
        JScrollPane jScrollPane = new JScrollPane(messageArea);
        this.add(jScrollPane, BorderLayout.CENTER);
        this.add(messageInput, BorderLayout.SOUTH);

    }

    private void handleEvents() {
        messageInput.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    String contentToSend = messageInput.getText();
                    messageArea.append("Server: " + contentToSend + "\n");
                    out.println(contentToSend);
                    out.flush();
                    messageInput.setText("");
                    messageInput.requestFocus();
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {

            }
        });
    }

    public void startReading() {
        Runnable r1 = () -> {
            System.out.println("Reader started....");
            try {
                while (true) {
                    String msg = br.readLine();
                    if (msg.equals("exit")) {
                        // System.out.println("Client terminated the chat");25
                        dispose();
                        JOptionPane.showMessageDialog(this, "Client Terminated the chat");

                        // socket.close();
                        break;
                    }
                    // System.out.println("Client: " + msg);
                    messageArea.append("Client: " + msg + "\n");
                }
            } catch (Exception e) {
                System.out.println("Connection closed");
            }
        };
        new Thread(r1).start();
    }

    // public void startWriting() {
    // Runnable r2 = () -> {
    // System.out.println("Writer started...");
    // try {
    // while (!socket.isClosed()) {
    // BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
    // String content = br1.readLine();
    // out.println(content);
    // out.flush();
    // if (content.equals("exit")) {
    // socket.close();
    // break;
    // }
    // }
    // System.out.println("Connection is closed");
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // };
    // new Thread(r2).start();
    // }

    public static void main(String[] args) {
        System.out.println("SERVER AREA");
        new Server();
    }
}
