package MyFirstRestaurant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class West2FriedChickenRestauran implements FriedChickenRestaurant {
    private double balance;
    //ʹ��linkedlist����Ϊ�����Է���ɾ��
    private LinkedList<Beer> beerArray;
    private LinkedList<Juice> juiceArray;
    //ʹ��arraylist����Ϊ�����Է����ѯ
    private  static ArrayList <SetMeal> mealList;
    static {
    	mealList=new ArrayList<>();
    	mealList.add(new SetMeal("�ײ�1",30.00,"˱ָԭζ��", new Beer("ѩ��ơ��", 12.00, LocalDate.now(), 30,15)));
    	mealList.add(new SetMeal("�ײ�2",25.00,"˱ָԭζ��",new Juice("������", 7.00, LocalDate.now(), 30)));
    	mealList.add(new SetMeal("�ײ�3",40.00,"����ը��",new Beer("�ൺơ��", 12.00, LocalDate.now(), 30,15)));
    	mealList.add(new SetMeal("�ײ�4",35.00,"˱ָԭζ��",new Juice("�ɿڿ���", 7.00, LocalDate.now(), 30)));
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
    	mealList.add(new SetMeal("�ײ�1",30.00,"˱ָԭζ��", new Beer("ѩ��ơ��", 12.00, LocalDate.now(), 30,15)));
    	mealList.add(new SetMeal("�ײ�2",25.00,"˱ָԭζ��",new Juice("������", 7.00, LocalDate.now(), 30)));
    	mealList.add(new SetMeal("�ײ�3",40.00,"����ը��",new Beer("�ൺơ��", 12.00, LocalDate.now(), 30,15)));
    	mealList.add(new SetMeal("�ײ�4",35.00,"˱ָԭζ��",new Juice("�ɿڿ���", 7.00, LocalDate.now(), 30)));
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
			throw new IngredientSortOutException(beer.getDrinksName()+"û����Ŷ~");
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
			throw new IngredientSortOutException(juice.getDrinksName()+"û����Ŷ~,������ѡ��");
		}
	}
	


	@Override
	public void sale() throws IngredientSortOutException{
		Scanner sc=new Scanner(System.in);
		for(SetMeal meal:mealList) {
			System.out.println(meal.toString());
		}
		System.out.println("��ѡ���ײͣ�����1��2��3��4");
		int num=sc.nextInt();
		sc.close();
		boolean hasMeal=false;
		String mealName="�ײ�"+num;
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
			throw new IngredientSortOutException("�Ҳ�������ײ͚G");
		}
		
	}

	@Override
	public void replenish() {
		Scanner sc=new Scanner(System.in);
		System.out.println("����Ҫ��ʲô����1.ѩ��ơ�ƣ�2.�ൺơ�ƣ�3.�����ȣ�4.�ɿڿ��֣��������Ӧ���");
		int num=sc.nextInt();
		System.out.println("��������������:��ʽXXXX-YY-ZZ");
		String time=sc.nextLine();
		switch (num) {
		case 1:
			beerArray.add(new Beer("ѩ��ơ��", 12.00, LocalDate.parse(time), 30,15));
			break;
		case 2:
			beerArray.add(new Beer("�ൺơ��", 12.00, LocalDate.parse(time), 30,15));
			break;
		case 3:
			juiceArray.add(new Juice("������", 7.00, LocalDate.parse(time), 30));
			break;
		case 4:
			juiceArray.add(new Juice("�ɿڿ���", 7.00, LocalDate.parse(time), 30));
			break;
		default:
				System.out.println("����������Χ��Ŷ��������ѡ��һ��");
				break;
	}

}
	}
