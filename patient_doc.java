interface Hospital{
	public void calling();
}
class Doctor implements Hospital{
	public void calling(){
	System.out.println("Doctor treats patients");
	}
}
class Patient implements Hospital{
	public void calling(){
		System.out.println("Patient takes medication from a Doctor");
	}
}
class patient_doc{
	public static void main(String[] args){
	Doctor d =new Doctor();
	Patient p=new Patient();
	d.calling();
	p.calling();
	}
}