public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        simulator.simulate();
    }

    void simulate() {

        /* Using QuackCounter before QuackEcho gives unexpected output
            because QuackCounter count how many times quack() have been use
            but there's one more quack() inside quack() of QuackEcho
         */
//        Quackable mallardDuck = new QuackCounter(new QuackEcho(new MallardDuck()));
//        Quackable redheadDuck = new QuackCounter(new QuackEcho(new RedheadDuck()));

        Quackable mallardDuck = new QuackEcho(new QuackCounter(new MallardDuck()));
        Quackable redheadDuck = new QuackEcho(new QuackCounter(new RedheadDuck()));


        Quackable rubberDuck = new RubberDuck();
        Quackable goose = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());

        System.out.println("**** Duck Simulator ****");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(rubberDuck);
        simulate(goose);
        simulate(pigeon);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
        int oldCount = QuackCounter.getQuacks();

        System.out.println();

// **********************************************

        System.out.println("**** Duck Factory ****");

        DuckFactory duckFactory = new DuckFactory();
        simulate(duckFactory.createMallardDuck());
        simulate(duckFactory.createRedheadDuck());
        simulate(duckFactory.createRubberDuck());

        System.out.println();

// **********************************************

        System.out.println("**** Counting Duck Factory ****");
        CountingDuckFactory countingDuckFactory = new CountingDuckFactory();
        simulate(countingDuckFactory.createMallardDuck());
        simulate(countingDuckFactory.createRedheadDuck());
        simulate(countingDuckFactory.createRubberDuck());

        System.out.println("The ducks quacked " + (QuackCounter.getQuacks() - oldCount) + " times");

        oldCount += QuackCounter.getQuacks() - oldCount;
        System.out.println();

// **********************************************

        System.out.println("**** Counting Echoed Duck Factory ****");
        CountingEchoedDuckFactory countingEchoedDuckFactory = new CountingEchoedDuckFactory();
        simulate(countingEchoedDuckFactory.createMallardDuck());
        simulate(countingEchoedDuckFactory.createRedheadDuck());
        simulate(countingEchoedDuckFactory.createRubberDuck());

        System.out.println("The ducks quacked " + (QuackCounter.getQuacks() - oldCount) + " times");

        oldCount += QuackCounter.getQuacks() - oldCount;
        System.out.println();

// **********************************************
        System.out.println("**** Flock ****");
        Flock flock = new Flock();
//        flock.add(duckFactory.createMallardDuck());
        flock.add(countingDuckFactory.createMallardDuck());
        flock.add(countingDuckFactory.createRedheadDuck());
        flock.add(countingEchoedDuckFactory.createRubberDuck());

        simulate(flock);

        System.out.println("The ducks quacked " + (QuackCounter.getQuacks() - oldCount) + " times");

        /* If you use duckFactory there should be no counting because,
        DuckFactory has no counter decorator and will give unexpected output
        if try to print QuackCounter.getQuacks() */
    }

    void simulate(Quackable duck) {
        duck.quack();
    }
}