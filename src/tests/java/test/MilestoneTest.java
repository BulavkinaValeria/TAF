package test;

import models.Milestone;
import models.MilestoneBuilder;
import org.testng.annotations.Test;

public class MilestoneTest {

    @Test
    public void lombokTest1() {
        Milestone milestone = new Milestone();
        milestone.setId(1);
        milestone.setName("dfgffg");
        milestone.setDescription("fggfgf");
        milestone.setCompleted(false);

        Milestone milestone1 = new Milestone();
        milestone.setId(2);
        milestone1.setName("dfgffg");
        milestone1.setDescription("fggfgf");
        milestone1.setCompleted(false);

        System.out.println(milestone.toString());
        System.out.println(milestone1.toString());
        System.out.println(milestone.equals(milestone1));
    }

    @Test
    public void lombokTest2() {
        MilestoneBuilder milestone = MilestoneBuilder.builder()
                .id(1)
                .description("fggfgf")
                .name("dfgffg")
                .build();

        MilestoneBuilder milestone1 = MilestoneBuilder.builder()
                .id(1)
                .description("fggfgf")
                .name("dfgffg")
                .build();

        System.out.println(milestone.toString());
        System.out.println(milestone1.toString());
        System.out.println(milestone.equals(milestone1));
    }
}
