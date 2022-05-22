package com.topicus.casus.pact;

import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactFolder;
import au.com.dius.pact.provider.spring.junit5.PactVerificationSpringProvider;
import com.topicus.casus.domain.model.Medicine;
import com.topicus.casus.repositories.MedicineRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Provider("voorschrijfapi")
@PactFolder("pacts")
@Transactional
public class VoorschrijfApiProviderTests {

    @Autowired
    private MedicineRepository medicineRepository;

    @TestTemplate
    @ExtendWith(PactVerificationSpringProvider.class)
    void pactVerificationTestTemplate(PactVerificationContext context) {
        context.verifyInteraction();
    }

    @State("has 3 medicines")
    public void toTestState() {
        medicineRepository.save(Medicine.builder()
                .name("Paracetamol")
                .unit("strips")
                .unitsPerPackage(3)
                .unitForUnit("Aantal tabletten per strip")
                .unitsInUnit(20)
                .build());
        medicineRepository.save(Medicine.builder()
                .name("Ritalin")
                .unit("strips")
                .unitsPerPackage(3)
                .unitForUnit("Aantal tabletten per strip")
                .unitsInUnit(12)
                .build());
        medicineRepository.save(Medicine.builder()
                .name("Oogdruppels")
                .unit("flesjes")
                .unitsPerPackage(1)
                .unitForUnit("Aantal milliliter per flesje")
                .unitsInUnit(15)
                .build());
    }
}
