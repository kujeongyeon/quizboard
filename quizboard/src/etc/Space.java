package etc;

public class Space {
	
	public String delSpace(String str)
    {
        String result = "";
        
        for(int i = 0 ; i < str.length(); i ++)
        {
            if(str.charAt(i) != ' ')
                result += str.charAt(i);
        }
        
        return result;
    }

}
