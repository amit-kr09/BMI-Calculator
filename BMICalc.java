import java.util.Scanner;

/**
 * BMICalc
 */
/**
 * BMI
 */
class BMI {

    double length, weight, bmi, minWeight, maxWeight;
    String whatToDo;
    BMI(int length, int weight) {
        this.length = length/100.0; //converting length to meter
        this.weight = weight;
    }
    public double getBmi() {

        bmi =  weight/Math.pow(length, 2); // bmi = weight/(length)^2
        return bmi;
    }
    public String getCategory() {
        if (getBmi()>=40.0) {
            whatToDo = "loose";
            return "Obese (Class III)";
        } 
        else if (getBmi()>=35.0) {
            whatToDo = "loose";
            return "Obese (Class II)";
        }
        else if (getBmi()>=30.0) {
            whatToDo = "loose";
            return "Obese (Class I)";
        }
        else if (getBmi()>=25.0) {
            whatToDo = "loose";
            return "Overweight (Pre-obese)";
        }
        else if (getBmi()>=18.5) {
            whatToDo = "nothing";
            return "Normal range";
        }
        else if (getBmi()>=17.0) {
            whatToDo = "gain";
            return "Underweight (Mild thinness)";
        }
        else if (getBmi()>=16.0) {
            whatToDo = "gain";
            return "Underweight (Moderate thinness)";
        }
        else {
            whatToDo = "gain";
            return "Underweight (Severe thinness)";
        }
    }
    
    public int getMinWeight() {
        minWeight = Math.pow(length, 2)*18.5;
        return ((int)minWeight)+1;
    }
    public int getMaxWeight() {
        maxWeight = Math.pow(length, 2)*24.9;
        return ((int)maxWeight)-1;
    }
    public String getWhatToDo() {
        getCategory();
        return whatToDo;
    }
    public int getGainOrLoose(){
        if (whatToDo != "nothing") {
            if (whatToDo == "loose") {
                return (int)weight - (int)getMaxWeight();
            }
            else {
                return ((int)getMinWeight()) - (int)weight;
            }
        }
        return 0;
    }
}
public class BMICalc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // taking length(cm) and weight(kg) inputs
        System.out.println("Enter your length(cm) : ");
        int length = scanner.nextInt();
        System.out.println("Enter your weight(kg) : ");
        int weight = scanner.nextInt();

        BMI bmi = new BMI(length, weight);

        //print bmi
        System.out.printf("Your Body Mass Index is : %.1f\n", bmi.getBmi());
        
        // print bmi category
        System.out.printf("Your BMI category is : %s\n", bmi.getCategory());

        // print bmi range
        System.out.printf("Weight Range according to your height should be : %d - %d\n",
        bmi.getMinWeight(), bmi.getMaxWeight());

        // print how much to loose or gain weight
        System.out.printf("You have to %s %d to be normal weight.", bmi.getWhatToDo(), bmi.getGainOrLoose());
    }
}