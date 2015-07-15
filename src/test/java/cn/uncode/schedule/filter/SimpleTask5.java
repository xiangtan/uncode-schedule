package cn.uncode.schedule.filter;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * @author juny.ye
 */
@Component
public class SimpleTask5 {

    private static int i = 0;
    
    @Scheduled(cron = "*/5 * * * * ?")
    public void print() {
        System.out.println("===========start!=========");
        System.out.println("A-:"+i);i++;
        System.out.println("=========== end !=========");
    }
    


}
