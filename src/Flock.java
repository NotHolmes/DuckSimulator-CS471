import java.util.ArrayList;
import java.util.Iterator;

public class Flock implements Quackable{
    ArrayList<Quackable> quackers = new ArrayList<Quackable>();

    public void add (Quackable quacker){
        quackers.add(quacker);
    }

    @Override
    public void quack() {
        int i = 0;
        for (Quackable quacker : quackers) {
            if(i == 0) {
                System.out.print("Leader : ");quacker.quack();
                System.out.print("Leader : ");quacker.quack();
                System.out.print("Leader : ");quacker.quack();
                i++;
                continue;
            }
            quacker.quack();
        }
    }
}
