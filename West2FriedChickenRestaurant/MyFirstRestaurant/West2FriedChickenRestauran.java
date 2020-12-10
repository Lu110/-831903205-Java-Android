package MyFirstRestaurant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class West2FriedChickenRestauran implements FriedChickenRestaurant {
    private double balance;
    //使用linkedlist是因为它可以方便删减
    private LinkedList<Beer> beerArray;
    private LinkedList<Juice> juiceArray;
    //使用arraylist是因为它可以方便查询
    private  static ArrayList <SetMeal> mealList;
    static {
    	mealList=new ArrayList<>();
    	mealList.add(new SetMeal("套餐1",30.00,"吮指原味鸡", new Beer("雪津啤酒", 12.00, LocalDate.now(), 30,15)));
    	mealList.add(new SetMeal("套餐2",25.00,"吮指原味鸡",new Juice("果粒橙", 7.00, LocalDate.now(), 30)));
    	mealList.add(new SetMeal("套餐3",40.00,"豪华炸鸡",new Beer("青岛啤酒", 12.00, LocalDate.now(), 30,15)));
    	mealList.add(new SetMeal("套餐4",35.00,"吮指原味鸡",new Juice("可口可乐", 7.00, LocalDate.now(), 30)));
    } 
    
                            
	public West2FriedChickenRestauran() {
		super();
	}
	

	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public West2FriedChickenRestauran(double balance) {
		super();
		this.balance = balance;
		this.beerArray = new LinkedList<Beer>();
		this.juiceArray = new LinkedList<Juice>();
		mealList=new ArrayList<>();
    	mealList.add(new SetMeal("套餐1",30.00,"吮指原味鸡", new Beer("雪津啤酒", 12.00, LocalDate.now(), 30,15)));
    	mealList.add(new SetMeal("套餐2",25.00,"吮指原味鸡",new Juice("果粒橙", 7.00, LocalDate.now(), 30)));
    	mealList.add(new SetMeal("套餐3",40.00,"豪华炸鸡",new Beer("青岛啤酒", 12.00, LocalDate.now(), 30,15)));
    	mealList.add(new SetMeal("套餐4",35.00,"吮指原味鸡",new Juice("可口可乐", 7.00, LocalDate.now(), 30)));
    } 
	
	public void use(Beer beer) throws IngredientSortOutException{
		boolean found=false;
		for(Iterator<Beer> bb=beerArray.iterator();bb.hasNext();) {
			Beer theBeer=bb.next();
			if(theBeer.getDrinksName().equals(beer.getDrinksName()) &&!theBeer.isStale()) {
				bb.remove();
				found=true;
				break;
			}
		}
		if(!found) {
			throw new IngredientSortOutException(beer.getDrinksName()+"没有了哦~");
		}
	}
	public void use(Juice juice) throws IngredientSortOutException{
		boolean found=false;
		for(Iterator<Juice> uu=juiceArray.iterator();uu.hasNext();) {
			Juice theJuice=uu.next();
			if(theJuice.getDrinksName().equals(juice.getDrinksName()) &&!theJuice.isStale()) {
				uu.remove();
				found=true;
				break;
			}
		}
		if(!found) {
			throw new IngredientSortOutException(juice.getDrinksName()+"没有了哦~,请重新选择");
		}
	}
	


	@Override
	public void sale() throws IngredientSortOutException{
		Scanner sc=new Scanner(System.in);
		for(SetMeal meal:mealList) {
			System.out.println(meal.toString());
		}
		System.out.println("请选择套餐，输入1，2，3，4");
		int num=sc.nextInt();
		sc.close();
		boolean hasMeal=false;
		String mealName="套餐"+num;
		SetMeal chooseMeal = null;
		for(Iterator<SetMeal> mm=mealList.iterator();mm.hasNext();) {
			SetMeal theMeal=mm.next();
			if(theMeal.getMealName().equals(mealName)) {
				hasMeal=true;
				chooseMeal=theMeal;
				break;
			}
		}
		if(hasMeal) {
			Drinks drinkType=chooseMeal.getType();
			if(drinkType instanceof Beer) {
				Beer beer=(Beer)drinkType;
				use(beer);
				balance+=chooseMeal.getPrice();
			}else if(drinkType instanceof Drinks) {
				Juice juice=(Juice)drinkType;
				use(juice);
				balance+=chooseMeal.getPrice();
			}
		}else {
			throw new IngredientSortOutException("找不到这个套餐欸");
		}
		
	}

	@Override
	public void replenish() {
		Scanner sc=new Scanner(System.in);
		System.out.println("请问要进什么货，1.雪津啤酒，2.青岛啤酒，3.果粒橙，4.可口可乐，请输入对应序号");
		int num=sc.nextInt();
		System.out.println("请输入生产日期:格式XXXX-YY-ZZ");
		String time=sc.nextLine();
		switch (num) {
		case 1:
			beerArray.add(new Beer("雪津啤酒", 12.00, LocalDate.parse(time), 30,15));
			break;
		case 2:
			beerArray.add(new Beer("青岛啤酒", 12.00, LocalDate.parse(time), 30,15));
			break;
		case 3:
			juiceArray.add(new Juice("果粒橙", 7.00, LocalDate.parse(time), 30));
			break;
		case 4:
			juiceArray.add(new Juice("可口可乐", 7.00, LocalDate.parse(time), 30));
			break;
		default:
				System.out.println("超出供货范围了哦，请重新选择一下");
				break;
	}

}
	}
