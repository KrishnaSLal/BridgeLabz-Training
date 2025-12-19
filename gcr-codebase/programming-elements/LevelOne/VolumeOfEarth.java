public class VolumeOfEarth{
       public static void main(String[]args){
	   
	   int radiusKM =  6378;
	   double radiusMiles = radiusKM * 1.6;
	   
	   //Calculating the volume of the sphere(The Earth)using the formula : (4/3) * pi * r^3.
	   double VolumeKM = 4/3* Math.PI* Math.pow(radiusKM,3);
	   double VolumeMiles = 4/3*Math.PI*Math.pow(radiusMiles,3);
	   
	   System.out.println("The volume of earth in cubic kilometers is " + VolumeKM + " and cubic miles is " + VolumeMiles);
	   
	   }
}