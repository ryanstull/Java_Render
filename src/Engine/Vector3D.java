package Engine;

public class Vector3D{

	public static final Vector3D X_AXIS = new Vector3D(1,0,0);
	public static final Vector3D Y_AXIS = new Vector3D(0,1,0);
	public static final Vector3D Z_AXIS = new Vector3D(0,0,1);
	
	public double x;
	public double y;
	public double z;
	
	public Vector3D() {
		x=y=z=1;
	}

	public Vector3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3D(Vector3D in){
		this.x=in.x;
		this.y=in.y;
		this.z=in.z;
	}
	
	public Vector3D add(Vector3D in){
		this.x+=in.x;
		this.y+=in.y;
		this.z+=in.z;
		return this;
	}
	
	public Vector3D subtract(Vector3D in){
		this.x-=in.x;
		this.y-=in.y;
		this.z-=in.z;
		return this;
	}
	
	public Vector3D multiply(double num){
		this.x*=num;
		this.y*=num;
		this.z*=num;
		return this;
	}
	
	public Vector3D divide(double num){
		this.x/=num;
		this.y/=num;
		this.z/=num;
		return this;
	}
	
	public Vector3D negate(){
		this.x*=-1;
		this.y*=-1;
		this.z*=-1;
		
		return this;
	}
	
	public double dotProduct(Vector3D in){
		return this.x*in.x+this.y*in.y+this.z*in.z;
	}
	
	public double angleWithCrs(Vector3D in){
		return Math.asin(this.crossProduct(in).magnitude()/(this.magnitude()*in.magnitude()));
	}
	
	public double angleWith(Vector3D in){
		double dot = new Vector3D(this).dotProduct(in);
		return Math.acos(dot/(magnitude()*in.magnitude()));
	}
	
	public Vector3D crossProduct(Vector3D in){
		Vector3D rtrn = new Vector3D();
		rtrn.x = y*in.z-z*in.y;
		rtrn.y = z*in.x-x*in.z;
		rtrn.z = x*in.y-y*in.x;
		return rtrn;
	}
	
	public Vector3D normalize(){
		return divide(magnitude());
	}
	
	public Vector3D projection(Vector3D in){
		return new Vector3D(in).multiply(this.dotProduct(in)/Math.pow(in.magnitude(),2));
	}
	
	public double magnitude(){
		return Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2));
	}
	
	public Vector3D unitVector(){
		return new Vector3D(this).divide(magnitude());
	}
	
	@Override
	public String toString(){
		return "[x:"+x+",y:"+y+",z:"+z+"]";
	}
}