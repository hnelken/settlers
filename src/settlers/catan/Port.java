package settlers.catan;

public class Port {
	
	private Resource type;
	private Edge e;
	
	public Port(Resource type,Edge e){
		this.type = type;
		this.e = e;
	}
	
	public Resource getType(){
		return type;
	}
	
	public Edge getEdge(){
		return e;
	}
}
