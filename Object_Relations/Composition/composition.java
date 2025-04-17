package Object_Relations.Composition;

class CPU {
    void process() {
        System.out.println("Processing data");
    }
}

class Computer {
    private  CPU cpu;  // Composition

    Computer() {
        this.cpu = new CPU();  // CPU is created INSIDE Computer
    }

    void powerOn() {
        cpu.process();
        System.out.println("Computer is running");
    }
}


