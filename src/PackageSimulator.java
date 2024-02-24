import java.util.ArrayList;
public class PackageSimulator
{
    private ArrayList<Package> packages;

    public PackageSimulator()
    {
        this.packages = new ArrayList<Package>();
    }

    public void generatePackages(int numberToGenerate)
    {
        for(int i = 0; i < numberToGenerate; i++)
        {
            String originZipCode = String.valueOf((int) (501 + Math.random() * (99950 - 501 + 1)));
            Address origin = new Address("123", "Random Street", "3C", "City", "State", originZipCode);
            String destinationZipCode = String.valueOf((int) (501 + Math.random() * (99950 - 501 + 1)));
            Address destination = new Address("123", "Random Street", "3C", "City", "State", destinationZipCode);
            double weight = 1 + Math.random() * (70 - 1 + 1);
            double maximumSize = 108.0;
            double length = 6 + Math.random() * (maximumSize - 6 + 1);
            maximumSize -= length;
            double height = 3 + Math.random() * (maximumSize - 3 + 1);
            maximumSize -= height;
            double width = 0.25 + Math.random() * (maximumSize - 0.25 + 1);
            Package newPackage = new Package(origin, destination, weight, length, height, width);
            packages.add(newPackage);
        }
    }

    public double generateTotalCost()
    {
        int totalCost = 0;
        for(Package packageShipped : packages)
        {
            totalCost += ((int) (PostageCalculator.calculatePostage(packageShipped) * 100));
        }
        return((double) totalCost / 100);
    }

    public void getSimulationInfo()
    {
        int packageNumber = 1;
        for(Package packageInfo : packages)
        {
            System.out.println("Package " + packageNumber + ": ---------------------------------------------");
            System.out.println("Origin address: " + packageInfo.getOrigin().toString());
            System.out.println("Destination address: " + packageInfo.getDestination().toString());
            System.out.println("Weight: " + packageInfo.getWeight() + " pounds");
            System.out.println("Length: " + packageInfo.getLength() + " inches");
            System.out.println("Height: " + packageInfo.getHeight() + " inches");
            System.out.println("Width: " + packageInfo.getWidth() + " inches");
            System.out.println("Cost: $" + PostageCalculator.calculatePostage(packageInfo));
            packageNumber++;
        }
    }

    public void resetSimulation()
    {
        this.packages = new ArrayList<Package>();
    }
}