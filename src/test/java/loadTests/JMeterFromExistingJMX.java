package loadTests;


import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

import java.io.File;
import java.io.FileInputStream;

public class JMeterFromExistingJMX {

    public static void main(String[] argv) throws Exception {
        // JMeter Engine
        StandardJMeterEngine jmeter = new StandardJMeterEngine();


        // Initialize Properties, logging, locale, etc.
        JMeterUtils.loadJMeterProperties("D:\\Projects\\rozetja\\src\\test\\resources\\jmeter.properties");
        JMeterUtils.setJMeterHome("D:\\Soft\\apache-jmeter-4.0");
        //JMeterUtils.initLogging();// you can comment this line out to see extra log messages of i.e. DEBUG level
        JMeterUtils.initLocale();

        // Initialize JMeter SaveService
        SaveService.loadProperties();

        // Load existing .jmx Test Plan
        File in = new File("D:\\Projects\\rozetja\\src\\test\\jmeter\\Test.jmx");
        HashTree testPlanTree = SaveService.loadTree(in);
        //in.delete();

        // Run JMeter Test
        jmeter.configure(testPlanTree);
        jmeter.run();
    }
}