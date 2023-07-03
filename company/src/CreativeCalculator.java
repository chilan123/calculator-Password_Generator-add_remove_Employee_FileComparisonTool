import java.util.Scanner;

public class CreativeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Creative Calculator!");

        boolean exit = false;
        while (!exit) {
            System.out.print("Enter an expression (e.g., 2 + 5): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                exit = true;
                continue;
            }

            String[] tokens = input.split(" ");

            if (tokens.length != 3) {
                System.out.println("Invalid expression! Please try again.");
                continue;
            }

            try {
                double operand1 = Double.parseDouble(tokens[0]);
                String operator = tokens[1];
                double operand2 = Double.parseDouble(tokens[2]);

                double result;
                switch (operator) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        result = operand1 / operand2;
                        break;
                    case "%":
                        result = operand1 % operand2;
                        break;
                    case "^":
                        result = Math.pow(operand1, operand2);
                        break;
                    default:
                        System.out.println("Invalid operator! Please try again.");
                        continue;
                }

                System.out.println("Result: " + result);
            } catch (NumberFormatException e) {
                System.out.println("Invalid operands! Please try again.");
            }
        }

        System.out.println("Thank you for using the Creative Calculator!");
        scanner.close();
    }
}

