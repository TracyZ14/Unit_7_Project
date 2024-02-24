public class PostageCalculator
{
    public static double calculatePostage(String zipCode1, String zipCode2, double weight, double length, double height, double width)
    {
        double cost = 3.75;
        cost += calculateCostForWeight(weight);
        cost += calculateCostForDistance(zipCode1, zipCode2);
        cost += calculateCostForSize(length, height, width);
        return cost;
    }

    public static double calculatePostage(Address origin, Address destination, double weight, double length, double height, double width)
    {
        double cost = 3.75;
        cost += calculateCostForWeight(weight);
        String zipCode1 = origin.getZipCode();
        String zipCode2 = destination.getZipCode();
        cost += calculateCostForDistance(zipCode1, zipCode2);
        cost += calculateCostForSize(length, height, width);
        return cost;
    }

    public static double calculatePostage(Package packageShipped)
    {
        double cost = 3.75;
        double weight = packageShipped.getWeight();
        cost += calculateCostForWeight(weight);
        String zipCode1 = packageShipped.getOrigin().getZipCode();
        String zipCode2 = packageShipped.getDestination().getZipCode();
        cost += calculateCostForDistance(zipCode1, zipCode2);
        double length = packageShipped.getLength();
        double height = packageShipped.getHeight();
        double width = packageShipped.getWidth();
        cost += calculateCostForSize(length, height, width);
        return cost;
    }

    public static double calculateCostForWeight(double weight)
    {
        if(weight <= 40.0)
        {
            int tenths = (int) (weight * 10);
            if((weight * 10) > tenths)
            {
                tenths++;
            }
            return(tenths * 0.05);
        }
        else
        {
            int exceededTenths = (int) ((weight - 40) * 10);
            if(((weight - 40) * 10) > exceededTenths)
            {
                exceededTenths++;
            }
            return(((40 * 10) * 0.05) + (exceededTenths * 0.1));
        }
    }

    public static double calculateCostForDistance(String zipCode1, String zipCode2)
    {
        int countryCode1 = Integer.parseInt(zipCode1.substring(0, 3));
        int countryCode2 = Integer.parseInt(zipCode2.substring(0, 3));
        int difference = countryCode1 - countryCode2;
        if(difference < 0)
        {
            difference *= -1;
        }
        return((double) difference / 100);
    }

    public static double calculateCostForSize(double length, double height, double width)
    {
        double combinedDimension = length + height + width;
        if(combinedDimension > 36)
        {
            int exceededInches = (int) combinedDimension - 36;
            if((combinedDimension - 36) > 0)
            {
                exceededInches++;
            }
            return(exceededInches * 10.0);
        }
        return 0.0;
    }
}