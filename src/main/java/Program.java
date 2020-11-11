import com.google.gson.*;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Program {
    public static void main(String[] args) throws FileNotFoundException{
        JsonForm[] jsonForms= new JsonForm[0];

        File file = new File("/Users/Julia/Desktop/test.json");

        BufferedReader reader = null;
        Numbers numbers = new Numbers();
        try {
            reader = new BufferedReader(new FileReader(file));
            Gson gson1 = new Gson();
             jsonForms = gson1.fromJson(reader, JsonForm[].class);
        } catch (FileNotFoundException ex) {
            System.out.println("error");
        } finally {
            int n =jsonForms.length;
            int space;
            int[] input1 = new int[n];
            int[] input2 = new int[n];
            int[] output = new int[n];

            for(int i=0;i<n;i++) {
                space = jsonForms[i].getInput().indexOf(" ");
                String helps1=jsonForms[i].getInput().toString().substring(0,space);
                String helps2 = jsonForms[i].getInput().toString().substring(space+1);
                input1[i]=Integer.parseInt(helps1);
                input2[i]=Integer.parseInt(helps2);
                output[i]=Integer.parseInt(jsonForms[i].getOutput().toString());

                System.out.println(input1[i] + " "+ input2[i]+ " "+ jsonForms[i].getOutput());
               output[i] = numbers.sum(input1[i], input2[i]);
                if ( output[i]== Integer.parseInt(jsonForms[i].getOutput())) {
                    System.out.println("Test№" +(i+1) + " " +input1[i]+" "+
                            input2[i]+" " + Integer.parseInt(jsonForms[i].getOutput()));
                    System.out.println("Test right!");
                } else {
                    System.out.println("Error\n wrong answer " + (i+1) + " test " + " we got : "+ output[i] + " expected :" + Integer.parseInt(jsonForms[i].getOutput())+"\n");
                }
            }
        }

    }
}
class JsonForm{

    public String getInput() {
        return input;
    }
    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }
    public void setOutput(String output) {
        this.output = output;
    }

    private String input;
    private String output;
    public JsonForm(){}
}

