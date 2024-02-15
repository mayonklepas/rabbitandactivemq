/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rabbitmqtest;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import static javax.swing.UIManager.getLookAndFeel;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author mulyadi
 */
public class RabbitMqReceiver {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(RabbitMqReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }
        ReceiverForm form = new ReceiverForm();
        form.setLocationRelativeTo(null);
        form.setVisible(true);
    }

}
