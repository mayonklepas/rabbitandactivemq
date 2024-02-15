/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rabbitmqtest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.activemq.broker.BrokerPlugin;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.jmx.PersistenceAdapterView;
import org.apache.activemq.security.AuthenticationUser;
import org.apache.activemq.security.SimpleAuthenticationPlugin;
import org.apache.activemq.store.PersistenceAdapter;
import org.apache.activemq.store.PersistenceAdapterSupport;
import org.apache.activemq.store.kahadb.KahaDBPersistenceAdapter;
import org.apache.activemq.store.kahadb.disk.journal.Journal;
import org.apache.activemq.store.kahadb.disk.journal.Journal.JournalDiskSyncStrategy;

/**
 *
 * @author mulyadi
 */
public class MainClass {

    public static void main(String[] args) {
        try {

            String url = "tcp://localhost:666";
            BrokerService broker = new BrokerService();
            broker.addConnector(url);
            broker.setDataDirectory("mqdata");
            SimpleAuthenticationPlugin simp = new SimpleAuthenticationPlugin();
            List<AuthenticationUser> lsUser = new ArrayList<>();
            lsUser.add(new AuthenticationUser("test", "test", "user"));
            simp.setUsers(lsUser);
            broker.setPlugins(new BrokerPlugin[]{simp});
            KahaDBPersistenceAdapter kahaAdapter = new KahaDBPersistenceAdapter();
            
            //disable file log
            kahaAdapter.setJournalDiskSyncStrategy(JournalDiskSyncStrategy.NEVER.name());
            
            
            //set max size file log
            //int satuMb = 1000000;
            //kahaAdapter.setJournalMaxFileLength(satuMb*50);
            
            
            
            //set directory kahadb
            File fl=new File("D:\\kahadb");
            kahaAdapter.setDirectory(fl);
            
            //activated kahadb
            broker.setPersistenceAdapter(kahaAdapter);
            broker.setUseJmx(true);
            broker.start();
        } catch (Exception ex) {
            Logger.getLogger(ReceiverForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
