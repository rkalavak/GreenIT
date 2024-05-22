package com.ing.app.schedulers;

import com.ing.app.exceptions.GreenITException;
import com.ing.app.model.xml.srumutil.RecordSetRows;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SRUMUtilScheduler {

    private final Runtime runtime;
    private final String fileLocation;

    @Scheduled(fixedRate = 20000, initialDelay = 20000)
    public void SRUMUtilSchedule() {
        generateData();
        sleep();
        RecordSetRows recordSetRows = createData();
        System.out.println(recordSetRows.getRecord().size());
    }

    private void generateData() {
        String command = "powercfg /srumutil /output " + fileLocation + " /xml";
        try {
            runtime.exec(command);
        } catch (IOException e) {
            throw new GreenITException("Error while generating the data.", e);
        }
    }

    private RecordSetRows createData() {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(RecordSetRows.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            RecordSetRows recordSetRows = (RecordSetRows) jaxbUnmarshaller.unmarshal(new File(fileLocation));
            return recordSetRows;
        } catch (JAXBException e) {
            throw new GreenITException("Error while unmarshal the xml.", e);
        }
    }

    private void sleep() {

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new GreenITException("Error while sleeping for 10 seconds.", e);
        }
    }
}
