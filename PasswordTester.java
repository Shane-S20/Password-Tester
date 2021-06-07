import java.util.Scanner;
import java.security.SecureRandom;

public class PasswordTester
{
    //Generating a secure password in case the input is detected to be a common password
    public static String securePassword;

    public static String generateSecurePassword(int length)
    {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*_-+";
        SecureRandom random = new SecureRandom();
        StringBuilder text = new StringBuilder();
        for(int x = 0; x < length; x++)
        {
            int randomIndex = random.nextInt(chars.length());
            text.append(chars.charAt(randomIndex));
        }
        securePassword = text.toString();
        return securePassword;
    }

    public static void main(String[] args)
    {
        //Gathers input from the user
        Scanner input = new Scanner(System.in);
        System.out.print("*** Welcome to the CSC 161 Password Verifier! *** \nPlease input a string to test: ");
        String text = input.nextLine();
        input.close();
        text = text.toLowerCase();
        //Puts the input into a char array.
        //For example, the word dog would be {'d','o','g'} in the array
        //Our alphabet in this case would be letters a-z and numbers 0-9
        char[] textArray = text.toCharArray();
        int i = 0;

        //Calls the generateSecurePassword function to create a random password of length 10 
        //This length value can be changed to the user's desire
        generateSecurePassword(10);

        //Some of the most common passwords that are tested in this program
        //1234
        //12345
        //qwerty
        //batman
        //654321
        //dragon
        //abc123
        //password
        //12345678
        //football
        //Source: https://www.passwordrandom.com/most-popular-passwords

        //The Finite State Machine
        while(i < textArray.length)
        {
            //State 0 (Initial State)
           if(textArray[i] == 'p' ||  textArray[i] == '1' || textArray[i] == 'q' || textArray[i] == '6' || textArray[i] == 'd' || textArray[i] == 'f' || textArray[i] == 'a' || textArray[i] == 'b')
            {
                i++;
                //State 1
                if(textArray[i] == 'a' || textArray[i] == '2' || textArray[i] == 'w' || textArray[i] == '5' || textArray[i] == 'r' || textArray[i] == 'o' || textArray[i] == 'b')
                {
                    i++;
                    //State 2
                    if(textArray[i] == 's' || textArray[i] == '3' || textArray[i] == 'e' || textArray[i] == '4' || textArray[i] == 'a' || textArray[i] == 'o' || textArray[i] == 'c' || textArray[i] == 't')
                    {
                        i++;
                        //State 3
                        if(textArray[i] == 's' || textArray[i] == '4' || textArray[i] == 'r' || textArray[i] == '3' || textArray[i] == 'g' || textArray[i] == 't' || textArray[i] == '1' || textArray[i] == 'm')
                        {
                            //State 4
                            if(textArray[i] == '4' && textArray[textArray.length-1] == '4')
                            {
                                System.out.println("Common password \"1234\" was detected. Seriously?! This is a terrible password! Why do people use this?");
                                break;
                            }
                            else
                            {
                                i++;
                            }
                            //State 5
                            if(textArray[i] == 'w' || textArray[i] == '5' || textArray[i] == 't' || textArray[i] == '2' || textArray[i] == 'o' || textArray[i] == 'b' || textArray[i] == 'a')
                            {
                                //State 6
                                if(textArray[i] == '5' && textArray[textArray.length-1] == '5')
                                {
                                    System.out.println("Common password \"12345\" was detected. You need to use more than just numbers. You're making this too easy!");
                                    break;
                                }                       
                                i++;
                                //State 7
                                if(textArray[i] == 'o' || textArray[i] == '6' || textArray[i] == 'y' || textArray[i] == '1' || textArray[i] == 'n' || textArray[i] == 'a' || textArray[i] == '3')
                                {
                                    if(textArray[i] == 'y')
                                    {
                                        System.out.println("Common password \"qwerty\" was detected. You need more than just one row of keys!");
                                        break;
                                    }
                                    if(textArray[i] == '6' && textArray[textArray.length-1] == '6')
                                    {
                                        System.out.println("Common password \"123456\" was detected. Really? Just 123456? I hope this isn't a real password of yours...");
                                        break;
                                    }
                                    if(textArray[i] == '1')
                                    {
                                        System.out.println("Common password \"654321\" was detected. You really thought backwards numbers would work? Nice try.");
                                        break;
                                    }
                                    if(textArray[i] == 'n')
                                    {
                                        if(textArray[0] == 'd')
                                        {
                                            System.out.println("Common password \"dragon\" was detected. You thought this would scare off hackers? Not a chance.");
                                            break;
                                        }
                                        else
                                        {
                                            System.out.println("Common password \"batman\" was detected. Not even batman is safe against hackers.");
                                            break;
                                        }
                                    }
                                    if(textArray[i] == '3')
                                    {
                                        System.out.println("Common password \"abc123\" was detected. Letters and numbers make a good password, but this is way too obvious!");
                                        break;
                                    }
                                    else
                                    {
                                        i++;
                                    }
                                    //State 8
                                    if(textArray[i] == 'r' || textArray[i] == '7' || textArray[i] == 'l')
                                    {
                                        i++;
                                        //State 8 (Final)
                                        if (textArray[i] == 'd' || textArray[i] == '8' || textArray[i] == 'l')
                                        {
                                            if(textArray[i] == 'd')
                                            {
                                                System.out.println("Common password \"password\" was detected. The most generic password of them all. If you use this password then I'll be shocked if your bank account hasn't been compromised yet.");
                                                break;
                                            }
                                            if(textArray[i] == '8')
                                            {
                                                System.out.println("Common password \"12345678\" was detected. So 123456 wasn't enough for you huh?");
                                                break;
                                            }
                                            if(textArray[i] == 'l')
                                            {
                                                System.out.println("Common password \"football\" was detected. This password is a fumble.");
                                                break;
                                            }
                                            else
                                            {
                                                System.out.println("The input was not detected to be a common password, well done! Since the input could still be an unlisted common password, here's an alternative password you could use.");
                                            }
                                        }
                                        else break;
                                    }
                                    else break;
                                }
                                else break;
                            }
                            else break;
                        }
                        else break;
                    }
                    else break;
                }
                else break;
            }
           else break;
        }
        System.out.println("Randomly generated password: \"" + securePassword + "\" could be a better alternative.");
    }
}