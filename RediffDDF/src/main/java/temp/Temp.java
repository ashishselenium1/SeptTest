package temp;

public class Temp {

	public static void main(String[] args) {
		long s=20;
		System.out.println(s<15);
		
		int jumper=2;
		String arr[] = new String[21];
		int totalIterations=(int)Math.ceil(((double)arr.length/(double)jumper));
		System.out.println(totalIterations);
		for(int i=0;i<totalIterations;i++) {
			System.out.println("*******************");
			for(int j=i*jumper ;j< (i*jumper)+jumper;j++) {
				if(j<arr.length)
				System.out.println(i+"---"+j);
				else
					System.out.println(i+"****"+j);	
			}
		}

	}

}
