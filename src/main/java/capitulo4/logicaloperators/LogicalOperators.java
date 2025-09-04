package capitulo4.logicaloperators;

public class LogicalOperators {
    public static void main(String[] args) {

        boolean b1 = true;    // Variable booleana con valor verdadero
        boolean b2 = false;   // Variable booleana con valor falso

// AND lógico: solo es true si ambos son true → true && false = false
        System.out.println("b1 && b2: " + (b1 && b2));

// OR lógico: es true si al menos uno es true → true || false = true
        System.out.println("b1 || b2: " + (b1 || b2));

// NOT lógico: invierte el resultado → !(true && false) = !(false) = true
        System.out.println("!(b1 && b2): " + !(b1 && b2));

// AND con operador "&": funciona igual que && pero siempre evalúa ambos lados → true & false = false
        System.out.println("b1 & b2: " + (b1 & b2));

// OR con operador "|": funciona igual que || pero siempre evalúa ambos lados → true | false = true
        System.out.println("b1 | b2: " + (b1 | b2));

// XOR (OR exclusivo): es true solo si los valores son distintos → true ^ false = true
        System.out.println("b1 ^ b2: " + (b1 ^ b2));

    }
}
