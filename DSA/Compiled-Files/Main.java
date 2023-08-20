class Pattern {
    public void printPattern(int n) {
        for (int i = n; i > 0; i--) {
            System.out.println('*' * i);
        }
    }
}

class PatternCheck {
    public void printPattern(int n) {
        for (int i = n; i > 0; i--) {
            System.out.println('*' * i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Pattern pObj = new Pattern();
        PatternCheck pcObj = new PatternCheck();
        pObj.printPattern(5);
        pcObj.printPattern(10);
    }
}