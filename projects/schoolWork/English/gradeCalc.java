package English;

public class gradeCalc {
	static double assesa = 44.4; //2nd vocab quiz    
	static double assesb = 45;
	static double assesWeight = 3; 
	static double forma = 109.2; //two additions to the formative 
	static double formb = 127.5; 
	static double formWeight = 2; 
	static double wra = 95.8; //assuming 95 percent on new essay 
	static double wrb = 100; 
	static double wrWeight = 5; 
	public static void main(String args[]) {
		double assesP = assesa / assesb; 
		//assesP = ; 
		double assesFinal = (assesP) * assesWeight;
		double formP = forma/formb; 
		//formP = .86;
		double formFinal = (formP) * formWeight; 
		double wrP = wra/wrb; 
		//wrP = .9325;
		double wrFinal = wrP * wrWeight; 
		double fGrade = (assesFinal+formFinal+wrFinal)/(assesWeight+formWeight+wrWeight);
		System.out.println((assesP*100));
		System.out.println((formP*100));
		System.out.println((wrP*100));
		System.out.println((fGrade*100)); 
	}
}
