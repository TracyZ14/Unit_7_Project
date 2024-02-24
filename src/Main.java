import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String nextAction = "";
        while(!nextAction.equals("4"))
        {
            System.out.println("---------------------------------------------");
            System.out.println("What would you like to do?");
            System.out.println("1. Calculate cost of one package.");
            System.out.println("2. Simulate packages.");
            System.out.println("3. How package costs are calculated.");
            System.out.println("4. Exit.");
            System.out.print("Input: ");
            nextAction = s.nextLine();
            System.out.println("---------------------------------------------");
            if(nextAction.equals("1"))
            {
                System.out.print("Enter the zip code of the origin package: ");
                String originZipCode = s.nextLine();
                System.out.print("Enter the zip code of the destination package: ");
                String destinationZipCode = s.nextLine();
                System.out.print("Enter the weight of the package: ");
                double weight = Double.parseDouble(s.nextLine());
                System.out.print("Enter the length of the package: ");
                double length = Double.parseDouble(s.nextLine());
                System.out.print("Enter the height of the package: ");
                double height = Double.parseDouble(s.nextLine());
                System.out.print("Enter the width of the package: ");
                double width = Double.parseDouble(s.nextLine());
                System.out.println("Cost: $" + PostageCalculator.calculatePostage(originZipCode, destinationZipCode, weight, length, height, width));
            }
            if(nextAction.equals("2"))
            {
                PackageSimulator simulation = new PackageSimulator();
                System.out.print("How many packages would you like to simulate? ");
                int packagesToSimulate = Integer.parseInt(s.nextLine());
                simulation.generatePackages(packagesToSimulate);
                System.out.println("Randomly generated packages info:");
                simulation.getSimulationInfo();
                System.out.println("---------------------------------------------");
                System.out.println("Total cost of all packages: $" + simulation.generateTotalCost());
            }
            if(nextAction.equals("3"))
            {
                System.out.println("How packages are being calculated:");
                System.out.println("1. Base cost");
                System.out.println("   The base cost for shipping each package is $3.75.");
                System.out.println("2. Distance");
                System.out.println("   The zip codes for the origin address and the destination address are taken and converted into country codes.");
                System.out.println("     (The country code is the first three digits of the zip code.)");
                System.out.println("   The final cost is increased by the difference in country codes and divided by 100.");
                System.out.println("   The difference in country codes is divided by 100 and added to the final cost.");
                System.out.println("3. Weight");
                System.out.println("   The final cost is increased by five cents for each tenth of a pound it weights.");
                System.out.println("   However, if the package is over 40 pounds, it is considered to be an oversize package.");
                System.out.println("   The final cost is increased by five cents for each tenth of a pound below the 40 pound limit for an oversize package.");
                System.out.println("   The final cost is increased by ten cents for each tenth of a pound over the 40 pound limit for an oversize package.");
                System.out.println("4. Size");
                System.out.println("   The final cost is not increased if the combined dimensions of the package is 36 inches or less.");
                System.out.println("     (The dimensions of a package are the length, height, and width in inches.)");
                System.out.println("   However, if the combined dimensions is over 36 inches, it is considered to be an oversize package.");
                System.out.println("   The final cost is increased by ten cents for each inch over the combined 36 inch limit for an oversize package.");
            }
        }
    }
}