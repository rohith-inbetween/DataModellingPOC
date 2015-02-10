package com.datamodelling.interactor.operation;

import com.datamodelling.interactor.entity.ITestEntity1Repository;
import com.datamodelling.interactor.entity.TestEntity1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveEntity {

    @Autowired
    private ITestEntity1Repository testEntity1Repository;

    public void execute(){
        TestEntity1 testEntity1 = new TestEntity1();
        testEntity1.setLabel("Test Entity 1");
        testEntity1.setName("ditto");
        testEntity1.setType(1L);
        testEntity1Repository.save(testEntity1);

    }
}
