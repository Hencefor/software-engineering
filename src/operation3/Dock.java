package operation3;
import java.io.Serializable;
public class Dock implements Serializable{
	
	//boolean[] latch= {true,true,true,true,true,false,false,false};
	boolean[] latch= {true,true,true,true,true,false,false,false};
	int i;
	String dockId;
	
	public int releaseScooter()/*turn one latch to false if there is a latch has scooter(in order),return the position of latch */
	{
		int position=0;
		
		try {
			while(position<=8)
			{
				
				if(latch[position]==true)
				{
					latch[position]=false;
					break;
				}
				position++;
				
			}
		}
		
		catch(Exception e)
		{
			System.out.println("error in release");
			return -1;
		}
		return position;
		
	}
	public int retrieveScooter()/*turn one latch to true if there is a empty latch, return the postion of the latchf*/
	{
		int position=0;
		try {
			while(position<=8)
			{
				if(latch[position]==false)
				{
					latch[position]=true;
					break;
				}
				position++;
			}
		}
		catch(Exception e)
		{
			System.out.println("error in retrieve");
			return -1;
		}
		
		
		return position;
	}
	
	public void scan()
	{
		
	}
	public boolean isEmpty()/*if empty return false, else return true*/
	{
		int count=0;
		for(i=0;i<8;i++)
		{
			if(latch[i]==false)
			{
				count++;
			}
		}
		if(count<8 && count>=0)
		{
			return false;
		}
		else if(count==8)
		{
			return true;
		}
		return false;
	}
	
	public boolean isFull()/*if full, return true, else return false*/
	{
		int count=0;
		for(i=0;i<8;i++)
		{
			if(latch[i]==true)
			{
				count++;
			}
		}
		if(count==8)
		{
			return true;
		}
		else if(count<8)
		{
			return false;
		}
		return false;
	}

	
	public static void main(String[] args)
	{
		Dock a = new Dock();
		System.out.println(a.isEmpty()+""+a.isFull()+""+a.releaseScooter());
	}
}



