package pacotaogames;

public class TesteIntegerConversor {

	public static void main(String[] args) {
		
		Integer id = 5;
		
		new TesteIntegerConversor().integerConvesation(id);
	}
	
	@SuppressWarnings("static-access")
	public void integerConvesation(Object object){
		
		System.out.println(object.toString().valueOf(object.toString()));
	}

}
