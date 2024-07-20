
class sentence{
	public static void main(String args[]){
		String[] sent ={"Red is favorite color.","Orange is also my favorite color."};
			for(int i=0;i<2;i++){
			System.out.print(sent[i]);
			System.out.print("Starts with Red?");
			System.out.println(sent[i].startsWith("Red"));
			}
			
			
	}
}