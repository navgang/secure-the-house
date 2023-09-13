import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class secure_house
{
	public static void main(String[] args)
	{
		String owner_name = args[0];
		String key = "";
		//Scanner scan = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		int arrayLength = args.length;
		String[] keys = new String[arrayLength - 1];
		ArrayList<String> tempList = new ArrayList<String>();
		ArrayList<String> people = new ArrayList<String>();
		String keyInserted = "";
		String person = "";
		String rightPerson = "";
		String person_turn = "";
		boolean inside = false;
		boolean rightKey = false;

		/*for(int i = 0; i < people.size(); i++)
		{
			System.out.println(people.get(i));
		}*/

		for(int i = 1; i < args.length; i++)
		{
			keys[i - 1] = args[i];
		}
		//System.out.println("check" + args[1]);
		
		/*for(int i = 0; i < keys.length; i++)
		{
		    System.out.println(keys[i]);
		}*/
		
		try
		    {
			input = "a";

			while(input != null)
		{
		        input = br.readLine();
			if(input == null)
			    {
				break;
			    }
			//System.out.println("check" + input);
			String[] array = input.split(" ", 0);
			//System.out.println(array);

			if(array[0].equals("INSERT"))
			{
				System.out.println("KEY " + array[3] + " INSERTED BY " + array[2]);
				person = array[2];
				//System.out.println(people);
				keyInserted = array[3];
				//System.out.println(keyInserted);
			}
            
			else if(array[0].equals("TURN"))
			{
				person_turn = array[2];
			    //System.out.println("check:" + keyInserted);
			    rightKey = false;
			    for(int i = 0; i < keys.length; i++)
			    {
				String arrayValue = keys[i];
				/*if(keys[i] != null)
				{
					System.out.println(keys[i]);
				}
				else
				{
					System.out.println("key is null");
					}
			        if(arrayValue == null)
			        {
			            arrayValue = "";
				    }*/
			        if(arrayValue.equals(keyInserted))
			        {
			            rightKey = true;
					}
				//System.out.println("check: " + keys[i]);
			    }
			    
			    //System.out.println(rightKey);
				if(rightKey == true && person_turn.equals(person))
				{
					System.out.println("SUCCESS " + person_turn + " TURNS KEY " + keyInserted);
					rightPerson = person_turn;
				}
					
				else
				{
				    System.out.println("FAILURE " + person_turn + " UNABLE TO TURN KEY " + keyInserted);
				}

			}
			
			else if (array[0].equals("ENTER"))
			{
			    person_turn = array[2];
			    if(rightKey == true && rightPerson.equals(person_turn))
			    {
			        System.out.println("ACCESS ALLOWED");
					//inside = true;
					people.add(person);
			    }
			    else
			    {
			        System.out.println("ACCESS DENIED");
			    }
			}

			else if(array[0].equals("WHO'S"))
			{
			    String str = "";
			        if(people.size() != 0)
				{
				    //people.add(person);
				    //System.out.println(people);
				    for(int i = 0; i < people.size(); i++)
				    {
					str = String.join(", ", people);
				    }
				    System.out.println(str);
				}
				else
				{
					System.out.println("NOBODY HOME");
				}
			}

			else if(array[0].equals("LEAVE"))
			{
			    person_turn = array[2];
			    inside = false;
			    for(int i = 0; i < people.size(); i++)
			    {
				String str1= people.get(i);
				if(str1.equals(person_turn))
				    {
					inside = true;
				    }
			    }
				if(inside == true)
				{
					people.remove(person_turn);
					System.out.println("OK");
					inside = false;
				}
				else
				{
					System.out.println(person_turn + " NOT HERE");
				}
			 }

			else if(array[0].equals("CHANGE"))
			{
			    for(int i = 0; i < people.size(); i++)
				{
					//String str2 = people.get(i);
				person_turn = array[2];
				String str2 = people.get(i);
				//System.out.println(Arrays.toString(array));
				//System.out.println(Arrays.toString(keys));
					if(str2.equals(person_turn))
					{
						 inside = true;
					}
				}
			    //System.out.println(owner_name);
			    if(person_turn.equals(owner_name))
				{
					for(int k = 3; k < array.length; k++)
					{
					    tempList.add(array[k]);
						//j++;
					}
						keys = tempList.toArray(keys);
						System.out.println("OK");
				}

				else
				{
					System.out.println("ACCESS DENIED");
				}
			}
				
			else
			    {
				System.out.println("ERROR");
			    }
		}
		    }
		catch(IOException e)
		    {
			e.printStackTrace();
		    }
	}
}
