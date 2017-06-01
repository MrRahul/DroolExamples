package drools.main;

import drools.model.AC;
import drools.model.Room;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

/**
 * Created by 604418 on 5/24/2017.
 */
public class SampleDroolTest {

    public static void main(String arg[]) {

        try {
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            //Getting Stateful session
            KieSession kSession = kContainer.newKieSession("Stateful");

            Room room = new Room("Common Room", 41);
            AC ac = new AC(room, false, false);
            FactHandle fact1, fact2;
            fact1 = kSession.insert(room);
            fact2 = kSession.insert(ac);
            kSession.fireAllRules();//It will trigger all rules
            System.out.println("now ac is on? " + ac.getOn() + "\n");

            //since the rules has been fired for the fact, and fact has not been updated so this won't do any thing
            kSession.fireAllRules();

            //Updating a fact on the fly using java and drl
            System.out.println("Updating a fact on the fly using java");
            updateFactsForKitchenTurnOffAC(room, ac);
            kSession.update(fact1,room);
            kSession.update(fact2,ac);
            kSession.fireAllRules();

            System.out.println("\t\t\t============\nturning on AC to let it turn off Agenda and salience are expressed below\n\t\t\t============");
            updateFactsForKitchenTurnOnAC(room, ac);
            kSession.update(fact1,room);
            kSession.update(fact2,ac);
            //kSession.getAgenda().getAgendaGroup("AC-OFF").setFocus();
            kSession.fireAllRules();


            //use of session.dispose
            kSession.dispose();
            //since we have disposed off the session this line will give error
            //kSession.fireAllRules();


        } catch (Throwable t) {
            System.out.println("Bad things do happen");
        }
    }
        static void updateFactsForKitchenTurnOffAC(Room room,AC ac){
        room.setName("KITCHEN");
        ac.getRoom().setName("KITCHEN");
        room.setTemp(40);
        ac.setOn(false);
    }
    static void updateFactsForKitchenTurnOnAC(Room room,AC ac){
        room.setName("KITCHEN");
        ac.getRoom().setName("KITCHEN");
        room.setTemp(20);
        ac.setOn(true);
    }



}
