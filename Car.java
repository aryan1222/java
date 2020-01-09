package Lectures;

public class Car implements Comparable <Car>{

	private int speed;
	private int price;
	private String color;
	
	public Car(int Speed,int Price,String color ){
		this.color=color;
		this.speed=Speed;
		this.price=Price;
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "S:"+this.speed+" P:"+this.price+" C:"+this.color;
	}
	public int compareTo(Car o) {
		// TODO Auto-generated method stub
//return this.speed-o.speed;

return  o.price-this.price;
//return this.color.compareTo(o.color);

		
	}
}

