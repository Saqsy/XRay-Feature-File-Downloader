/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Saqsy
 */
class PropertyManager {

    private Properties properties = new Properties();
    private final File propFile = new File("config.properties");

    protected String getProperties(String value) {
        if (properties.isEmpty()){
            propertyFileReader();
        } else if (!propFile.exists()){
            generatePropFile();
            JOptionPane.showMessageDialog(null,"New properties file is generated in your folder, Please restart the application.");
            System.exit(0);
        }
        return properties.getProperty(value);
    }

    private void propertyFileReader(){
        try (FileInputStream reader = new FileInputStream(propFile)){
            properties.load(reader);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Exception occurred while reading properties file. \n" + e.getMessage());
            System.exit(0);
        }
    }

    private void generatePropFile(){
        try {
            propFile.createNewFile();
        } catch (IOException e) {
           JOptionPane.showMessageDialog(null,"Exception occurred while creating new properties file.");
           System.exit(0);
        }

        try (FileOutputStream out = new FileOutputStream(propFile)){
            properties.setProperty("Project_ID", "ENTER_PROJECT_ID");
            properties.setProperty("Xray_Client_Id", "ENTER_CLIENT_ID");
            properties.setProperty("Xray_Client_Secret_Key", "ENTER_CLIENT_SECRET_KEY");
            properties.store(out,null);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Exception occurred while setting dummy data into properties file");
            System.exit(0);
        }
    }
}
